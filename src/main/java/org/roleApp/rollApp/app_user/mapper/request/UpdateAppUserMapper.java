package org.roleApp.rollApp.app_user.mapper.request;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.app_user.dto.request.UpdateAppUserDTO;
import org.roleApp.rollApp.app_user.entity.AppUser;
import org.roleApp.rollApp.common.mapper.BaseMapper;

@Mapper(componentModel = "spring")
public interface UpdateAppUserMapper extends BaseMapper<AppUser, UpdateAppUserDTO> {
}
