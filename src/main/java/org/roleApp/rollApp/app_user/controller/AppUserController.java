package org.roleApp.rollApp.app_user.controller;

import lombok.RequiredArgsConstructor;
import org.roleApp.rollApp.account.entity.Account;
import org.roleApp.rollApp.app_role.entity.AppRole;
import org.roleApp.rollApp.app_user.dto.request.CreateAppUserDTO;
import org.roleApp.rollApp.app_user.dto.request.UpdateAppUserDTO;
import org.roleApp.rollApp.app_user.dto.response.ResponseAppUserDTO;
import org.roleApp.rollApp.app_user.entity.AppUser;
import org.roleApp.rollApp.app_user.service.AppUserService;
import org.roleApp.rollApp.common.controller.BaseController;
import org.roleApp.rollApp.common.service.BaseService;
import org.roleApp.rollApp.util.annotation.IdExists;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
@RequiredArgsConstructor
public class AppUserController extends BaseController<AppUser, Long, CreateAppUserDTO, UpdateAppUserDTO, ResponseAppUserDTO> {
    private final AppUserService userService;

    @Override
    protected BaseService<Long, CreateAppUserDTO, UpdateAppUserDTO, ResponseAppUserDTO> getService() {
        return userService;
    }

    @Override
    public Class<AppUser> getEntityClass() {
        return AppUser.class;
    }

    @PostMapping("/{id}/role/{roleId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseAppUserDTO addRoleToUser(@Validated @IdExists(entityClass = AppUser.class, field = "id") @PathVariable Long id, @Validated @IdExists(entityClass = AppRole.class, field = "id") @PathVariable Long roleId) {
      return userService.addRoleToUser(id, roleId);
    }

    @GetMapping("/test")
    public ResponseAppUserDTO test(@RequestBody ResponseAppUserDTO user) {
        return userService.test(user.name());
    }
}
