package org.roleApp.rollApp.app_permission.mapper.request;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.app_permission.dto.request.CreateAppPermissionDTO;
import org.roleApp.rollApp.app_permission.entity.AppPermission;
import org.roleApp.rollApp.app_role.entity.AppRole;
import org.roleApp.rollApp.common.mapper.BaseMapper;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CreateAppPermissionMapper extends BaseMapper<AppPermission, CreateAppPermissionDTO> {
    default Set<String> maps(Set<AppRole> roles) {
        return roles.stream()
                .map(AppRole::getName)
                .collect(Collectors.toSet());
    }

    default Set<AppRole> map(Set<String> roleNames) {
        return roleNames.stream()
                .map(roleName -> {
                    AppRole role = new AppRole();
                    role.setName(roleName);
                    return role;
                })
                .collect(Collectors.toSet());
    }
}
