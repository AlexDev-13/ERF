package com.gov.erf.controller.account;

import com.gov.erf.dto.http.account.UserDto;
import com.gov.erf.mapper.account.AccountMapper;
import com.gov.erf.models.account.Admin;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final AccountMapper accountMapper;

    public LoginController(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @RequestMapping("/api/v1/login")
    public UserDto getLoggedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Admin admin = (Admin) auth.getPrincipal();
        System.out.println(admin);
        return accountMapper.toUserDto(admin);
    }

}
