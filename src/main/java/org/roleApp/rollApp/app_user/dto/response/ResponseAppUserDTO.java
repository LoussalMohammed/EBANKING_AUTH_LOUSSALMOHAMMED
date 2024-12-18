package org.roleApp.rollApp.app_user.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.roleApp.rollApp.app_role.dto.response.EmbeddableAppRoleDTO;

public record ResponseAppUserDTO(
        @NotNull
        Long id,

        @NotBlank(message = "role should have a name")
        String name,

        @NotBlank(message = "email is required")
        String email,

        @NotBlank(message = "phone is required")
        String phone,

        @NotBlank(message = "password is required")
        String password,

        EmbeddableAppRoleDTO role
)
{}
