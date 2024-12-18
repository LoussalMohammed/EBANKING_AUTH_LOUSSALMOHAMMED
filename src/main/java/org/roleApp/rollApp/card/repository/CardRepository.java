package org.roleApp.rollApp.card.repository;

import org.roleApp.rollApp.card.entity.Card;
import org.roleApp.rollApp.shared.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    default Card findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResourceNotFoundException("No entity card found using specified id: "+ id));
    }
}
