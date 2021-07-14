package com.gov.erf.service.claim.impl;

import com.gov.erf.config.predicate.builder.ClaimPage;
import com.gov.erf.config.predicate.criteria.ClaimSearchCriteria;
import com.gov.erf.models.account.Admin;
import com.gov.erf.models.account.Applicant;
import com.gov.erf.models.account.RoleType;
import com.gov.erf.models.action.MovementAction;
import com.gov.erf.models.action.MovementActionType;
import com.gov.erf.models.claims.Cause;
import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.Region;
import com.gov.erf.models.claims.Subject;
import com.gov.erf.models.claims.request.AddClaimRequest;
import com.gov.erf.models.claims.tables.AuthorizedBody;
import com.gov.erf.models.claims.tables.ResponsibleBody;
import com.gov.erf.models.claims.tables.TableCommission;
import com.gov.erf.models.claims.tables.request.AuthorizedBodyRequest;
import com.gov.erf.models.claims.tables.request.ResponsibleBodyRequest;
import com.gov.erf.models.claims.tables.request.TableCommissionRequest;
import com.gov.erf.models.point.MovementPoint;
import com.gov.erf.models.point.MovementPointType;
import com.gov.erf.models.status.Status;
import com.gov.erf.models.status.StatusType;
import com.gov.erf.modules.models.AppFile;
import com.gov.erf.repository.claim.*;
import com.gov.erf.service.account.AccountService;
import com.gov.erf.service.account.RegisterService;
import com.gov.erf.service.action.MovementActionService;
import com.gov.erf.service.claim.ApplicantService;
import com.gov.erf.service.claim.CauseService;
import com.gov.erf.service.claim.ClaimService;
import com.gov.erf.service.claim.SubjectService;
import com.gov.erf.service.inn.InnService;
import com.gov.erf.service.point.MovementPointService;
import com.gov.erf.service.status.StatusService;
import org.springframework.data.domain.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultClaimService implements ClaimService {

    private final ClaimRepository claimRepository;
    private final RegionRepository regionRepository;
    private final MovementPointService pointService;
    private final MovementActionService actionService;
    private final ResponsibleBodyRepository responsibleBodyRepository;
    private final AuthorizedBodyRepository authorizedBodyRepository;
    private final TableCommissionRepository tableCommissionRepository;
    private final ApplicantService applicantService;
    private final InnService innService;
    private final RegisterService registerService;
    private final StatusService statusService;
    private final ClaimCriteriaRepository claimCriteriaRepository;
    private final CauseService causeService;
    private final SubjectService subjectService;
    private final AccountService accountService;

    public DefaultClaimService
            (
                    ClaimRepository claimRepository,
                    RegionRepository regionRepository, MovementPointService pointService,
                    MovementActionService actionService,
                    ResponsibleBodyRepository responsibleBodyRepository,
                    AuthorizedBodyRepository authorizedBodyRepository,
                    TableCommissionRepository tableCommissionRepository,
                    ApplicantService applicantService, InnService innService,
                    RegisterService registerService,
                    StatusService statusService,
                    ClaimCriteriaRepository claimCriteriaRepository,
                    CauseService causeService, SubjectService subjectService,
                    AccountService accountService) {
        this.claimRepository = claimRepository;
        this.regionRepository = regionRepository;
        this.pointService = pointService;
        this.actionService = actionService;
        this.responsibleBodyRepository = responsibleBodyRepository;
        this.authorizedBodyRepository = authorizedBodyRepository;
        this.tableCommissionRepository = tableCommissionRepository;
        this.applicantService = applicantService;
        this.innService = innService;
        this.registerService = registerService;
        this.statusService = statusService;
        this.claimCriteriaRepository = claimCriteriaRepository;
        this.causeService = causeService;
        this.subjectService = subjectService;
        this.accountService = accountService;
    }

    @Override
    public Claim create(Long id, AddClaimRequest request) throws Exception {


        Admin admin;

        if (id != null) {
            admin = registerService.findById(id);
        } else {
            admin = null;
        }

        MovementPoint point = pointService.get(MovementPointType.ADMISSION);
        MovementAction action = actionService.get(MovementActionType.REGISTER);
        Status status = statusService.get(StatusType.IN_PROCESSING);
        Applicant applicant = applicantService.findByTitle(request.getApplicantType().getTitle());
        Cause cause = causeService.get(request.getCauseOfFactor().getId());
        Subject subject = subjectService.get(request.getSubjectType().getId());


        var claim = new Claim();

        claim.setAdmin(admin);
        claim.setFullname(request.getFullname());
        claim.setEmail(request.getEmail());
        claim.setInn(request.getInn());
        claim.setCompanyName(request.getCompanyName());
        claim.setCreatedAt(LocalDateTime.now());
//        claim.setCreatedBy(admin);
        claim.setSubject(subject);
        claim.setCauseOfFactor(cause);
        claim.setTelephone(request.getTelephone());
        claim.setApplicantType(applicant);
        claim.setOrgan(request.getOrgan());
        claim.setRegion(request.getRegion());
        claim.setEconomicActivity(request.getEconomicActivity());
        claim.setEmpowerment(request.getEmpowerment());
        claim.setCauseOfFactor(request.getCauseOfFactor());
        claim.setPoint(point);
        claim.setAgreement(request.getAgreement());
        claim.setAction(action);
        claim.setStatus(status);
        claim.setProblemOfDescription(request.getProblemOfDescription());
        claim.setIdentificationFactor(request.getIdentificationFactor());

        return claimRepository.save(claim);
    }

    @Override
    public ResponsibleBody create(ResponsibleBodyRequest request) {

        var responsibleBody = new ResponsibleBody();

        MovementActionType actionType = request.getDecision() ? MovementActionType.ORGAN_ACCEPT : MovementActionType.ORGAN_REJECT;

        MovementAction action = actionService.get(actionType);
        MovementPointType pointType = request.getDecision() ? MovementPointType.ACCEPT : MovementPointType.REJECT;
        MovementPoint point = pointService.get(pointType);
        var claim = request.getClaim();
        claim.setAction(action);
        claim.setPoint(point);

        Status status = null;

        if (actionType.equals(MovementActionType.ORGAN_ACCEPT)) {
            status = statusService.get(StatusType.UNDER_CONSIDERATION);
        } else {
            status = statusService.get(StatusType.DENIED);
        }

        claim.setStatus(status);

        responsibleBody.setClaim(claim);
        responsibleBody.setCause(request.getCause());
        responsibleBody.setDecision(actionType);

        return responsibleBodyRepository.save(responsibleBody);
    }

    @Override
    public AuthorizedBody create(AuthorizedBodyRequest request) {

        var authorizedBody = new AuthorizedBody();

        MovementActionType actionType = request.getDecision() ? MovementActionType.OPERATOR_ACCEPT : MovementActionType.OPERATOR_REJECT;

        MovementAction action = actionService.get(actionType);
        MovementPointType pointType = request.getDecision() ? MovementPointType.ACCEPT : MovementPointType.REJECT;
        MovementPoint point = pointService.get(pointType);
        var claim = request.getClaim();
        claim.setAction(action);
        claim.setPoint(point);

        Status status = null;

        if (actionType.equals(MovementActionType.OPERATOR_ACCEPT)) {
            status = statusService.get(StatusType.IN_PROCESSING);
        } else {
            status = statusService.get(StatusType.DENIED);
        }

        claim.setStatus(status);


        authorizedBody.setClaim(request.getClaim());
        authorizedBody.setCause(request.getCause());
        authorizedBody.setDecision(actionType);

        return authorizedBodyRepository.save(authorizedBody);
    }

    @Override
    public Page<Claim> getClaims( ClaimPage employeePage,
                                 ClaimSearchCriteria employeeSearchCriteria) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Pageable pageable = getPageable(employeePage);
        final int start = (int)pageable.getOffset();
        int end;
        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(RoleType.GLOBAL_ADMIN.name()))) {
            return claimCriteriaRepository.findAllWithFilters(employeePage, employeeSearchCriteria);
        }

        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(RoleType.REGIONAL_ADMIN.name()))) {
            Admin admin = (Admin) accountService.loadUserByUsername(auth.getName());
            List<Claim> claims = claimCriteriaRepository.findAllWithFilters(employeePage, employeeSearchCriteria).stream().filter(claim -> claim.getRegion().getTitle().equals(admin.getRegion().getTitle())).collect(Collectors.toList());
            end = Math.min((start + pageable.getPageSize()), claims.size());
            return new PageImpl<>(claims.subList(start, end), pageable, claims.size());
        }

        else {
            List<Claim> claims = claimCriteriaRepository.findAllWithFilters(employeePage, employeeSearchCriteria).stream().filter(claim -> claim.getStatus().getType().equals(StatusType.APPROVED) || claim.getStatus().getType().equals(StatusType.DENIED)).collect(Collectors.toList());
            end = Math.min((start + pageable.getPageSize()), claims.size());
            return new PageImpl<>(claims.subList(start, end), pageable, claims.size());
        }

