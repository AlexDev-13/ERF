package com.gov.erf.modules.service;


import com.gov.erf.modules.models.AppFile;
import com.gov.erf.modules.models.request.AddAppFileRequest;

public interface AppFileService {
    AppFile get(Long id);

    AppFile add(AddAppFileRequest request);
}