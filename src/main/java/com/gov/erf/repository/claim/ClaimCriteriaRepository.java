package com.gov.erf.repository.claim;

import com.gov.erf.config.predicate.builder.ClaimPage;
import com.gov.erf.config.predicate.criteria.ClaimSearchCriteria;
import com.gov.erf.models.claims.Claim;
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

@Repository
public class ClaimCriteriaRepository {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public ClaimCriteriaRepository
            (
                    EntityManager entityManager
            ) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }


    public Page<Claim> findAllWithFilters(ClaimPage claimPage,
                                          ClaimSearchCriteria claimSearchCriteria) {
        CriteriaQuery<Claim> criteriaQuery = criteriaBuilder.createQuery(Claim.class);
        Root<Claim> claimRoot = criteriaQuery.from(Claim.class);
        Predicate predicate = getPredicate(claimSearchCriteria, claimRoot);
        criteriaQuery.where(predicate);
        setOrder(claimPage, criteriaQuery, claimRoot);

        TypedQuery<Claim> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(claimPage.getPageNumber() * claimPage.getPageSize());
        typedQuery.setMaxResults(claimPage.getPageSize());

        Pageable pageable = getPageable(claimPage);

        long claimsCount = getClaimsCount(predicate);

        return new PageImpl<>(typedQuery.getResultList(), pageable, claimsCount);
    }

    private Predicate getPredicate(ClaimSearchCriteria claimSearchCriteria,
                                   Root<Claim> claimRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if (Objects.nonNull(claimSearchCriteria.getRegion())) {
            predicates.add(
                    criteriaBuilder.equal(claimRoot.get("region"),
                            claimSearchCriteria.getRegion().getId())
            );
        }
        if (Objects.nonNull(claimSearchCriteria.getOrgan())) {
            predicates.add(
                    criteriaBuilder.equal(claimRoot.get("organ"),
                            claimSearchCriteria.getOrgan().getId())
            );
        }
        if (Objects.nonNull(claimSearchCriteria.getEconomicActivity())) {
            predicates.add(
                    criteriaBuilder.equal(claimRoot.get("economicActivity"),
                            claimSearchCriteria.getEconomicActivity().getId())
            );
        }
        if (Objects.nonNull(claimSearchCriteria.getIdentificationFactor())) {
            predicates.add(
                    criteriaBuilder.equal(claimRoot.get("identificationFactor"),
                            claimSearchCriteria.getIdentificationFactor())
            );
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void setOrder(ClaimPage claimPage,
                          CriteriaQuery<Claim> criteriaQuery,
                          Root<Claim> claimRoot) {
        if (claimPage.getSortDirection().equals(Sort.Direction.ASC)) {
            criteriaQuery.orderBy(criteriaBuilder.asc(claimRoot.get(claimPage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(claimRoot.get(claimPage.getSortBy())));
        }
    }

    private Pageable getPageable(ClaimPage claimPage) {
        Sort sort = Sort.by(claimPage.getSortDirection(), claimPage.getSortBy());
        return PageRequest.of(claimPage.getPageNumber(), claimPage.getPageSize(), sort);
    }

    private long getClaimsCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Claim> countRoot = countQuery.from(Claim.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }
}
