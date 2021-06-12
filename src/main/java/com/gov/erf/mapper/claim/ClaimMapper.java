package com.gov.erf.mapper.claim;

import com.gov.erf.dto.http.claims.ClaimDto;
import com.gov.erf.dto.http.claims.request.AddClaimRequestDto;
import com.gov.erf.dto.http.claims.tables.TableAuthorizedBodyDto;
import com.gov.erf.dto.http.claims.tables.TableCommissionDto;
import com.gov.erf.dto.http.claims.tables.TableResponsibleBodyDto;
import com.gov.erf.dto.http.claims.tables.request.InfoRequestCommissionDto;
import com.gov.erf.dto.http.claims.tables.request.InfoRequestFromAuthorizedBodyDto;
import com.gov.erf.dto.http.claims.tables.request.InfoRequestFromResponsibleBodyDto;
import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.request.AddClaimRequest;
import com.gov.erf.models.claims.tables.AuthorizedBody;
import com.gov.erf.models.claims.tables.ResponsibleBody;
import com.gov.erf.models.claims.tables.TableCommission;
import com.gov.erf.models.claims.tables.request.AuthorizedBodyRequest;
import com.gov.erf.models.claims.tables.request.ResponsibleBodyRequest;
import com.gov.erf.models.claims.tables.request.TableCommissionRequest;

import java.util.Collection;

public interface ClaimMapper {
    AddClaimRequest toClaimRequest(AddClaimRequestDto addClaimRequestDto);

    ClaimDto toClaimDto(Claim claim);

    TableResponsibleBodyDto toResponsibleBodyDto(ResponsibleBody body);

    TableAuthorizedBodyDto toTableAuthorizedBodyDto(AuthorizedBody body);

    Collection<ClaimDto> toClaimDtos(Collection<Claim> claims);

    TableCommissionRequest toCommissionRequest(InfoRequestCommissionDto info);

    TableCommissionDto toCommissionDto(TableCommission tableCommission);

    ResponsibleBodyRequest toResponsibleBodyRequest(InfoRequestFromResponsibleBodyDto infoRequestFromResponsibleBodyDto);

    AuthorizedBodyRequest toAuthorizedBodyRequest(InfoRequestFromAuthorizedBodyDto infoRequestFromAuthorizedBodyDto);
}
