package com.gov.erf.service.sms.impl;

import com.gov.erf.models.sms.SMSRequest;
import com.gov.erf.service.sms.SmsSender;
import com.gov.erf.service.sms.SmsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DefaultSmsService implements SmsService {

    private final SmsSender smsSender;

    public DefaultSmsService(@Qualifier("twilio") SmsSender smsSender) {
        this.smsSender = smsSender;
    }

    @Override
    public void sender(SMSRequest smsRequest) {
        smsSender.sendSms(smsRequest);
    }
}
