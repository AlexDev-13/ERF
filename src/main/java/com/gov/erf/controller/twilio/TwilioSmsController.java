package com.gov.erf.controller.twilio;

import com.gov.erf.models.sms.SMSRequest;
import com.gov.erf.service.sms.SmsService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
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
