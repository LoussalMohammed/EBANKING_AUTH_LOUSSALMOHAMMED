package org.roleApp.rollApp.common.service;

import org.springframework.data.domain.Page;


public interface BaseValidateService<E, Long> {
    void createValidate(E entity);

    void findAllValidate(Page<E> page);

    void findByIdValidate(E entity);

    void updateByIdValidate(E updateEntity, Long id);

    void deleteByIdValidate(Long id);

}
