package com.xebia.service.impl;

import com.xebia.service.WriteExcelFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class WriteExcelFileImpl implements WriteExcelFile {

    public static final String SAMPLE_DATA_FILE_PATH = "./src/data/SampleTemplateFile.xlsx";

    @Override
    public void writeExcelFile(Integer rowNumber, HashMap<String, int[]> writableData) throws IOException, InvalidFormatException {

        File SampleTemplateData = new File(SAMPLE_DATA_FILE_PATH);
        Workbook SampleTemplateFile = WorkbookFactory.create(SampleTemplateData);
        Sheet sheet = SampleTemplateFile.getSheetAt(0);

        writableData.forEach((dataValue, cellLocation) -> {
            Row row = sheet.getRow(cellLocation[0] - 1);
            if (row == null) {
                row = sheet.createRow(cellLocation[0] - 1);
            }

            Cell cell = row.getCell(cellLocation[1] - 1);
            if (cell == null) {
                cell = row.createCell(cellLocation[1] - 1, Cell.CELL_TYPE_STRING);
            }
            cell.setCellValue(dataValue);
        });

        try {
            FileOutputStream out = new FileOutputStream(new File("OutputFile"+Integer.toString(rowNumber)+".xlsx"));
            SampleTemplateFile.write(out);
            out.close();
            System.out.println("OutputFile.xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}




