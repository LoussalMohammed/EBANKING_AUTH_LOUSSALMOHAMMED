package org.roleApp.rollApp.app_role.controller;

import lombok.RequiredArgsConstructor;
import org.roleApp.rollApp.app_role.dto.request.CreateAppRoleDTO;
import org.roleApp.rollApp.app_role.dto.request.UpdateAppRoleDTO;
import org.roleApp.rollApp.app_role.dto.response.ResponseAppRoleDTO;
import org.roleApp.rollApp.app_role.entity.AppRole;
import org.roleApp.rollApp.app_role.service.AppRoleService;
import org.roleApp.rollApp.common.controller.BaseController;
import org.roleApp.rollApp.common.service.BaseService;
import org.roleApp.rollApp.util.annotation.IdExists;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/admin/role")
@RequiredArgsConstructor
public class AppRoleController extends BaseController<AppRole, Long, CreateAppRoleDTO, UpdateAppRoleDTO, ResponseAppRoleDTO> {
    private final AppRoleService roleService;

    @Override
    protected BaseService<Long, CreateAppRoleDTO, UpdateAppRoleDTO, ResponseAppRoleDTO> getService() {
        return roleService;
    }

    @Override
    public Class<AppRole> getEntityClass() {
        return AppRole.class;
    }

    @PostMapping("/{id}/permissions/{permissions}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseAppRoleDTO addPermissions(@Validated @IdExists(entityClass = AppRole.class, field = "id") @PathVariable Long id, @PathVariable Set<Long> permissions) {
        return roleService.addPermissions(id, permissions);
    }
}
