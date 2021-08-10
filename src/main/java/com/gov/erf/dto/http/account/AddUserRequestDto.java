package com.gov.erf.dto.http.account;

import com.gov.erf.dto.http.claim.request.AddRegionRequestDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddUserRequestDto {

    @NotNull
    private final String name;
    @NotNull
    private final String surname;
    private final String patronymic;
    private final Long roleId;
    private final Long regionId;
    private final Long organId;

    @NotNull
    private final String username;
    private final String email;
    private final String phoneNumber;
    private final String password;
}
