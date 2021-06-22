package com.gov.erf.service.inn.impl;

import com.gov.erf.models.inn.Inn;
import com.gov.erf.repository.inn.InnRepository;
import com.gov.erf.service.inn.InnService;
import org.springframework.stereotype.Service;

@Service
public class DefaultInnService implements InnService {

    private final InnRepository innRepository;

    public DefaultInnService(InnRepository innRepository) {
        this.innRepository = innRepository;
    }

    @Override
    public Inn getInn(String inn) throws Exception {

        if (inn.equals(null)) {
            throw new Exception("inn not exists");
        } else {
            return innRepository.findInnByTitle(inn);
        }
    }
}