//        return claimCriteriaRepository.findAllWithFilters(employeePage, employeeSearchCriteria);
    }

    @Override
    public Collection<Claim> searchByParam(String searchClaimsByParam) {
        return null;
    }

    @Override
    public TableCommission create(TableCommissionRequest request) {
        var tableCommission = new TableCommission();

        MovementActionType actionType = request.getDecision() ? MovementActionType.COMMISSION_ACCEPT : MovementActionType.COMMISSION_REJECT;

        MovementAction action = actionService.get(actionType);
        MovementPointType pointType = request.getDecision() ? MovementPointType.ACCEPT : MovementPointType.REJECT;
        MovementPoint point = pointService.get(pointType);
        var claim = request.getClaim();
        claim.setAction(action);
        claim.setPoint(point);

        Status status = null;

        if (actionType.equals(MovementActionType.COMMISSION_ACCEPT)) {
            status = statusService.get(StatusType.APPROVED);
        } else {
            status = statusService.get(StatusType.DENIED);
        }

        claim.setStatus(status);

        tableCommission.setClaim(request.getClaim());
        tableCommission.setCause(request.getCause());
        tableCommission.setDecision(actionType);

        return tableCommissionRepository.save(tableCommission);
    }

    @Override
    public Claim updateFile(Claim claim, AppFile appFile) {
        claim.setFile(appFile);
        return claimRepository.save(claim);
    }

    @Override
    public Page<Claim> getAll(Pageable pageable) {
        return claimRepository.findAll(pageable);
    }

    @Override
    public Claim getById(Long id) {
        return claimRepository.findById(id).orElseThrow();
    }

    /*@Override
    public Collection<Claim> searchByParam(String searchClaimsByParam) {

        Region region = regionRepository.findByTitle(searchClaimsByParam);
        return claimRepository.findAllByRegion(region);
    }*/

    private Pageable getPageable(ClaimPage claimPage) {
        Sort sort = Sort.by(claimPage.getSortDirection(), claimPage.getSortByRegion());
        return PageRequest.of(claimPage.getPageNumber(), claimPage.getPageSize(), sort);
    }
}
