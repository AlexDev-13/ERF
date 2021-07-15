package com.gov.erf.service.account.role;

import com.gov.erf.models.account.Role;
import com.gov.erf.models.account.request.RoleRequest;

import java.util.Collection;

public interface RoleService {

    Role findRole(String role);

    Role findById(Long id);

    Role delete(Long id);

    Collection<Role> findAll();

    Role create(RoleRequest roleRequest);

}
