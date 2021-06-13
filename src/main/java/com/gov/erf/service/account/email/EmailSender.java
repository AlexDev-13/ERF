package com.gov.erf.service.account.email;

public interface EmailSender {
    void send(String to, String email);
}
