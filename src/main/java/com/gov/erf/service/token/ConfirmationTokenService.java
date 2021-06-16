package com.gov.erf.service.token;

import com.gov.erf.models.account.token.ConfirmToken;
import com.gov.erf.repository.token.ConfirmTokenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ConfirmationTokenService {

    private final ConfirmTokenRepository confirmTokenRepository;

    public ConfirmationTokenService(ConfirmTokenRepository confirmTokenRepository
    ) {
        this.confirmTokenRepository = confirmTokenRepository;
    }

    public void saveConfirmationToken(ConfirmToken token) {
        confirmTokenRepository.save(token);
    }

    public Optional<ConfirmToken> getToken(String token) {
        return confirmTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
