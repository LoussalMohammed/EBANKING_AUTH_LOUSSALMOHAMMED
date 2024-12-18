package org.roleApp.rollApp.app_user.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateAppUserDTO(
        @NotBlank(message = "role should have a name")
        String name,

        @NotBlank(message = "email is required")
        String email,

        @NotBlank(message = "phone is required")
        String phone,

        @NotBlank(message = "password is required")
        String password,

        String role
)
{}
