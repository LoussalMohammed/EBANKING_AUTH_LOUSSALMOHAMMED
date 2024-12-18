package org.roleApp.rollApp.notification.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.roleApp.rollApp.app_user.dto.response.EmbeddableAppUserDTO;

public record ResponseNotificationDTO(
        @NotBlank(message = "Message is required")
        String message,

        boolean isRead,

        @NotNull
        EmbeddableAppUserDTO user
) {
}
