package org.roleApp.rollApp.app_role.mapper.request;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.app_role.dto.request.UpdateAppRoleDTO;
import org.roleApp.rollApp.app_role.entity.AppRole;
import org.roleApp.rollApp.common.mapper.BaseMapper;

@Mapper(componentModel = "spring")
public interface UpdateAppRoleMapper extends BaseMapper<AppRole, UpdateAppRoleDTO> {
}
