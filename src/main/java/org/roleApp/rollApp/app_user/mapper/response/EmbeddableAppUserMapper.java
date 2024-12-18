package org.roleApp.rollApp.app_user.mapper.response;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.app_user.dto.response.EmbeddableAppUserDTO;
import org.roleApp.rollApp.app_user.entity.AppUser;
import org.roleApp.rollApp.common.mapper.BaseMapper;

@Mapper(componentModel = "spring")
public interface EmbeddableAppUserMapper extends BaseMapper<AppUser, EmbeddableAppUserDTO> {
}
