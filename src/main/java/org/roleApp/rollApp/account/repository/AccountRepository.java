package org.roleApp.rollApp.account.repository;

import org.roleApp.rollApp.account.entity.Account;
import org.roleApp.rollApp.shared.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    default Account findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResourceNotFoundException("No entity Account found using specified id: "+ id));
    }

}
