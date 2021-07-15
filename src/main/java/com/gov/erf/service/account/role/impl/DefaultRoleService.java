package com.gov.erf.service.account.role.impl;

import com.gov.erf.models.account.Role;
import com.gov.erf.models.account.request.RoleRequest;
import com.gov.erf.repository.account.RoleRepository;
import com.gov.erf.service.account.role.RoleService;
import org.springframework.stereotype.Service;

import java.util.Collection;

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

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow();
    }

    @Override
    public Role delete(Long id) {
        Role role = roleRepository.findById(id).orElseThrow();
        roleRepository.deleteById(id);
        return role;
    }

    @Override
    public Collection<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role create(RoleRequest roleRequest) {

        Role role = new Role();
        role.setTitle(roleRequest.getTitle());

        return roleRepository.save(role);
    }
}
