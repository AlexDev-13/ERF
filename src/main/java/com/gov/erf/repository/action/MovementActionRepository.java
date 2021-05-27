package com.gov.erf.repository.action;

import com.gov.erf.models.action.MovementAction;
import com.gov.erf.models.action.MovementActionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovementActionRepository extends JpaRepository<MovementAction, Long> {
    Optional<MovementAction> findByType(MovementActionType type);
}
