package com.gov.erf.service.action.impl;

import com.gov.erf.models.action.MovementAction;
import com.gov.erf.models.action.MovementActionType;
import com.gov.erf.models.point.MovementPointType;
import com.gov.erf.repository.action.MovementActionRepository;
import com.gov.erf.service.action.MovementActionService;
import org.springframework.stereotype.Service;

@Service
public class DefaultMovementActionService implements MovementActionService {

    private final MovementActionRepository movementActionRepository;

    public DefaultMovementActionService
            (
                    MovementActionRepository movementActionRepository
            ) {
        this.movementActionRepository = movementActionRepository;
    }

    @Override
    public MovementAction get(MovementActionType type) {
        return movementActionRepository.findByType(type).orElseThrow();
    }
}
