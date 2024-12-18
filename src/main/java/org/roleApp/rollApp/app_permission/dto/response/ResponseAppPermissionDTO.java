package org.roleApp.rollApp.app_permission.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.roleApp.rollApp.app_role.dto.response.EmbeddableAppRoleDTO;

import java.util.Set;

public record ResponseAppPermissionDTO(
        @NotNull
        Long id,

        @NotBlank(message = "role should have a name")
        String name,

        Set<EmbeddableAppRoleDTO> roles
)
{}
