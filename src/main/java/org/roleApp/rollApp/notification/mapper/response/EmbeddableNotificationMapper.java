package org.roleApp.rollApp.notification.mapper.response;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.common.mapper.BaseMapper;
import org.roleApp.rollApp.notification.dto.response.EmbeddableNotificationDTO;
import org.roleApp.rollApp.notification.entity.Notification;

@Mapper(componentModel = "spring")
public interface EmbeddableNotificationMapper extends BaseMapper<Notification, EmbeddableNotificationDTO> {
}
