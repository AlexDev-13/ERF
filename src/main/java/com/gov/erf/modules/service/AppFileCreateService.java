package com.gov.erf.modules.service;

import com.gov.erf.modules.models.AppFile;
import org.springframework.web.multipart.MultipartFile;

public interface AppFileCreateService {
    AppFile createAppFile(MultipartFile file, String path) throws Exception;
}
