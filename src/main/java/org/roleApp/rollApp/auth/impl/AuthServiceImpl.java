package org.roleApp.rollApp.auth.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.app_role.entity.AppRole;
import org.roleApp.rollApp.app_role.repository.AppRoleRepository;
import org.roleApp.rollApp.app_user.dto.request.CreateAppUserDTO;
import org.roleApp.rollApp.app_user.dto.request.UpdateAppUserDTO;
import org.roleApp.rollApp.app_user.dto.response.ResponseAppUserDTO;
import org.roleApp.rollApp.app_user.entity.AppUser;
import org.roleApp.rollApp.app_user.mapper.request.CreateAppUserMapper;
import org.roleApp.rollApp.app_user.mapper.request.UpdateAppUserMapper;
import org.roleApp.rollApp.app_user.mapper.response.ResponseAppUserMapper;
import org.roleApp.rollApp.app_user.repository.AppUserRepository;
import org.roleApp.rollApp.auth.dto.request.LoginRequest;
import org.roleApp.rollApp.auth.service.AuthService;
import org.roleApp.rollApp.auth.service.AuthValidateService;
import org.roleApp.rollApp.shared.dto.response.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthValidateService authValidateService;
    private final AppRoleRepository roleRepository;
    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CreateAppUserMapper createAppUserMapper;
    private final UpdateAppUserMapper updateAppUserMapper;
    private final ResponseAppUserMapper responseAppUserMapper;
    private AuthenticationManager authenticationManager;

    @Autowired
    private void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public ResponseAppUserDTO create(CreateAppUserDTO requestDTO) {
        AppUser user = createAppUserMapper.toE(requestDTO);
        if(requestDTO.role() != null) {
            log.info("role is not empty");
            AppRole role = roleRepository.findByName(requestDTO.role());
            user.setRole(role);
            role.getUsers().add(user);
        } else {
            log.info("role is empty");
            AppRole role = roleRepository.findByName("ROLE_USER");
            if(role != null) {
                user.setRole(role);
                role.getUsers().add(user);
            } else {
                String roleName = "ROLE_USER";
                if(roleRepository.findAll().isEmpty()) {
                    roleName = "ROLE_ADMIN";
                }
                Set<AppUser> users = new HashSet<>();
                users.add(user);
                role = AppRole.builder()
                        .name(roleName)
                        .users(users)
                        .build();
                user.setRole(role);
                roleRepository.save(role);
            }
        }
        user.setPassword(passwordEncoder.encode(requestDTO.password()));
            userRepository.save(user);
        return responseAppUserMapper.toOT(user);
    }

    @Override
    public PageResponse<ResponseAppUserDTO> findAll(Pageable pageable, Map<String, String> filters) {
        return null;
    }

    @Override
    public ResponseAppUserDTO findById(Long id) {
        return null;
    }

    @Override
    public ResponseAppUserDTO updateById(UpdateAppUserDTO updateDTO, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public ResponseAppUserDTO login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password())
        );
        AppUser user = userRepository.findByEmail(authentication.getName());
        return responseAppUserMapper.toOT(user);
    }

    @Override
    public ResponseAppUserDTO updatePassword(String username, String password) {
        AppUser user = userRepository.findByName(username);
        log.info("got user {}", user);
        user.setPassword(password);
        log.info("validating create");
        authValidateService.createValidate(user);
        user.setPassword(passwordEncoder.encode(password));
        log.info("encoding this: {} to encrypted: {}", password, passwordEncoder.encode(password));
        log.info("user data: {}", user);
        userRepository.save(user);
        return responseAppUserMapper.toOT(user);
    }


}
