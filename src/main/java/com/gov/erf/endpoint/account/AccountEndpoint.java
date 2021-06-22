package com.gov.erf.endpoint.account;

import com.gov.erf.dto.http.account.AddUserRequestDto;
import com.gov.erf.dto.http.account.UserDto;

import java.util.Collection;

public interface AccountEndpoint {

    String register(AddUserRequestDto addUserRequestDto);

    String confirmToken(String token);

    Collection<UserDto> getAllUsers();

    UserDto findById(Long id);

    void deleteById(Long id);

    UserDto updateUser(Long id, AddUserRequestDto requestDto);
}
