package com.gov.erf.endpoint.account.inn;

import com.gov.erf.dto.http.inn.InnDto;

public interface InnEndpoint {

    InnDto getInn(String inn);
}
