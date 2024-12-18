package org.roleApp.rollApp.app_role.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.roleApp.rollApp.app_permission.dto.response.EmbeddableAppPermissionDTO;

import java.util.Set;

public record ResponseAppRoleDTO(
        @NotNull
        Long id,

        @NotBlank(message = "role should have a name")
        String name,

        Set<EmbeddableAppPermissionDTO> permissions
)
{}
