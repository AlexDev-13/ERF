package com.gov.erf.service.account;

import com.gov.erf.dto.http.account.RegistrationRequestDto;

public interface RegisterService {

    String register(RegistrationRequestDto registrationRequestDto);
    String confirmToken(String token);
}
