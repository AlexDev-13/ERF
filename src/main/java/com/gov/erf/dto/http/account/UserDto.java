package com.gov.erf.dto.http.account;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String username;
    private String email;
    private RoleDto role;

}
