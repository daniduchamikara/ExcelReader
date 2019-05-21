package com.epic.excel_uploader.repository;

import org.springframework.web.multipart.MultipartFile;

public interface ExcelSaverRepo {

    public boolean excelExporterPrimeXlx(String file);
    public boolean excelExporterPrimeXlxs(String file);
}
