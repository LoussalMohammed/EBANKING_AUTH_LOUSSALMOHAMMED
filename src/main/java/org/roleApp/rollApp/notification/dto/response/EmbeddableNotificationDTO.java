package org.roleApp.rollApp.notification.dto.response;

import jakarta.validation.constraints.NotBlank;

public record EmbeddableNotificationDTO(
        @NotBlank(message = "Message is required")
        String message,

        boolean isRead
)
{}
