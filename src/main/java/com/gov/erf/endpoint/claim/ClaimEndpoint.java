package com.gov.erf.endpoint.claim;

import com.gov.erf.dto.http.claim.ClaimDto;
import com.gov.erf.dto.http.request.AddClaimRequestDto;
import com.gov.erf.dto.http.tables.TableAuthorizedBodyDto;
import com.gov.erf.dto.http.tables.TableCommissionDto;
import com.gov.erf.dto.http.tables.TableResponsibleBodyDto;
import com.gov.erf.dto.http.tables.request.InfoRequestCommissionDto;
import com.gov.erf.dto.http.tables.request.InfoRequestFromAuthorizedBodyDto;
import com.gov.erf.dto.http.tables.request.InfoRequestFromResponsibleBodyDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

public interface ClaimEndpoint {

    ClaimDto create(Long id, AddClaimRequestDto addClaimRequestDto, MultipartFile file) throws Exception;

    ClaimDto getById(Long id);

    Collection<ClaimDto> getAll();

    TableResponsibleBodyDto perform(InfoRequestFromResponsibleBodyDto info);

    TableAuthorizedBodyDto perform(InfoRequestFromAuthorizedBodyDto info);

    TableCommissionDto perform(InfoRequestCommissionDto info);

    Collection<ClaimDto> searchByParam(String region);
}
