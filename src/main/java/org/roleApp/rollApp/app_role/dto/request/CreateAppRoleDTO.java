package org.roleApp.rollApp.app_role.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;


public record CreateAppRoleDTO(
        @NotBlank(message = "role should have a name")
        String name,

        Set<String> permission
)
{
        public CreateAppRoleDTO {
                permission = permission != null ? permission : new HashSet<>();
        }
}
