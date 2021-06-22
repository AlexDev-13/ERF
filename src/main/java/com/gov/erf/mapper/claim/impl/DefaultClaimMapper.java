package com.gov.erf.mapper.claim.impl;

import com.gov.erf.dto.http.claim.*;
import com.gov.erf.dto.http.inn.InnDto;
import com.gov.erf.dto.http.request.AddClaimRequestDto;
import com.gov.erf.dto.http.tables.TableAuthorizedBodyDto;
import com.gov.erf.dto.http.tables.TableCommissionDto;
import com.gov.erf.dto.http.tables.TableResponsibleBodyDto;
import com.gov.erf.dto.http.tables.request.InfoRequestCommissionDto;
import com.gov.erf.dto.http.tables.request.InfoRequestFromAuthorizedBodyDto;
import com.gov.erf.dto.http.tables.request.InfoRequestFromResponsibleBodyDto;
import com.gov.erf.mapper.claim.*;
import com.gov.erf.mapper.inn.InnMapper;
import com.gov.erf.models.account.Applicant;
import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.models.claims.Organ;
import com.gov.erf.models.claims.Region;
import com.gov.erf.models.claims.request.AddClaimRequest;
import com.gov.erf.models.claims.tables.AuthorizedBody;
import com.gov.erf.models.claims.tables.ResponsibleBody;
import com.gov.erf.models.claims.tables.TableCommission;
import com.gov.erf.models.claims.tables.request.AuthorizedBodyRequest;
import com.gov.erf.models.claims.tables.request.ResponsibleBodyRequest;
import com.gov.erf.models.claims.tables.request.TableCommissionRequest;
import com.gov.erf.models.inn.Inn;
import com.gov.erf.service.claim.*;
import com.gov.erf.service.inn.InnService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class DefaultClaimMapper implements ClaimMapper {

    private final EconomicActivityService economicActivityService;
    private final ClaimService claimService;
    private final OrganService organService;
    private final RegionService regionService;
    private final EconomicActivityMapper economicActivityMapper;
    private final OrganMapper organMapper;
    private final RegionMapper regionMapper;
    private final ApplicantMapper applicantMapper;
    private final ApplicantService applicantService;
    private final InnService innService;
    private final InnMapper innMapper;

    public DefaultClaimMapper
            (
                    EconomicActivityService economicActivityService,
                    ClaimService claimService, OrganService organService,
                    RegionService regionService,
                    EconomicActivityMapper economicActivityMapper,
                    OrganMapper organMapper,
                    RegionMapper regionMapper,
                    ApplicantMapper applicantMapper,
                    ApplicantService applicantService,
                    InnService innService,
                    InnMapper innMapper) {
        this.economicActivityService = economicActivityService;
        this.claimService = claimService;
        this.organService = organService;
        this.regionService = regionService;
        this.economicActivityMapper = economicActivityMapper;
        this.organMapper = organMapper;
        this.regionMapper = regionMapper;
        this.applicantMapper = applicantMapper;
        this.applicantService = applicantService;
        this.innService = innService;
        this.innMapper = innMapper;
    }

    @Override
    public AddClaimRequest toClaimRequest(AddClaimRequestDto addClaimRequestDto) throws Exception {

        EconomicActivity economicActivity = economicActivityService.get(addClaimRequestDto.getEconomicActivityId());
        Region region = regionService.get(addClaimRequestDto.getRegionId());
        Organ organ = organService.get(addClaimRequestDto.getOrganId());
        Applicant applicant = applicantService.get(addClaimRequestDto.getApplicantType());
        Inn inn = innService.getInn(addClaimRequestDto.getInn());

        return AddClaimRequest
                .builder()
                .applicantType(applicant)
                .fullname(addClaimRequestDto.getFullname())
                .email(addClaimRequestDto.getEmail())
                .inn(inn)
                .telephone(addClaimRequestDto.getTelephone())
                .economicActivity(economicActivity)
                .region(region)
                .organ(organ)
                .causeOfFactor(addClaimRequestDto.getCauseOfFactor())
                .empowerment(addClaimRequestDto.getEmpowerment())
                .identificationFactor(addClaimRequestDto.getIdentificationFactor())
                .problemOfDescription(addClaimRequestDto.getProblemOfDescription())
                .build();
    }

    @Override
    public ClaimDto toClaimDto(Claim claim) {

        EconomicActivityDto economicActivityDto = economicActivityMapper.toEconomicActivityDto(claim.getEconomicActivity());
        OrganDto organDto = organMapper.toOrganDto(claim.getOrgan());
        RegionDto regionDto = regionMapper.toRegionDto(claim.getRegion());
        ApplicantDto applicantDto = applicantMapper.toApplicantDto(claim.getApplicantType());
        InnDto innDto = innMapper.toInnDto(claim.getInn());

        var claimDto = new ClaimDto();
        claimDto.setId(claim.getId());
        claimDto.setFullname(claim.getFullname());
        claimDto.setTelephone(claim.getTelephone());
        claimDto.setEmail(claim.getEmail());
        claimDto.setInn(innDto);
        claimDto.setApplicantType(applicantDto);
        claimDto.setEconomicActivity(economicActivityDto);
        claimDto.setOrgan(organDto);
        claimDto.setRegion(regionDto);
        claimDto.setEmpowerment(claim.getEmpowerment());
        claimDto.setCauseOfFactor(claim.getCauseOfFactor());
        claimDto.setIdentificationFactor(claim.getIdentificationFactor());
        claimDto.setProblemOfDescription(claim.getProblemOfDescription());

        return claimDto;
    }

    @Override
    public TableResponsibleBodyDto toResponsibleBodyDto(ResponsibleBody body) {

        var responsibleBodyDto = new TableResponsibleBodyDto();
        ClaimDto claimDto = toClaimDto(body.getClaim());

        responsibleBodyDto.setClaimId(claimDto);
        responsibleBodyDto.setCause(body.getCause());
        responsibleBodyDto.setDecision(body.getDecision());

        return responsibleBodyDto;
    }

    @Override
    public TableAuthorizedBodyDto toTableAuthorizedBodyDto(AuthorizedBody body) {
        var authorizedBodyDto = new TableAuthorizedBodyDto();
        ClaimDto claimDto = toClaimDto(body.getClaim());

        authorizedBodyDto.setClaimId(claimDto);
        authorizedBodyDto.setCause(body.getCause());
        authorizedBodyDto.setDecision(body.getDecision());

        return authorizedBodyDto;
    }

    @Override
    public Collection<ClaimDto> toClaimDtos(Collection<Claim> claims) {

        Collection<ClaimDto> claimDtos = new ArrayList<>();

        for (Claim claim : claims) {
            claimDtos.add(toClaimDto(claim));
        }
        return claimDtos;
    }

    @Override
    public TableCommissionRequest toCommissionRequest(InfoRequestCommissionDto info) {
        Claim claim = claimService.getById(info.getClaimId());

        return TableCommissionRequest.builder()
                .claim(claim)
                .cause(info.getCause())
                .decision(info.getDecision())
                .build();
    }

    @Override
    public TableCommissionDto toCommissionDto(TableCommission tableCommission) {
        var commissionDto = new TableCommissionDto();
        ClaimDto claimDto = toClaimDto(tableCommission.getClaim());

        commissionDto.setClaimId(claimDto);
        commissionDto.setCause(tableCommission.getCause());
        commissionDto.setDecision(tableCommission.getDecision());
        return commissionDto;
    }

    @Override
    public ResponsibleBodyRequest toResponsibleBodyRequest(InfoRequestFromResponsibleBodyDto infoRequestFromResponsibleBodyDto) {

        Claim claim = claimService.getById(infoRequestFromResponsibleBodyDto.getClaimId());

        return ResponsibleBodyRequest.builder()
                .claim(claim)
                .cause(infoRequestFromResponsibleBodyDto.getCause())
                .decision(infoRequestFromResponsibleBodyDto.getDecision())
                .build();
    }

    @Override
    public AuthorizedBodyRequest toAuthorizedBodyRequest(InfoRequestFromAuthorizedBodyDto infoRequestFromAuthorizedBodyDto) {

        Claim claim = claimService.getById(infoRequestFromAuthorizedBodyDto.getClaimId());

        return AuthorizedBodyRequest.builder()
                .claim(claim)
                .cause(infoRequestFromAuthorizedBodyDto.getCause())
                .decision(infoRequestFromAuthorizedBodyDto.getDecision())
                .build();
    }
}
