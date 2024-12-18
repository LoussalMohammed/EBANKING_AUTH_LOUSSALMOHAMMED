package org.roleApp.rollApp.app_user.impl;

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
import org.roleApp.rollApp.app_user.service.AppUserService;
import org.roleApp.rollApp.app_user.service.AppUserValidateService;
import org.roleApp.rollApp.shared.dto.response.PageResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Service
@Primary
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AppUserServiceImpl implements AppUserService {
    private final CreateAppUserMapper createAppUserMapper;
    private final UpdateAppUserMapper updateAppUserMapper;
    private final ResponseAppUserMapper responseAppUserMapper;
    private final AppUserRepository userRepository;
    private final AppRoleRepository roleRepository;
    private final AppUserValidateService validateService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseAppUserDTO create(CreateAppUserDTO requestDTO) {
        AppUser user = createAppUserMapper.toE(requestDTO);
        validateService.createValidate(user);

        AppRole role;
        if(requestDTO.role() != null) {
            role = roleRepository.findByName(requestDTO.role());

        } else {

            role = AppRole.builder()
                    .name("ROLE_USER").users(new HashSet<>()).permissions(new HashSet<>()).build();
        }

        user.setRole(role);
        role.getUsers().add(user);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        return responseAppUserMapper.toOT(user);
    }

    @Override
    public PageResponse<ResponseAppUserDTO> findAll(Pageable pageable, Map<String, String> filters) {
        Page<AppUser> page = userRepository.findAll(pageable);
        validateService.findAllValidate(page);
        List<ResponseAppUserDTO> items = page.map(responseAppUserMapper::toOT).toList();
        return PageResponse.of(
                items,
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }

    @Override
    public ResponseAppUserDTO findById(Long id) {
        AppUser user = userRepository.findByIdOrElseThrow(id);
        validateService.findByIdValidate(user);
        return responseAppUserMapper.toOT(user);
    }

    @Override
    public ResponseAppUserDTO updateById(UpdateAppUserDTO updateDTO, Long id) {
        AppUser user = userRepository.findByIdOrElseThrow(id);
        validateService.updateByIdValidate(user, id);
        if(!updateDTO.name().isEmpty()) {
            user.setName(updateDTO.name());
        }

        if(!updateDTO.email().isEmpty()) {
            user.setEmail(updateDTO.email());
        }

        if(!updateDTO.phone().isEmpty()) {
            user.setPhone(updateDTO.phone());
        }

        if(!updateDTO.password().isEmpty()) {
            user.setPassword(updateDTO.password());
        }

        userRepository.save(user);
        return responseAppUserMapper.toOT(user);
    }

    @Override
    public void deleteById(Long id) {
        validateService.deleteByIdValidate(id);
        userRepository.deleteById(id);
    }

    @Override
    public ResponseAppUserDTO addRoleToUser(Long id, Long roleId) {
        AppUser user = userRepository.findByIdOrElseThrow(id);
        AppRole role = roleRepository.findByIdOrElseThrow(roleId);
        user.setRole(role);
        role.getUsers().add(user);
        return responseAppUserMapper.toOT(user);
    }

    @Override
    public ResponseAppUserDTO test(String name) {
        log.info("name: {}", name);
        AppUser user = userRepository.findByName(name);
        log.info("user {}", user);
        return responseAppUserMapper.toOT(user);
    }

}
