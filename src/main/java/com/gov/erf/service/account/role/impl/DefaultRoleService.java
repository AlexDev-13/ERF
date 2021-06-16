package com.gov.erf.service.account.role.impl;

import com.gov.erf.models.account.Role;
import com.gov.erf.repository.account.RoleRepository;
import com.gov.erf.service.account.role.RoleService;
import org.springframework.stereotype.Service;

@Service
public class DefaultRoleService implements RoleService {

    private final RoleRepository roleRepository;

    public DefaultRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findRole(String role) {
        return roleRepository.findByTitle(role);
    }
}
