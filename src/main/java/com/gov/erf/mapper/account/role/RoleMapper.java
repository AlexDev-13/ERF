package com.gov.erf.mapper.account.role;

import com.gov.erf.dto.http.account.RoleDto;
import com.gov.erf.models.account.Role;

public interface RoleMapper {
    RoleDto toRoleDto(Role role);
}
