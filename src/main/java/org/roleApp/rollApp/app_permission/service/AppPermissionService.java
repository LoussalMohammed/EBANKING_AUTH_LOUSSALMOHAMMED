package org.roleApp.rollApp.app_permission.service;

import org.roleApp.rollApp.app_permission.dto.request.CreateAppPermissionDTO;
import org.roleApp.rollApp.app_permission.dto.request.UpdateAppPermissionDTO;
import org.roleApp.rollApp.app_permission.dto.response.ResponseAppPermissionDTO;
import org.roleApp.rollApp.common.service.BaseService;

public interface AppPermissionService extends BaseService<Long, CreateAppPermissionDTO, UpdateAppPermissionDTO, ResponseAppPermissionDTO> {
}
