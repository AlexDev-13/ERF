package com.gov.erf.mapper.inn;

import com.gov.erf.dto.http.inn.InnDto;
import com.gov.erf.models.inn.Inn;

public interface InnMapper {

    InnDto toInnDto(Inn inn);
}
