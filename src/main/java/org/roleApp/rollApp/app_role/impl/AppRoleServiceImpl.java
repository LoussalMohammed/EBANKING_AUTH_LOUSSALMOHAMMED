package org.roleApp.rollApp.app_role.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.app_permission.entity.AppPermission;
import org.roleApp.rollApp.app_permission.repository.AppPermissionRepository;
import org.roleApp.rollApp.app_role.dto.request.CreateAppRoleDTO;
import org.roleApp.rollApp.app_role.dto.request.UpdateAppRoleDTO;
import org.roleApp.rollApp.app_role.dto.response.ResponseAppRoleDTO;
import org.roleApp.rollApp.app_role.entity.AppRole;
import org.roleApp.rollApp.app_role.mapper.request.CreateAppRoleMapper;
import org.roleApp.rollApp.app_role.mapper.request.UpdateAppRoleMapper;
import org.roleApp.rollApp.app_role.mapper.response.ResponseAppRoleMapper;
import org.roleApp.rollApp.app_role.repository.AppRoleRepository;
import org.roleApp.rollApp.app_role.service.AppRoleService;
import org.roleApp.rollApp.app_role.service.AppRoleValidateService;
import org.roleApp.rollApp.shared.dto.response.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AppRoleServiceImpl implements AppRoleService {
    private final CreateAppRoleMapper createMapper;
    private final UpdateAppRoleMapper updateMapper;
    private final ResponseAppRoleMapper responseMapper;
    private final AppRoleRepository roleRepository;
    private final AppPermissionRepository permissionRepository;
    private final AppRoleValidateService roleValidateService;

    @Override
    public ResponseAppRoleDTO create(CreateAppRoleDTO requestDTO) {
        AppRole role = createMapper.toE(requestDTO);
        roleValidateService.createValidate(role);
        if(!requestDTO.permission().isEmpty()) {
            requestDTO.permission().forEach(
                    permissionName -> {
                        AppPermission permission = permissionRepository.findByName(permissionName);
                        role.getPermissions().add(permission);
                        permission.getRoles().add(role);
                    }
            );

        }
        roleRepository.save(role);
        return responseMapper.toOT(role);
    }

    @Override
    public PageResponse<ResponseAppRoleDTO> findAll(Pageable pageable, Map<String, String> filters) {
        Page<AppRole> page = roleRepository.findAll(pageable);
        roleValidateService.findAllValidate(page);
        List<ResponseAppRoleDTO> items = page.map(responseMapper::toOT).toList();
        return PageResponse.of(
                items,
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }

    @Override
    public ResponseAppRoleDTO findById(Long id) {
        AppRole role = roleRepository.findByIdOrElseThrow(id);
        roleValidateService.findByIdValidate(role);
        return responseMapper.toOT(role);
    }

    @Override
    public ResponseAppRoleDTO updateById(UpdateAppRoleDTO updateDTO, Long id) {
        AppRole role = roleRepository.findByIdOrElseThrow(id);
        if(updateDTO.name() != null) {
            role.setName(updateDTO.name());
        }
        roleValidateService.updateByIdValidate(role, id);
        return responseMapper.toOT(role);
    }

    @Override
    public void deleteById(Long id) {
        roleValidateService.deleteByIdValidate(id);
        roleRepository.deleteById(id);
    }

    @Override
    public ResponseAppRoleDTO addPermissions(Long id, Set<Long> permissionsIds) {
        AppRole role = roleRepository.findByIdOrElseThrow(id);
        List<AppPermission> permissions = permissionsIds
                .stream()
                .map(permissionRepository::findByIdOrElseThrow)
                .toList();
        permissions.forEach(permission -> {
            role.getPermissions().add(permission);
            permission.getRoles().add(role);
            }
        );

        return responseMapper.toOT(role);
    }
}
