package com.epic.excel_uploader.repository.impl;

import com.epic.excel_uploader.entities.DataSheet;
import com.epic.excel_uploader.repository.AbstractDao;
import com.epic.excel_uploader.repository.ExcelSaverRepo;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




@Transactional
@Repository


public class ExcelSaverRepoImpl extends AbstractDao<Integer, DataSheet> implements ExcelSaverRepo {
    @Autowired
    private SessionFactory sessionFactory;


    public boolean excelExporterPrimeXlx(String pathToExcel) {
        try {
            Workbook workbook = WorkbookFactory.create(new FileInputStream(pathToExcel));
            // If you have only one sheet you can get it by index of the sheet
            //Sheet sheet = workbook.getSheetAt(0);
            Iterator<Sheet> sheetItr = workbook.sheetIterator();
            while(sheetItr.hasNext()) {
                Sheet sheet = sheetItr.next();
                // For Users sheet create List of objects
                    readExcelSheet(sheet);
            }

        } catch (EncryptedDocumentException | IOException | ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean excelExporterPrimeXlxs(String file) {
        return false;
    }


    private void readExcelSheet(Sheet sheet) throws ParseException {
        Iterator<Row> rowItr = sheet.iterator();
        List<DataSheet> dataList = new ArrayList<>();
        // Iterate each row in the sheet
        while (rowItr.hasNext()) {
            DataSheet dataSheet = new DataSheet();
            Row row = rowItr.next();
            // First row is header so skip it
            if (row.getRowNum() == 0) {
                continue;
            }
            Iterator<Cell> cellItr = row.cellIterator();
            // Iterate each cell in a row
            while (cellItr.hasNext()) {

                Cell cell = cellItr.next();
                int index = cell.getColumnIndex();
                switch (index) {
                    case 0:
                        dataSheet.setId((Double) getValueFromCell(cell));
                        break;
                    case 1:
                        dataSheet.setName((String) getValueFromCell(cell));
                        break;
                    case 2:
                        dataSheet.setRegion((String) getValueFromCell(cell));
                        break;
                }
            }
            dataList.add(dataSheet);
            if(dataSheet.getId()!=null){
            saveOrUpdate(dataSheet);}
        }
//        for (DataSheet data : dataList) {
//            System.out.println(data.getId() + ": ID   " + data.getName() + ": Name   " + data.getRegion()+":Region     ::::PRINT EXCELL");
//        }

    }

    // Method to get cell value based on cell type
    private Object getValueFromCell(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                }
                return cell.getNumericCellValue();
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }

    // This method is used to print cell values
    private void printExcelSheet(Sheet sheet) throws ParseException {
        System.out.println("Starting to read sheet- " + sheet.getSheetName());
        Iterator<Row> rowItr = sheet.iterator();
        while (rowItr.hasNext()) {
            Row row = rowItr.next();
            if (row.getRowNum() == 0) {
                continue;
            }
            Iterator<Cell> cellItr = row.cellIterator();
            while (cellItr.hasNext()) {
                Cell cell = cellItr.next();
//                System.out.println("Cell Type- " + cell.getCellType().toString() + " Value- " + getValueFromCell(cell));
            }
        }
    }
}

