package org.roleApp.rollApp.app_role.repository;

import org.roleApp.rollApp.app_role.entity.AppRole;
import org.roleApp.rollApp.shared.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    default AppRole findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResourceNotFoundException("No Entity AppRole found using specified id: "+ id));
    }


    AppRole findByName(String name);

    @Query("SELECT r FROM AppRole r " +
            "LEFT JOIN r.users user WHERE user.id = :userId")
    Collection<AppRole> findByUserId(Long userId);


}
