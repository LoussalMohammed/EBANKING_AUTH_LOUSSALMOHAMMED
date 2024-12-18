package org.roleApp.rollApp.app_user.repository;

import org.roleApp.rollApp.app_user.entity.AppUser;
import org.roleApp.rollApp.shared.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    default AppUser findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResourceNotFoundException("No Entity AppUser found using specified id: "+ id));
    }

    AppUser findByName(String name);

    AppUser findByEmail(String email);
}
