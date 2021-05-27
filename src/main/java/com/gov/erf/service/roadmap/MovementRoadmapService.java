package com.gov.erf.service.roadmap;

import com.gov.erf.models.action.MovementAction;
import com.gov.erf.models.roadmap.MovementRoadmap;

public interface MovementRoadmapService {

    MovementRoadmap getRoadmapByStartAction(MovementAction startAction);
}
