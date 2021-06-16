package com.gov.erf.service.account;

import com.gov.erf.dto.http.account.AddUserRequestDto;

public interface RegisterService {

    String register(AddUserRequestDto addUserRequestDto);

    String confirmToken(String token);
}
