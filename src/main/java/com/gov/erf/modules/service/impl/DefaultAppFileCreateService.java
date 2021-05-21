package com.gov.erf.modules.service.impl;

import com.gov.erf.modules.basic.AppFileUtil;
import com.gov.erf.modules.models.AppFile;
import com.gov.erf.modules.models.request.AddAppFileRequest;
import com.gov.erf.modules.service.AppFileCreateService;
import com.gov.erf.modules.service.AppFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class DefaultAppFileCreateService implements AppFileCreateService {


    private final AppFileService appFileService;

    public DefaultAppFileCreateService(AppFileService appFileService) {
        this.appFileService = appFileService;
    }

    @Override
    public AppFile createAppFile(MultipartFile file, String path) throws Exception {

        File directory = new File(path);
        if (!directory.exists() && !directory.mkdirs()) {
            throw new Exception("Файл не может быть сохранён");
        }
        String filePath = null;
        try {
            filePath = AppFileUtil.saveFile(file, path);
        } catch (IOException exception) {
            throw new Exception("Файл не может быть сохранён");

        }

        AddAppFileRequest request = AddAppFileRequest
                .builder()
                .name(file.getOriginalFilename())
                .path(filePath)
                .build();

        return appFileService.add(request);
    }
}
