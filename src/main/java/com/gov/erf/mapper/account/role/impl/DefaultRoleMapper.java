package com.gov.erf.mapper.account.role.impl;

import com.gov.erf.dto.http.account.RoleDto;
import com.gov.erf.mapper.account.role.RoleMapper;
import com.gov.erf.models.account.Role;
import org.springframework.stereotype.Service;


@Service
public class DefaultRoleMapper implements RoleMapper {

    @Override
    public RoleDto toRoleDto(Role role) {

        var roleDto = new RoleDto();

        roleDto.setTitle(role.getTitle());
        return roleDto;
    }
}
