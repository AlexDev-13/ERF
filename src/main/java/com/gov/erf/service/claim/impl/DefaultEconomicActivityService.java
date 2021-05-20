package com.gov.erf.service.claim.impl;

import com.gov.erf.models.claims.EconomicActivity;
import com.gov.erf.repository.claim.EconomicActivityRepository;
import com.gov.erf.service.claim.EconomicActivityService;
import org.springframework.stereotype.Service;

@Service
public class DefaultEconomicActivityService implements EconomicActivityService {

    private final EconomicActivityRepository economicActivityRepository;

    public DefaultEconomicActivityService(EconomicActivityRepository economicActivityRepository) {
        this.economicActivityRepository = economicActivityRepository;
    }

    @Override
    public EconomicActivity get(Long id) {

        return economicActivityRepository.findById(id).orElseThrow();
    }
}
