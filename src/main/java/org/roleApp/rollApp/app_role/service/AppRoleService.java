package org.roleApp.rollApp.app_role.service;

import org.roleApp.rollApp.app_role.dto.request.CreateAppRoleDTO;
import org.roleApp.rollApp.app_role.dto.request.UpdateAppRoleDTO;
import org.roleApp.rollApp.app_role.dto.response.ResponseAppRoleDTO;
import org.roleApp.rollApp.common.service.BaseService;

import java.util.Set;


public interface AppRoleService extends BaseService<Long, CreateAppRoleDTO, UpdateAppRoleDTO, ResponseAppRoleDTO> {
    ResponseAppRoleDTO addPermissions(Long id, Set<Long> permissions);
}
