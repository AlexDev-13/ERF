package com.gov.erf.controller.excel;

import com.gov.erf.models.claims.Claim;
import com.gov.erf.repository.claim.ClaimRepository;
import com.gov.erf.service.excel.ExcelServiceExport;
import com.gov.erf.service.excel.impl.DefaultExcelServiceExport;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/excel")
public class ExcelController {

    private final ClaimRepository claimRepository;


    public ExcelController(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    @GetMapping
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content Disposition";
        String headerValue = "attachment; filename=ClaimExport.xlsx";

        response.setHeader(headerKey, headerValue);

        Collection<Claim> claims = claimRepository.findAll();

        ExcelServiceExport excelServiceExport = new DefaultExcelServiceExport(claims);
        excelServiceExport.export(response);
    }

}
