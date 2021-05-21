package com.gov.erf.modules.repository;

import com.gov.erf.modules.models.AppFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppFileRepository extends JpaRepository<AppFile,Long> {
}
