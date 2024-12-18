package org.roleApp.rollApp.app_role.mapper.response;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.app_role.dto.response.EmbeddableAppRoleDTO;
import org.roleApp.rollApp.app_role.entity.AppRole;
import org.roleApp.rollApp.common.mapper.BaseMapper;

@Mapper(componentModel = "spring")
public interface EmbeddableAppRoleMapper extends BaseMapper<AppRole, EmbeddableAppRoleDTO> {
}
