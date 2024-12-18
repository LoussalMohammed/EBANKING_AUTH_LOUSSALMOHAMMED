package org.roleApp.rollApp.notification.dto.request;


public record UpdateNotificationDTO(
        String message,

        boolean isRead,

        Long userId
)
{}
