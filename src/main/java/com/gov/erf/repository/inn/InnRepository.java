package com.gov.erf.repository.inn;

import com.gov.erf.models.inn.Inn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InnRepository extends JpaRepository<Inn, Long> {

    Optional<Inn> findByInn(String inn);
}
