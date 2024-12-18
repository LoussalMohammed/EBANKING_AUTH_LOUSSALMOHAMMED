package org.roleApp.rollApp.app_permission.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.app_permission.entity.AppPermission;
import org.roleApp.rollApp.app_permission.service.AppPermissionValidateService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AppPermissionValidateServiceImpl implements AppPermissionValidateService {
    @Override
    public void createValidate(AppPermission entity) {

    }

    @Override
    public void findAllValidate(Page<AppPermission> page) {

    }


    @Override
    public void findByIdValidate(AppPermission entity) {

    }

    @Override
    public void updateByIdValidate(AppPermission updateEntity, Long id) {

    }

    @Override
    public void deleteByIdValidate(Long id) {

    }
}
