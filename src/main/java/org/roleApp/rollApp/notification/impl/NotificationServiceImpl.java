package org.roleApp.rollApp.notification.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.app_user.entity.AppUser;
import org.roleApp.rollApp.app_user.repository.AppUserRepository;
import org.roleApp.rollApp.notification.dto.request.CreateNotificationDTO;
import org.roleApp.rollApp.notification.dto.request.UpdateNotificationDTO;
import org.roleApp.rollApp.notification.dto.response.ResponseNotificationDTO;
import org.roleApp.rollApp.notification.entity.Notification;
import org.roleApp.rollApp.notification.mapper.request.CreateNotificationMapper;
import org.roleApp.rollApp.notification.mapper.request.UpdateNotificationMapper;
import org.roleApp.rollApp.notification.mapper.response.ResponseNotificationMapper;
import org.roleApp.rollApp.notification.repository.NotificationRepository;
import org.roleApp.rollApp.notification.service.NotificationService;
import org.roleApp.rollApp.shared.dto.response.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final AppUserRepository userRepository;
    private final CreateNotificationMapper createNotificationMapper;
    private final UpdateNotificationMapper updateNotificationMapper;
    private final ResponseNotificationMapper responseNotificationMapper;

    @Override
    public ResponseNotificationDTO create(CreateNotificationDTO requestDTO) {
        AppUser user = userRepository.findByIdOrElseThrow(requestDTO.userId());
        Notification notification = createNotificationMapper.toE(requestDTO);

        notification.setUser(user);
        user.getNotifications().add(notification);

        notificationRepository.save(notification);
        return responseNotificationMapper.toOT(notification);
    }

    @Override
    public PageResponse<ResponseNotificationDTO> findAll(Pageable pageable, Map<String, String> filters) {
        // Implement filtering logic if needed
        return null; // Placeholder
    }

    @Override
    public ResponseNotificationDTO findById(Long id) {
        Notification notification = notificationRepository.findByIdOrElseThrow(id);
        return responseNotificationMapper.toOT(notification);
    }

    @Override
    public ResponseNotificationDTO updateById(UpdateNotificationDTO updateDTO, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        notificationRepository.deleteById(id);
    }
}
