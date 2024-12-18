package org.roleApp.rollApp.notification.mapper.request;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.common.mapper.BaseMapper;
import org.roleApp.rollApp.notification.dto.request.UpdateNotificationDTO;
import org.roleApp.rollApp.notification.entity.Notification;

@Mapper(componentModel = "spring")
public interface UpdateNotificationMapper extends BaseMapper<Notification, UpdateNotificationDTO> {
}
