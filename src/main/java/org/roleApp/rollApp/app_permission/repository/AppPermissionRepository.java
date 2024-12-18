package org.roleApp.rollApp.app_permission.repository;

import org.roleApp.rollApp.app_permission.entity.AppPermission;
import org.roleApp.rollApp.shared.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppPermissionRepository extends JpaRepository<AppPermission, Long> {
    default AppPermission findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResourceNotFoundException("No Entity AppRole found using specified id: "+ id));
    }

    AppPermission findByName(String name);
}
