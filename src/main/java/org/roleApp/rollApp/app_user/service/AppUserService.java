package org.roleApp.rollApp.app_user.service;

import org.roleApp.rollApp.app_user.dto.request.CreateAppUserDTO;
import org.roleApp.rollApp.app_user.dto.request.UpdateAppUserDTO;
import org.roleApp.rollApp.app_user.dto.response.ResponseAppUserDTO;
import org.roleApp.rollApp.common.service.BaseService;

import java.util.List;

public interface AppUserService extends BaseService<Long, CreateAppUserDTO, UpdateAppUserDTO, ResponseAppUserDTO> {
    ResponseAppUserDTO addRoleToUser(Long id, Long roleId);
    ResponseAppUserDTO test(String name);
}
