package org.roleApp.rollApp.app_permission.controller;

import lombok.RequiredArgsConstructor;
import org.roleApp.rollApp.app_permission.dto.request.CreateAppPermissionDTO;
import org.roleApp.rollApp.app_permission.dto.request.UpdateAppPermissionDTO;
import org.roleApp.rollApp.app_permission.dto.response.ResponseAppPermissionDTO;
import org.roleApp.rollApp.app_permission.entity.AppPermission;
import org.roleApp.rollApp.app_permission.service.AppPermissionService;
import org.roleApp.rollApp.common.controller.BaseController;
import org.roleApp.rollApp.common.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/permission")
@RequiredArgsConstructor
public class AppPermissionController extends BaseController<AppPermission, Long, CreateAppPermissionDTO, UpdateAppPermissionDTO, ResponseAppPermissionDTO> {
    private final AppPermissionService permissionService;

    @Override
    protected BaseService<Long, CreateAppPermissionDTO, UpdateAppPermissionDTO, ResponseAppPermissionDTO> getService() {
        return permissionService;
    }

    @Override
    public Class<AppPermission> getEntityClass() {
        return AppPermission.class;
    }
}
