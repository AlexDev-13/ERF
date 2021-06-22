package com.gov.erf.service.claim;

import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.request.AddClaimRequest;
import com.gov.erf.models.claims.tables.AuthorizedBody;
import com.gov.erf.models.claims.tables.ResponsibleBody;
import com.gov.erf.models.claims.tables.TableCommission;
import com.gov.erf.models.claims.tables.request.AuthorizedBodyRequest;
import com.gov.erf.models.claims.tables.request.ResponsibleBodyRequest;
import com.gov.erf.models.claims.tables.request.TableCommissionRequest;
import com.gov.erf.modules.models.AppFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface ClaimService {

    Claim create(Long id, AddClaimRequest request) throws Exception;

    ResponsibleBody create(ResponsibleBodyRequest request);

    AuthorizedBody create(AuthorizedBodyRequest request);

    TableCommission create(TableCommissionRequest request);

    Claim updateFile(Claim claim, AppFile appFile);

    Page<Claim> getAll(Pageable pageable);

    Claim getById(Long id);

    Collection<Claim> searchByParam(String searchClaimsByParam);

}
