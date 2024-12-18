package org.roleApp.rollApp.app_user.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.app_user.entity.AppUser;
import org.roleApp.rollApp.app_user.service.AppUserValidateService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AppUserValidateServiceImpl implements AppUserValidateService {
    @Override
    public void createValidate(AppUser entity) {
        int[] nums = new int[5];

        
    }

    @Override
    public void findAllValidate(Page<AppUser> page) {

    }


    @Override
    public void findByIdValidate(AppUser entity) {

    }

    @Override
    public void updateByIdValidate(AppUser updateEntity, Long id) {

    }

    @Override
    public void deleteByIdValidate(Long id) {

    }
}
