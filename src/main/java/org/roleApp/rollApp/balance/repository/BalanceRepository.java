package org.roleApp.rollApp.balance.repository;

import org.roleApp.rollApp.balance.entity.Balance;
import org.roleApp.rollApp.shared.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
    default Balance findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResourceNotFoundException("No entity balance found using specified id:"));
    }
}
