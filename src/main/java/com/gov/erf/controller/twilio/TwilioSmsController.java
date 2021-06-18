package com.gov.erf.controller.twilio;

import com.gov.erf.models.sms.SMSRequest;
import com.gov.erf.service.sms.SmsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sms")
public class TwilioSmsController {

    private final SmsService service;

    public TwilioSmsController(SmsService service) {
        this.service = service;
    }

    @PostMapping
    public void sendSms(@RequestBody SMSRequest smsRequest){
        service.sender(smsRequest);
    }

}
