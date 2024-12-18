package org.roleApp.rollApp.app_permission.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.app_permission.dto.request.CreateAppPermissionDTO;
import org.roleApp.rollApp.app_permission.dto.request.UpdateAppPermissionDTO;
import org.roleApp.rollApp.app_permission.dto.response.ResponseAppPermissionDTO;
import org.roleApp.rollApp.app_permission.entity.AppPermission;
import org.roleApp.rollApp.app_permission.mapper.request.CreateAppPermissionMapper;
import org.roleApp.rollApp.app_permission.mapper.request.UpdateAppPermissionMapper;
import org.roleApp.rollApp.app_permission.mapper.response.ResponseAppPermissionMapper;
import org.roleApp.rollApp.app_permission.repository.AppPermissionRepository;
import org.roleApp.rollApp.app_permission.service.AppPermissionService;
import org.roleApp.rollApp.app_permission.service.AppPermissionValidateService;
import org.roleApp.rollApp.app_role.entity.AppRole;
import org.roleApp.rollApp.app_role.repository.AppRoleRepository;
import org.roleApp.rollApp.shared.dto.response.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AppPermissionServiceImpl implements AppPermissionService {
    private final CreateAppPermissionMapper createMapper;
    private final UpdateAppPermissionMapper updateMapper;
    private final ResponseAppPermissionMapper responseMapper;
    private final AppPermissionRepository permissionRepository;
    private final AppRoleRepository roleRepository;
    private final AppPermissionValidateService permissionValidateService;

    @Override
    public ResponseAppPermissionDTO create(CreateAppPermissionDTO requestDTO) {
        log.info("started ");
        AppPermission permission = createMapper.toE(requestDTO);
        permissionValidateService.createValidate(permission);
        log.info("empty");
        if(!requestDTO.roles().isEmpty()) {
            log.info("not empty");
            requestDTO.roles().forEach(
                    roleName -> {
                        AppRole role = roleRepository.findByName(roleName);
                        permission.getRoles().add(role);
                        role.getPermissions().add(permission);
                    }
            );
        }
        permissionRepository.save(permission);
        return responseMapper.toOT(permission);
    }

    @Override
    public PageResponse<ResponseAppPermissionDTO> findAll(Pageable pageable, Map<String, String> filters) {
        Page<AppPermission> page = permissionRepository.findAll(pageable);
        permissionValidateService.findAllValidate(page);
        List<ResponseAppPermissionDTO> items = page.map(responseMapper::toOT).toList();
        return PageResponse.of(
                items,
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }

    @Override
    public ResponseAppPermissionDTO findById(Long id) {
        AppPermission permission = permissionRepository.findByIdOrElseThrow(id);
        permissionValidateService.findByIdValidate(permission);
        return responseMapper.toOT(permission);
    }

    @Override
    public ResponseAppPermissionDTO updateById(UpdateAppPermissionDTO updateDTO, Long id) {
        AppPermission permission = permissionRepository.findByIdOrElseThrow(id);
        if(updateDTO.name() != null) {
            permission.setName(updateDTO.name());
        }
        permissionValidateService.updateByIdValidate(permission, id);
        return responseMapper.toOT(permission);
    }

    @Override
    public void deleteById(Long id) {
        permissionValidateService.deleteByIdValidate(id);
        permissionRepository.deleteById(id);
    }
}
