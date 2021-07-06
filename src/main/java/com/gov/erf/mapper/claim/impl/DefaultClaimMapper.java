package com.gov.erf.mapper.claim.impl;

import com.gov.erf.dto.http.claim.*;
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
import com.gov.erf.models.claims.*;
import com.gov.erf.models.claims.request.AddClaimRequest;
import com.gov.erf.models.claims.tables.AuthorizedBody;
import com.gov.erf.models.claims.tables.ResponsibleBody;
import com.gov.erf.models.claims.tables.TableCommission;
import com.gov.erf.models.claims.tables.request.AuthorizedBodyRequest;
import com.gov.erf.models.claims.tables.request.ResponsibleBodyRequest;
import com.gov.erf.models.claims.tables.request.TableCommissionRequest;
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
    private final CauseService causeOfFactorService;
    private final CauseMapper causeMapper;
    private final SubjectService subjectService;
    private final SubjectMapper subjectMapper;

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
                    InnMapper innMapper,
                    CauseService causeOfFactorService,
                    CauseMapper causeMapper,
                    SubjectService subjectService,
                    SubjectMapper subjectMapper
            ) {
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
        this.causeOfFactorService = causeOfFactorService;
        this.causeMapper = causeMapper;
        this.subjectService = subjectService;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public AddClaimRequest toClaimRequest(AddClaimRequestDto addClaimRequestDto) throws Exception {

        EconomicActivity economicActivity = economicActivityService.get(addClaimRequestDto.getEconomicActivityId());
        Region region = regionService.get(addClaimRequestDto.getRegionId());
        Organ organ = organService.get(addClaimRequestDto.getOrganId());
        Applicant applicant = applicantService.get(addClaimRequestDto.getApplicantType());
        Cause causeOfFactor = causeOfFactorService.get(addClaimRequestDto.getCauseOfFactor());
        Subject subject = subjectService.get(addClaimRequestDto.getSubjectTypeId());

        return AddClaimRequest
                .builder()
                .applicantType(applicant)
                .fullname(addClaimRequestDto.getFullname())
                .email(addClaimRequestDto.getEmail())
                .inn(addClaimRequestDto.getInn())
                .companyName(addClaimRequestDto.getCompanyName())
                .telephone(addClaimRequestDto.getTelephone())
                .economicActivity(economicActivity)
                .region(region)
                .organ(organ)
                .subjectType(subject)
                .agreement(addClaimRequestDto.isAgreement())
                .causeOfFactor(causeOfFactor)
                .empowerment(addClaimRequestDto.getClarification())
                .identificationFactor(addClaimRequestDto.getDescriptionDate())
                .problemOfDescription(addClaimRequestDto.getProblemOfDescription())
                .build();
    }

    @Override
    public ClaimDto toClaimDto(Claim claim) {

        EconomicActivityDto economicActivityDto = economicActivityMapper.toEconomicActivityDto(claim.getEconomicActivity());
        OrganDto organDto = organMapper.toOrganDto(claim.getOrgan());
        RegionDto regionDto = regionMapper.toRegionDto(claim.getRegion());
        ApplicantDto applicantDto = applicantMapper.toApplicantDto(claim.getApplicantType());
        CauseDto causeDto = causeMapper.toCauseDto(claim.getCauseOfFactor());
        SubjectDto subjectDto = subjectMapper.toSubjectDto(claim.getSubject());


        var claimDto = new ClaimDto();
        claimDto.setId(claim.getId());
        claimDto.setFullname(claim.getFullname());
        claimDto.setTelephone(claim.getTelephone());
        claimDto.setEmail(claim.getEmail());
        claimDto.setInn(claim.getInn());
        claimDto.setCompanyName(claim.getCompanyName());
        claimDto.setApplicantType(applicantDto);
        claimDto.setEconomicActivity(economicActivityDto);
        claimDto.setOrgan(organDto);
        claimDto.setRegion(regionDto);
        claimDto.setStatus(claim.getStatus().getTitle());
        claimDto.setEmpowerment(claim.getEmpowerment());
        claimDto.setCauseOfFactor(causeDto);
        claimDto.setSubjectType(subjectDto);
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
