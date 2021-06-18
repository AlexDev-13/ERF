package com.gov.erf.service.sms;

import com.gov.erf.models.sms.SMSRequest;

public interface SmsService {

    void sender(SMSRequest smsRequest);
}
