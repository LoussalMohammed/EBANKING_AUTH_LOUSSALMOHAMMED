package org.roleApp.rollApp.app_user.dto.request;

public record UpdateAppUserDTO(
        String name,

        String email,

        String phone,

        String password
)
{}
