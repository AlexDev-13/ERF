package com.gov.erf.repository.account;

import com.gov.erf.models.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByTitle(String title);
}
