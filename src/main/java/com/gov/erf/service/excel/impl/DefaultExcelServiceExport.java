package com.gov.erf.service.excel.impl;

import com.gov.erf.models.claims.Claim;
import com.gov.erf.repository.claim.ClaimRepository;
import com.gov.erf.service.excel.ExcelServiceExport;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class DefaultExcelServiceExport implements ExcelServiceExport {

    private final ClaimRepository claimRepository;

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"Id", "Title", "Description", "Factor"};
    static String SHEET = "claims";

    public DefaultExcelServiceExport(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    public static ByteArrayInputStream claimsToExcel(List<Claim> claims) {

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            // Header
            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            int rowIdx = 1;
            for (Claim claim : claims) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(claim.getId());
                row.createCell(1).setCellValue(claim.getCompanyName());
                row.createCell(2).setCellValue(claim.getProblemOfDescription());
                row.createCell(3).setCellValue(claim.getIdentificationFactor());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }

    @Override
    public ByteArrayInputStream load() {
        List<Claim> claims = claimRepository.findAll();

        ByteArrayInputStream in = claimsToExcel(claims);
        return in;
    }

}
