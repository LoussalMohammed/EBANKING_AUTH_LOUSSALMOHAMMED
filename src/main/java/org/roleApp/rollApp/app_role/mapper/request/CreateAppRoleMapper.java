package org.roleApp.rollApp.app_role.mapper.request;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.app_role.dto.request.CreateAppRoleDTO;
import org.roleApp.rollApp.app_role.entity.AppRole;
import org.roleApp.rollApp.common.mapper.BaseMapper;

@Mapper(componentModel = "spring")
public interface CreateAppRoleMapper extends BaseMapper<AppRole, CreateAppRoleDTO> {
}
