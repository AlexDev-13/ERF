package com.gov.erf.service.point;

import com.gov.erf.models.point.MovementPoint;
import com.gov.erf.models.point.MovementPointType;

public interface MovementPointService {

    MovementPoint get(MovementPointType type);
}
