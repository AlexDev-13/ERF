package com.gov.erf.mapper.account.role;

import com.gov.erf.dto.http.account.RoleDto;
import com.gov.erf.dto.http.account.RoleRequestDto;
import com.gov.erf.models.account.Role;
import com.gov.erf.models.account.request.RoleRequest;

import java.util.Collection;

public interface RoleMapper {
    RoleDto toRoleDto(Role role);

    Collection<RoleDto> toRoleDtos(Collection<Role> roles);

    RoleRequest toRoleRequest(RoleRequestDto roleRequestDto);
}
