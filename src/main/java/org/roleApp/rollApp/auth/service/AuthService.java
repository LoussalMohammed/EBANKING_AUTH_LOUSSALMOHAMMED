package org.roleApp.rollApp.auth.service;

import org.roleApp.rollApp.app_user.dto.request.CreateAppUserDTO;
import org.roleApp.rollApp.app_user.dto.request.UpdateAppUserDTO;
import org.roleApp.rollApp.app_user.dto.response.ResponseAppUserDTO;
import org.roleApp.rollApp.auth.dto.request.LoginRequest;
import org.roleApp.rollApp.common.service.BaseService;

public interface AuthService extends BaseService<Long, CreateAppUserDTO, UpdateAppUserDTO, ResponseAppUserDTO> {
    ResponseAppUserDTO login(LoginRequest loginRequest);
    ResponseAppUserDTO updatePassword(String username, String password);
}
