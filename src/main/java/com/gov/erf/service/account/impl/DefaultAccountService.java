package com.gov.erf.service.account.impl;

import com.gov.erf.models.account.Admin;
import com.gov.erf.models.account.token.ConfirmToken;
import com.gov.erf.repository.account.AdminRepository;
import com.gov.erf.service.account.AccountService;
import com.gov.erf.service.token.ConfirmationTokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class DefaultAccountService implements AccountService {

    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;


    public DefaultAccountService(
            AdminRepository adminRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder,
            ConfirmationTokenService confirmationTokenService
    ) {
        this.adminRepository = adminRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return adminRepository.findByUsername(s).orElseThrow();
    }

    @Override
    public String signUp(Admin admin) {

        boolean isExists = adminRepository.findByUsername(admin.getUsername()).isPresent();
        if (isExists) {
            throw new IllegalStateException("Username is exists");
        }
        String encodePassword = bCryptPasswordEncoder.encode(admin.getPassword());
        admin.setPassword(encodePassword);

        adminRepository.save(admin);

        String token = UUID.randomUUID().toString();

        ConfirmToken confirmToken = new ConfirmToken(
                token,
                admin,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15)
        );

        confirmationTokenService.saveConfirmationToken(confirmToken);

        return token;
    }

    @Override
    public int enableAppUser(String email) {
        return adminRepository.enableAppUser(email);
    }

}
