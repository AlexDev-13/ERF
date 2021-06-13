package com.gov.erf.endpoint.account;

import com.gov.erf.dto.http.account.RegistrationRequestDto;

public interface AccountEndpoint {

    String register(RegistrationRequestDto registrationRequestDto);
    String confirmToken(String token);
}
