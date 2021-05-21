package com.gov.erf.modules.basic;


import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class AppFileUtil {

    public static String saveFile(MultipartFile file, String directory) throws IOException {
        LocalDateTime now = LocalDateTime.now();

        String fileName = getFileName(file) + "_" + formatDate(now) + "." + getExtension(file);

        String filePath = directory + "/" + fileName;

        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

        return filePath;
    }

    public static File getFile(String path) {
        return new File(path);
    }

    public static String getFileAsBase64(String path) throws IOException {
        File file = new File(path);
        byte[] fileContent = FileUtils.readFileToByteArray(file);

        return Base64.getEncoder().encodeToString(fileContent);
    }

    private static String getFileName(MultipartFile file) {
        String fullName = file.getOriginalFilename();

        int dot = fullName.lastIndexOf('.');

        return fullName.substring(0, dot);
    }

    private static String getExtension(MultipartFile file) {

        String fullName = file.getOriginalFilename();

        int dot = fullName.lastIndexOf('.') + 1;

        return fullName.substring(dot);
    }

    static private String formatDate(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
    }

}
