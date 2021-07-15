package com.gov.erf.endpoint.role.impl;


import com.gov.erf.dto.http.account.RoleDto;
import com.gov.erf.dto.http.account.RoleRequestDto;
import com.gov.erf.endpoint.role.RoleEndpoint;
import com.gov.erf.mapper.account.role.RoleMapper;
import com.gov.erf.models.account.Role;
import com.gov.erf.models.account.request.RoleRequest;
import com.gov.erf.service.account.role.RoleService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DefaultRoleEndpoint implements RoleEndpoint {

    private final RoleMapper roleMapper;
    private final RoleService roleService;

    public DefaultRoleEndpoint(RoleMapper roleMapper, RoleService roleService) {
        this.roleMapper = roleMapper;
        this.roleService = roleService;
    }

    @Override
    public RoleDto getById(Long id) {

        Role role = roleService.findById(id);

        return roleMapper.toRoleDto(role);
    }

    @Override
    public RoleDto delete(Long id) {
        Role role = roleService.delete(id);

        return roleMapper.toRoleDto(role);
    }

    @Override
    public Collection<RoleDto> getAll() {

        Collection<Role> roles = roleService.findAll();

        return roleMapper.toRoleDtos(roles);
    }

    @Override
    public RoleDto create(RoleRequestDto roleRequestDto) {

        RoleRequest roleRequest = roleMapper.toRoleRequest(roleRequestDto);

        Role role = roleService.create(roleRequest);

        return roleMapper.toRoleDto(role);

    }
}
