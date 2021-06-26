package com.gov.erf.repository.claim;

import com.gov.erf.models.claims.Claim;
import com.gov.erf.models.claims.QClaim;
import com.gov.erf.models.claims.Region;
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

    Collection<Claim> findAllByRegion(Region region);

    @Override
    default void customize(
            QuerydslBindings bindings, QClaim root) {
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
        bindings.excluding(root.region);
    }
}
