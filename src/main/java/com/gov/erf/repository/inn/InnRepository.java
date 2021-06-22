package com.gov.erf.repository.inn;

import com.gov.erf.models.inn.Inn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InnRepository extends JpaRepository<Inn, Long> {

    Inn getInnByInn(String inn);
}
