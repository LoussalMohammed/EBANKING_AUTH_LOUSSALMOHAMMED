package org.roleApp.rollApp.auth.controller;

import lombok.RequiredArgsConstructor;
import org.roleApp.rollApp.app_user.dto.request.CreateAppUserDTO;
import org.roleApp.rollApp.app_user.dto.request.UpdateAppUserDTO;
import org.roleApp.rollApp.app_user.dto.response.ResponseAppUserDTO;
import org.roleApp.rollApp.app_user.entity.AppUser;
import org.roleApp.rollApp.auth.dto.request.LoginRequest;
import org.roleApp.rollApp.auth.dto.request.Password;
import org.roleApp.rollApp.auth.service.AuthService;
import org.roleApp.rollApp.common.controller.BaseController;
import org.roleApp.rollApp.common.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/public/auth")
@RequiredArgsConstructor
public class AuthController extends BaseController<AppUser, Long, CreateAppUserDTO, UpdateAppUserDTO, ResponseAppUserDTO> {
    private final AuthService service;

    @Override
    protected BaseService<Long, CreateAppUserDTO, UpdateAppUserDTO, ResponseAppUserDTO> getService() {
        return service;
    }

    @Override
    public Class<AppUser> getEntityClass() {
        return AppUser.class;
    }

    @RequestMapping("/login")
    public ResponseAppUserDTO login(@Validated @RequestBody LoginRequest loginRequest) {
        return service.login(loginRequest);
    }

    @PatchMapping("/name/{username}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseAppUserDTO getUserByName(@PathVariable String username, @RequestBody Password password) {
        return service.updatePassword(username, password.password());
    }

    @GetMapping("/csrf")
    public void csrf() {}
}
