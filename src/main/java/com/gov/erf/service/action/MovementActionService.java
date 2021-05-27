package com.gov.erf.service.action;

import com.gov.erf.models.action.MovementAction;
import com.gov.erf.models.action.MovementActionType;

public interface MovementActionService {

    MovementAction get(MovementActionType type);
}
