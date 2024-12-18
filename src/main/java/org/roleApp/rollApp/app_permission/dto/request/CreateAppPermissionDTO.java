package org.roleApp.rollApp.app_permission.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

public record CreateAppPermissionDTO(
        @NotBlank(message = "role should have a name")
        String name,

        Set<String> roles
)
{
        public CreateAppPermissionDTO {
                roles = roles != null ? roles : new HashSet<>();
        }
}
