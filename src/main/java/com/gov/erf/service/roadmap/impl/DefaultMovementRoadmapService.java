package com.gov.erf.service.roadmap.impl;

import com.gov.erf.models.action.MovementAction;
import com.gov.erf.models.roadmap.MovementRoadmap;
import com.gov.erf.repository.roadmap.MovementRoadmapRepository;
import com.gov.erf.service.roadmap.MovementRoadmapService;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

import static com.gov.erf.models.roadmap.QMovementRoadmap.movementRoadmap;

@Service
public class DefaultMovementRoadmapService implements MovementRoadmapService {

    private final MovementRoadmapRepository movementRoadmapRepository;

    public DefaultMovementRoadmapService
            (
                    MovementRoadmapRepository movementRoadmapRepository
            ) {
        this.movementRoadmapRepository = movementRoadmapRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public MovementRoadmap getRoadmapByStartAction(MovementAction startAction) {

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(movementRoadmap.sourcePoint.isNull());
        builder.and(movementRoadmap.action.eq(startAction));

        return movementRoadmapRepository.findOne(Objects.requireNonNull(builder.getValue())).orElseThrow();
    }
}
