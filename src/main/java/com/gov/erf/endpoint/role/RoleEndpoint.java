package com.gov.erf.endpoint.role;

import com.gov.erf.dto.http.account.RoleDto;
import com.gov.erf.dto.http.account.RoleRequestDto;

import java.util.Collection;

public interface RoleEndpoint {

    RoleDto getById(Long id);

    RoleDto delete(Long id);

    Collection<RoleDto> getAll();

    RoleDto create(RoleRequestDto roleRequestDto);

}
