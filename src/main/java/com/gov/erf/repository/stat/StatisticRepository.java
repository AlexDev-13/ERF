package com.gov.erf.repository.stat;

import com.gov.erf.config.predicate.builder.ClaimPage;
import com.gov.erf.config.predicate.criteria.ClaimSearchCriteria;
import com.gov.erf.config.predicate.criteria.ClaimStatCriteria;
import com.gov.erf.dto.http.statistic.StatisticDto;
import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.status.Status;
import com.gov.erf.models.status.StatusType;
import com.gov.erf.service.status.StatusService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class StatisticRepository {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;
    private final StatusService statusService;

    public StatisticRepository
            (
                    EntityManager entityManager,
                    StatusService statusService
            ) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
        this.statusService = statusService;
    }


    public StatisticDto findAllWithFilters(ClaimStatCriteria claimStatCriteria) {
        CriteriaQuery<Claim> criteriaQuery = criteriaBuilder.createQuery(Claim.class);
        Root<Claim> claimRoot = criteriaQuery.from(Claim.class);
        Predicate predicate = getPredicate(claimStatCriteria, claimRoot);
        criteriaQuery.where(predicate);

        TypedQuery<Claim> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Claim> claims = typedQuery.getResultList();

        var stat = new StatisticDto();

        var count = claims.stream().count();

        stat.setReady((claims.stream().filter(claim -> claim.getStatus().getType().equals(StatusType.APPROVED)).count()*100)/count);
        stat.setUnderConsideration((claims.stream().filter(claim -> claim.getStatus().getType().equals(StatusType.UNDER_CONSIDERATION)).count()*100)/count);
        stat.setInProcessing((claims.stream().filter(claim -> claim.getStatus().getType().equals(StatusType.IN_PROCESSING)).count()*100)/count);
        stat.setRenouncement((claims.stream().filter(claim -> claim.getStatus().getType().equals(StatusType.DENIED)).count()*100)/count);

        return stat;
    }

    private Predicate getPredicate(ClaimStatCriteria claimStatCriteria,
                                   Root<Claim> claimRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if (Objects.nonNull(claimStatCriteria.getRegion())) {
            predicates.add(
                    criteriaBuilder.equal(claimRoot.get("region"),
                            claimStatCriteria.getRegion().getId())
            );
        }

        if (Objects.nonNull(claimStatCriteria.getEconomicActivity())) {
            predicates.add(
                    criteriaBuilder.equal(claimRoot.get("economicActivity"),
                            claimStatCriteria.getEconomicActivity().getId())
            );
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
    }

    private void setOrder(ClaimPage claimPage,
                          CriteriaQuery<Claim> criteriaQuery,
                          Root<Claim> claimRoot) {
        if (claimPage.getSortDirection().equals(Sort.Direction.ASC)) {
            criteriaQuery.orderBy(criteriaBuilder.asc(claimRoot.get(claimPage.getSortByRegion())));
            criteriaQuery.orderBy(criteriaBuilder.asc(claimRoot.get(claimPage.getSortByCompanyName())));
            criteriaQuery.orderBy(criteriaBuilder.asc(claimRoot.get(claimPage.getSortByOrgan())));

        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(claimRoot.get(claimPage.getSortByOrgan())));
            criteriaQuery.orderBy(criteriaBuilder.desc(claimRoot.get(claimPage.getSortByRegion())));
            criteriaQuery.orderBy(criteriaBuilder.desc(claimRoot.get(claimPage.getSortByCompanyName())));

        }
    }

    private Pageable getPageable(ClaimPage claimPage) {
        Sort sort = Sort.by(claimPage.getSortDirection(), claimPage.getSortByRegion());
        return PageRequest.of(claimPage.getPageNumber(), claimPage.getPageSize(), sort);
    }

    private long getClaimsCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Claim> countRoot = countQuery.from(Claim.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }
}

