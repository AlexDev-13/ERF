package com.gov.erf.service.claim.impl;

import com.gov.erf.models.claims.Region;
import com.gov.erf.repository.claim.RegionRepository;
import com.gov.erf.service.claim.RegionService;
import org.springframework.stereotype.Service;

@Service
public class DefaultRegionService implements RegionService {

    private final RegionRepository regionRepository;

    public DefaultRegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public Region get(Long id) {
        return regionRepository.findById(id).orElseThrow();
    }
}
