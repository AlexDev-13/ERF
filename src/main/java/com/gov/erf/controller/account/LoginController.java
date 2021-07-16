package com.gov.erf.controller.account;

import com.gov.erf.dto.http.account.UserDto;
import com.gov.erf.mapper.account.AccountMapper;
import com.gov.erf.models.account.Admin;
import com.gov.erf.service.account.AccountService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    public LoginController(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping
    public UserDto getUser(@AuthenticationPrincipal Admin admin) {

        String username = admin.getUsername();

        Admin admin1 = (Admin) accountService.loadUserByUsername(username);
        return accountMapper.toUserDto(admin1);
    }

}
