package org.roleApp.rollApp.notification.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.common.controller.BaseController;
import org.roleApp.rollApp.common.service.BaseService;
import org.roleApp.rollApp.notification.dto.request.CreateNotificationDTO;
import org.roleApp.rollApp.notification.dto.request.UpdateNotificationDTO;
import org.roleApp.rollApp.notification.dto.response.ResponseNotificationDTO;
import org.roleApp.rollApp.notification.entity.Notification;
import org.roleApp.rollApp.notification.service.NotificationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/notification")
@Slf4j
@RequiredArgsConstructor
public class NotificationController extends BaseController<Notification, Long, CreateNotificationDTO, UpdateNotificationDTO, ResponseNotificationDTO> {
    private final NotificationService notificationService;


    @Override
    protected BaseService<Long, CreateNotificationDTO, UpdateNotificationDTO, ResponseNotificationDTO> getService() {
        return notificationService;
    }

    @Override
    public Class<Notification> getEntityClass() {
        return Notification.class;
    }
}
