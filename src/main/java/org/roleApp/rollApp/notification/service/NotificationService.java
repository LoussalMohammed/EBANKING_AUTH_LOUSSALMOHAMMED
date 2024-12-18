package org.roleApp.rollApp.notification.service;

import org.roleApp.rollApp.common.service.BaseService;
import org.roleApp.rollApp.notification.dto.request.CreateNotificationDTO;
import org.roleApp.rollApp.notification.dto.request.UpdateNotificationDTO;
import org.roleApp.rollApp.notification.dto.response.ResponseNotificationDTO;

public interface NotificationService extends BaseService<Long, CreateNotificationDTO, UpdateNotificationDTO, ResponseNotificationDTO> {
}
