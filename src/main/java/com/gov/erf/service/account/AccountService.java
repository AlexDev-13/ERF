package com.gov.erf.service.account;

import com.gov.erf.models.account.Admin;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {

    String signUp(Admin admin);

    int enableAppUser(String email);
}
