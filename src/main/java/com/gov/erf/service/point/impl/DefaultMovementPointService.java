package com.gov.erf.service.point.impl;

import com.gov.erf.models.point.MovementPoint;
import com.gov.erf.models.point.MovementPointType;
import com.gov.erf.repository.point.MovementPointRepository;
import com.gov.erf.service.point.MovementPointService;
import org.springframework.stereotype.Service;

@Service
public class DefaultMovementPointService implements MovementPointService {

    private final MovementPointRepository movementPointRepository;

    public DefaultMovementPointService
            (
            MovementPointRepository movementPointRepository
            ) {
        this.movementPointRepository = movementPointRepository;
    }


    @Override
    public MovementPoint get(MovementPointType type) {
        return movementPointRepository.findByType(type).orElseThrow();
    }
}
