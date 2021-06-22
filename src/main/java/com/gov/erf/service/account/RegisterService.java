package com.gov.erf.service.account;

import com.gov.erf.dto.http.account.AddUserRequestDto;
import com.gov.erf.models.account.Admin;

import java.util.Collection;

public interface RegisterService {

    String register(AddUserRequestDto addUserRequestDto);

    String confirmToken(String token);

    Collection<Admin> getAll();

    Admin findById(Long id);

    void deleteById(Long id);
}
