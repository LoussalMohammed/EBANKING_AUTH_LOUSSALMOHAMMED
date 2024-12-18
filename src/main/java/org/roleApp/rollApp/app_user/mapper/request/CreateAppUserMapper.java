package org.roleApp.rollApp.app_user.mapper.request;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.app_role.entity.AppRole;
import org.roleApp.rollApp.app_user.dto.request.CreateAppUserDTO;
import org.roleApp.rollApp.app_user.entity.AppUser;
import org.roleApp.rollApp.common.mapper.BaseMapper;

import java.util.HashSet;

@Mapper(componentModel = "spring")
public interface CreateAppUserMapper extends BaseMapper<AppUser, CreateAppUserDTO> {
    default String maps(AppRole role) {
        return role.getName();
    }

    default AppRole map(String roleName) {
        return AppRole.builder()
                .name(roleName)
                .users(new HashSet<>())
                .permissions(new HashSet<>())
                .build();
    }
}
