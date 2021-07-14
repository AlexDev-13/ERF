package com.gov.erf.repository.claim;

import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.models.claims.QClaim;
import com.gov.erf.models.claims.Region;
import com.gov.erf.models.status.Status;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long>, QuerydslPredicateExecutor<Claim>, QuerydslBinderCustomizer<QClaim> {

    Page<Claim> findAll(Pageable pageable);

    Page<Claim> findClaimsByRegion(Pageable pageable, Region region);

    Collection<Claim> findAllByRegion(Region region);

    Collection<Claim> findAllByEconomicActivity(EconomicActivity economicActivity);

    Collection<Claim> findAllByStatus(Status status);

    Collection<Claim> findAllByStatusAndRegion(Status status, Region region);

    Collection<Claim> findAllByStatusAndEconomicActivity(Status status, EconomicActivity economicActivity);

    @Override
    default void customize(
            QuerydslBindings bindings, QClaim root) {
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
        bindings.excluding(root.region);
    }
}
