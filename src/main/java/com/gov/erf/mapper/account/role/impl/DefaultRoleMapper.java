package com.gov.erf.mapper.account.role.impl;

import com.gov.erf.dto.http.account.RoleDto;
import com.gov.erf.dto.http.account.RoleRequestDto;
import com.gov.erf.mapper.account.role.RoleMapper;
import com.gov.erf.models.account.Role;
import com.gov.erf.models.account.request.RoleRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class DefaultRoleMapper implements RoleMapper {

    @Override
    public RoleDto toRoleDto(Role role) {

        var roleDto = new RoleDto();

        roleDto.setTitle(role.getTitle());
        return roleDto;
    }

    @Override
    public Collection<RoleDto> toRoleDtos(Collection<Role> roles) {

        Collection<RoleDto> roleDtos = new ArrayList<>();
        for (Role role : roles){
            roleDtos.add(toRoleDto(role));
        }
        return roleDtos;
    }

    @Override
    public RoleRequest toRoleRequest(RoleRequestDto roleRequestDto) {
        return RoleRequest.builder()
                .title(roleRequestDto.getTitle())
                .build();
    }
}
