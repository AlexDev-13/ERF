package com.gov.erf.controller.account;


import com.gov.erf.dto.http.account.AddUserRequestDto;
import com.gov.erf.dto.http.account.UserDto;
import com.gov.erf.endpoint.account.AccountEndpoint;
import com.gov.erf.mapper.account.AccountMapper;
import com.gov.erf.models.account.Admin;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("api/v1/account")
public class AccountController {

    private final AccountEndpoint accountEndpoint;
    private final AccountMapper accountMapper;

    public AccountController(
            AccountEndpoint accountEndpoint,
            AccountMapper accountMapper) {
        this.accountEndpoint = accountEndpoint;
        this.accountMapper = accountMapper;
    }

    @PostMapping("/login")
    public UserDto login(Principal principal){
        Admin admin = (Admin) ((Authentication) principal).getPrincipal();
        return accountMapper.toUserDto(admin);
    }

    @PostMapping
    public String register(@RequestBody AddUserRequestDto account) {
        return accountEndpoint.register(account);
    }

    @GetMapping("/confirm")
    public String confirm(@RequestParam("token") String token) {
        return accountEndpoint.confirmToken(token);
    }

    @GetMapping("/get-all")
    public Collection<UserDto> getAllUsers() {
        return accountEndpoint.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public UserDto getById(@PathVariable("id") Long id) {
        return accountEndpoint.findById(id);
    }

    @PutMapping("/put/{id}")
    public UserDto putUser(@PathVariable("id") Long id, @RequestBody AddUserRequestDto requestDto) {
        return accountEndpoint.updateUser(id, requestDto);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        accountEndpoint.deleteById(id);
    }


}
