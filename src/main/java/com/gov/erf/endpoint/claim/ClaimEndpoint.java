package com.gov.erf.endpoint.claim;

import com.gov.erf.dto.http.claim.ClaimDto;
import com.gov.erf.dto.http.request.AddClaimRequestDto;
import com.gov.erf.dto.http.tables.TableAuthorizedBodyDto;
import com.gov.erf.dto.http.tables.TableCommissionDto;
import com.gov.erf.dto.http.tables.TableResponsibleBodyDto;
import com.gov.erf.dto.http.tables.request.InfoRequestCommissionDto;
import com.gov.erf.dto.http.tables.request.InfoRequestFromAuthorizedBodyDto;
import com.gov.erf.dto.http.tables.request.InfoRequestFromResponsibleBodyDto;
import com.gov.erf.models.claims.Claim;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

public interface ClaimEndpoint {

    ClaimDto create(Long id, AddClaimRequestDto addClaimRequestDto, MultipartFile file) throws Exception;

    ClaimDto getById(Long id);

    Page<Claim> getAll(Pageable pageable);

    TableResponsibleBodyDto perform(InfoRequestFromResponsibleBodyDto info);

    TableAuthorizedBodyDto perform(InfoRequestFromAuthorizedBodyDto info);

    TableCommissionDto perform(InfoRequestCommissionDto info);

    Collection<ClaimDto> searchByParam(String region);
}
