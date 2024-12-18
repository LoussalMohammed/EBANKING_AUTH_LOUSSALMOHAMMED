package org.roleApp.rollApp.app_permission.mapper.request;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.app_permission.dto.request.UpdateAppPermissionDTO;
import org.roleApp.rollApp.app_permission.entity.AppPermission;
import org.roleApp.rollApp.common.mapper.BaseMapper;

@Mapper(componentModel = "spring")
public interface UpdateAppPermissionMapper extends BaseMapper<AppPermission, UpdateAppPermissionDTO> {
}
