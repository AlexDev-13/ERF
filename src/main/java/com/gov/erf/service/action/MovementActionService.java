package com.gov.erf.service.action;

import com.gov.erf.models.action.MovementAction;
import com.gov.erf.models.point.MovementPointType;

public interface MovementActionService {

    MovementAction get(MovementPointType type);
}
