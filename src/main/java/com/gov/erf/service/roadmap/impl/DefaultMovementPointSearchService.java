package com.gov.erf.service.roadmap.impl;

import com.gov.erf.models.action.MovementAction;
import com.gov.erf.models.point.MovementPoint;
import com.gov.erf.service.roadmap.MovementPointSearchService;
import com.gov.erf.service.roadmap.MovementRoadmapService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultMovementPointSearchService implements MovementPointSearchService {


    private final MovementRoadmapService movementRoadmapService;

    public DefaultMovementPointSearchService
            (
                    MovementRoadmapService movementRoadmapService
            ) {
        this.movementRoadmapService = movementRoadmapService;
    }

    @Override
    @Transactional(readOnly = true)
    public MovementPoint getTargetPointByStartAction(MovementAction startAction) {

        return movementRoadmapService.getRoadmapByStartAction(startAction).getTargetPoint();
    }
}
