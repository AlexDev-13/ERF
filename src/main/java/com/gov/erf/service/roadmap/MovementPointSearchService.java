package com.gov.erf.service.roadmap;

import com.gov.erf.models.action.MovementAction;
import com.gov.erf.models.point.MovementPoint;

public interface MovementPointSearchService {

    MovementPoint getTargetPointByStartAction(MovementAction startAction);

}
