package com.gov.erf.endpoint.claim;

import com.gov.erf.dto.http.claims.ClaimDto;
import com.gov.erf.dto.http.claims.request.AddClaimRequestDto;
import com.gov.erf.dto.http.claims.request.SearchClaimsByParam;
import com.gov.erf.dto.http.claims.tables.TableAuthorizedBodyDto;
import com.gov.erf.dto.http.claims.tables.TableCommissionDto;
import com.gov.erf.dto.http.claims.tables.TableResponsibleBodyDto;
import com.gov.erf.dto.http.claims.tables.request.InfoRequestCommissionDto;
import com.gov.erf.dto.http.claims.tables.request.InfoRequestFromAuthorizedBodyDto;
import com.gov.erf.dto.http.claims.tables.request.InfoRequestFromResponsibleBodyDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

public interface ClaimEndpoint {

    ClaimDto create (AddClaimRequestDto addClaimRequestDto, MultipartFile file) throws Exception;

    ClaimDto getById(Long id);

    Collection<ClaimDto> getAll();

    TableResponsibleBodyDto perform(InfoRequestFromResponsibleBodyDto info);

    TableAuthorizedBodyDto perform(InfoRequestFromAuthorizedBodyDto info);

    TableCommissionDto perform(InfoRequestCommissionDto info);

    Collection<ClaimDto> searchByParam(String region);
}
