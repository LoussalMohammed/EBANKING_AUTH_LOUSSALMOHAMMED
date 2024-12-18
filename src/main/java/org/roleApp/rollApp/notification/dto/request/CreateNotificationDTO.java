package org.roleApp.rollApp.notification.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateNotificationDTO(
        @NotBlank(message = "Message is required")
        String message,

        boolean isRead,

        @NotNull
        Long userId
) {
}
