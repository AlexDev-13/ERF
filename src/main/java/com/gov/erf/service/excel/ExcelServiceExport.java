package com.gov.erf.service.excel;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ExcelServiceExport {

    void export(HttpServletResponse response) throws IOException;
    void createCell(Row row, int columnCount, Object value, CellStyle style);
}
