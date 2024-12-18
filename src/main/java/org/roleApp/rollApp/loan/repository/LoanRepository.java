package org.roleApp.rollApp.loan.repository;

import org.roleApp.rollApp.loan.entity.Loan;
import org.roleApp.rollApp.shared.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    default Loan findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResourceNotFoundException("No entity loan found using specified id: "+ id));
    }
}
