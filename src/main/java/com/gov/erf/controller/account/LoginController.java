package com.gov.erf.controller.account;

import com.gov.erf.dto.http.account.UserDto;
import com.gov.erf.mapper.account.AccountMapper;
import com.gov.erf.models.account.Admin;
import com.gov.erf.service.account.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    public LoginController(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping
    public UserDto getUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        Admin admin = (Admin) accountService.loadUserByUsername(username);
        return accountMapper.toUserDto(admin);
    }

}
