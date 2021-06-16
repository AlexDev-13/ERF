package com.gov.erf.controller.account;


import com.gov.erf.dto.http.account.AddUserRequestDto;
import com.gov.erf.dto.http.account.UserDto;
import com.gov.erf.endpoint.account.AccountEndpoint;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "api/v1/account")
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
    public String confirm(@RequestParam("token") String token){
        return accountEndpoint.confirmToken(token);
    }
}
