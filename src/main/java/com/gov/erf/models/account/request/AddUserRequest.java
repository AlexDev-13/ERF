package com.gov.erf.models.account.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddUserRequest {

    private final String name;
    private final String surname;
    private final String patronymic;
    private final String username;
    private final String email;
    private final String password;

}
