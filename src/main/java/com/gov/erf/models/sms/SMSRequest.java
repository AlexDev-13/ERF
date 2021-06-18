package com.gov.erf.models.sms;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SMSRequest {

    private final String phoneNumber;
    private final String message;

    public SMSRequest
            (
                    @JsonProperty("phoneNumber")
                    String phoneNumber,

                    @JsonProperty("message")
                    String message
            ) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }


    @Override
    public String toString() {
        return "SMSRequest{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
