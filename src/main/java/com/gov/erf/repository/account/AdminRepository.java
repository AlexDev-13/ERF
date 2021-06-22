package com.gov.erf.repository.account;

import com.gov.erf.models.account.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByEmail(String email);

    Optional<Admin> findByUsername(String username);

    @Transactional
    @Modifying
    @Query("UPDATE Admin a " +
            "SET a.enabled = TRUE, a.locked = FALSE WHERE a.email = ?1")
    int enableAppUser(String email);

    void deleteById(Long id);
}
