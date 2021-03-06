package com.gov.erf.endpoint.claim.impl;

import com.gov.erf.config.data.ClaimFileConfigurations;
import com.gov.erf.dto.http.claim.ClaimDto;
import com.gov.erf.dto.http.request.AddClaimRequestDto;
import com.gov.erf.dto.http.tables.TableAuthorizedBodyDto;
import com.gov.erf.dto.http.tables.TableCommissionDto;
import com.gov.erf.dto.http.tables.TableResponsibleBodyDto;
import com.gov.erf.dto.http.tables.request.InfoRequestCommissionDto;
import com.gov.erf.dto.http.tables.request.InfoRequestFromAuthorizedBodyDto;
import com.gov.erf.dto.http.tables.request.InfoRequestFromResponsibleBodyDto;
import com.gov.erf.endpoint.claim.ClaimEndpoint;
import com.gov.erf.mapper.claim.ClaimMapper;
import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.request.AddClaimRequest;
import com.gov.erf.models.claims.tables.AuthorizedBody;
import com.gov.erf.models.claims.tables.ResponsibleBody;
import com.gov.erf.models.claims.tables.TableCommission;
import com.gov.erf.models.claims.tables.request.AuthorizedBodyRequest;
import com.gov.erf.models.claims.tables.request.ResponsibleBodyRequest;
import com.gov.erf.models.claims.tables.request.TableCommissionRequest;
import com.gov.erf.modules.models.AppFile;
import com.gov.erf.modules.service.AppFileCreateService;
import com.gov.erf.service.claim.ClaimService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Objects;

@Service
public class DefaultClaimEndpoint implements ClaimEndpoint {

    private final ClaimMapper claimMapper;
    private final ClaimService claimService;
    private final AppFileCreateService appFileCreateService;
    private final ClaimFileConfigurations claimFileConfigurations;

    public DefaultClaimEndpoint
            (
                    ClaimMapper claimMapper,
                    ClaimService claimService,
                    AppFileCreateService appFileCreateService,
                    ClaimFileConfigurations claimFileConfigurations
            ) {
        this.claimMapper = claimMapper;
        this.claimService = claimService;
        this.appFileCreateService = appFileCreateService;
        this.claimFileConfigurations = claimFileConfigurations;
    }


    @Override
    public ClaimDto create(Long id, AddClaimRequestDto addClaimRequestDto, MultipartFile file) throws Exception {

        AddClaimRequest addClaimRequest = claimMapper.toClaimRequest(addClaimRequestDto);

        Claim claim = claimService.create(id, addClaimRequest);

        if (Objects.nonNull(file)) {
            saveFile(claim, file);
        }

        return claimMapper.toClaimDto(claim);
    }

    @Override
    public ClaimDto getById(Long id) {

        Claim claim = claimService.getById(id);
        return claimMapper.toClaimDto(claim);
    }

    @Override
    public Page<Claim> getAll(Pageable pageable) {

//        Page<Claim> claims = claimService.getAll(pageable);

        return claimService.getAll(pageable);
    }

    @Override
    public TableResponsibleBodyDto perform(InfoRequestFromResponsibleBodyDto info) {

        ResponsibleBodyRequest responsibleBodyRequest = claimMapper.toResponsibleBodyRequest(info);
        ResponsibleBody responsibleBody = claimService.create(responsibleBodyRequest);

        return claimMapper.toResponsibleBodyDto(responsibleBody);
    }

    @Override
    public TableAuthorizedBodyDto perform(InfoRequestFromAuthorizedBodyDto info) {

        AuthorizedBodyRequest authorizedBodyRequest = claimMapper.toAuthorizedBodyRequest(info);

        AuthorizedBody authorizedBody = claimService.create(authorizedBodyRequest);

        return claimMapper.toTableAuthorizedBodyDto(authorizedBody);
    }

    @Override
    public TableCommissionDto perform(InfoRequestCommissionDto info) {

        TableCommissionRequest tableCommissionRequest = claimMapper.toCommissionRequest(info);
        TableCommission tableCommission = claimService.create(tableCommissionRequest);

        return claimMapper.toCommissionDto(tableCommission);

    }

    @Override
    public Collection<ClaimDto> searchByParam(String searchClaimsByParam) {

        Collection<Claim> claims = claimService.searchByParam(searchClaimsByParam);

        return claimMapper.toClaimDtos(claims);
    }

    private void saveFile(Claim claim, MultipartFile file) throws Exception {
        String folderToSave = claimFileConfigurations.getFilesDir() + "/claims/" + claim.getId();
        AppFile appFile = appFileCreateService.createAppFile(file, folderToSave);
        claimService.updateFile(claim, appFile);
    }

}
