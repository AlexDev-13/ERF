package com.gov.erf.endpoint.claim.impl;

import com.gov.erf.config.data.ClaimFileConfigurations;
import com.gov.erf.dto.http.claims.ClaimDto;
import com.gov.erf.dto.http.claims.request.AddClaimRequestDto;
import com.gov.erf.endpoint.claim.ClaimEndpoint;
import com.gov.erf.mapper.claim.ClaimMapper;
import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.request.AddClaimRequest;
import com.gov.erf.modules.models.AppFile;
import com.gov.erf.modules.service.AppFileCreateService;
import com.gov.erf.service.claim.ClaimService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    public ClaimDto create(AddClaimRequestDto addClaimRequestDto, MultipartFile file) throws Exception {

        AddClaimRequest addClaimRequest = claimMapper.toClaimRequest(addClaimRequestDto);
        Claim claim = claimService.create(addClaimRequest);

        if (Objects.nonNull(file)) {
            saveFile(claim, file);
        }

        return claimMapper.toClaimDto(claim);
    }

    public void saveFile(Claim claim, MultipartFile file) throws Exception {
        String folderToSave = claimFileConfigurations.getFilesDir() + "/claims/" + claim.getId();
        AppFile appFile = appFileCreateService.createAppFile(file, folderToSave);
        claimService.updateFile(claim, appFile);
    }

}
