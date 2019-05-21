package com.epic.excel_uploader.service.impl;

import com.epic.excel_uploader.repository.ExcelSaverRepo;
import com.epic.excel_uploader.service.ExcelExporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ExcelExporterServiceImpl implements ExcelExporterService {

    @Autowired
    ExcelSaverRepo excelSaverRepo;


    @Override
    public boolean excelExporterPrimeXlx(String file){
        return excelSaverRepo.excelExporterPrimeXlx(file);
    }

    @Override
    public boolean excelExporterPrimeXlxs(String path){
        return excelSaverRepo.excelExporterPrimeXlxs(path);
    }
}
