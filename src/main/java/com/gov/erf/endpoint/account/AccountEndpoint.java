package com.gov.erf.endpoint.account;

import com.gov.erf.dto.http.account.AddUserRequestDto;

public interface AccountEndpoint {

    String register(AddUserRequestDto addUserRequestDto);

    String confirmToken(String token);
}
