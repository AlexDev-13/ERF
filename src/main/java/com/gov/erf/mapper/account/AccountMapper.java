package com.gov.erf.mapper.account;

import com.gov.erf.dto.http.account.UserDto;
import com.gov.erf.models.account.Admin;

import java.util.Collection;

public interface AccountMapper {

    Collection<UserDto> toUserDtos(Collection<Admin> admins);
    UserDto toUserDto(Admin admin);

}
