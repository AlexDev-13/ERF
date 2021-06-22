package com.gov.erf.controller.account;


import com.gov.erf.dto.http.account.AddUserRequestDto;
import com.gov.erf.dto.http.account.UserDto;
import com.gov.erf.endpoint.account.AccountEndpoint;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {

    private final AccountEndpoint accountEndpoint;

    public AccountController(
            AccountEndpoint accountEndpoint
    ) {
        this.accountEndpoint = accountEndpoint;
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
