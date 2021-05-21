package com.gov.erf.modules.service.impl;

import com.gov.erf.modules.models.AppFile;
import com.gov.erf.modules.models.request.AddAppFileRequest;
import com.gov.erf.modules.repository.AppFileRepository;
import com.gov.erf.modules.service.AppFileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DefaultAppFileService implements AppFileService {


    private final AppFileRepository appFileRepository;

    public DefaultAppFileService(AppFileRepository appFileRepository) {
        this.appFileRepository = appFileRepository;
    }


    @Override
    public AppFile get(Long id) {
        return appFileRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public AppFile add(AddAppFileRequest request) {
        var file = new AppFile();
        file.setName(request.getName());
        file.setPath(request.getPath());

        return appFileRepository.save(file);
    }
}
