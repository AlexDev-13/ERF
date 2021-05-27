package com.gov.erf.repository.roadmap;

import com.gov.erf.models.roadmap.MovementRoadmap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRoadmapRepository extends JpaRepository<MovementRoadmap,Long>, QuerydslPredicateExecutor<MovementRoadmap> {

}
