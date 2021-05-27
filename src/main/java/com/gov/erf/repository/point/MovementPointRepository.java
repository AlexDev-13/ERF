package com.gov.erf.repository.point;

import com.gov.erf.models.point.MovementPoint;
import com.gov.erf.models.point.MovementPointType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovementPointRepository extends JpaRepository<MovementPoint, Long> {

    Optional<MovementPoint> findByType(MovementPointType type);

}
