package org.roleApp.rollApp.app_permission.mapper.response;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.app_permission.dto.response.EmbeddableAppPermissionDTO;
import org.roleApp.rollApp.app_permission.entity.AppPermission;
import org.roleApp.rollApp.common.mapper.BaseMapper;

@Mapper(componentModel = "spring")
public interface EmbeddableAppPermissionMapper extends BaseMapper<AppPermission, EmbeddableAppPermissionDTO> {
}
