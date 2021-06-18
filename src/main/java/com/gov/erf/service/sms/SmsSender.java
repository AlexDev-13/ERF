package com.gov.erf.service.sms;

import com.gov.erf.models.sms.SMSRequest;

public interface SmsSender {

    void sendSms(SMSRequest smsRequest);
}
