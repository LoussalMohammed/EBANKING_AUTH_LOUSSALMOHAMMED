package org.roleApp.rollApp.app_role.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.app_role.entity.AppRole;
import org.roleApp.rollApp.app_role.service.AppRoleValidateService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AppRoleValidateServiceImpl implements AppRoleValidateService {
    @Override
    public void createValidate(AppRole entity) {

    }

    @Override
    public void findAllValidate(Page<AppRole> page) {

    }


    @Override
    public void findByIdValidate(AppRole entity) {

    }

    @Override
    public void updateByIdValidate(AppRole updateEntity, Long id) {

    }

    @Override
    public void deleteByIdValidate(Long id) {

    }
}
