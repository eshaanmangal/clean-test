package com.xebia.service.impl;

import com.xebia.model.CellLocation;
import com.xebia.service.GetCellLocation;
import com.xebia.service.GetMappingFromJSON;
import com.xebia.service.ReadExcelFile;
import com.xebia.service.WriteExcelFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class ReadExcelFileImpl implements ReadExcelFile {

    public static final String SAMPLE_DATA_FILE_PATH = "./src/data/SampleData.xlsx";

    @Override
    public void readExcelFile() throws Exception, IOException, InvalidFormatException {

        File SampleData = new File(SAMPLE_DATA_FILE_PATH);
        Workbook SampleDataFile = WorkbookFactory.create(SampleData);

        GetMappingFromJSON getMappingFromJSON = new GetMappingFromJSONImpl();
        HashMap<String,String> mappingLocation = getMappingFromJSON.getMapping();

        for(int sheetNumber=0; sheetNumber<SampleDataFile.getNumberOfSheets(); sheetNumber++){
            Sheet sheet = SampleDataFile.getSheetAt(sheetNumber);
            Row columnHeader = sheet.getRow(0);
            for(int rowNumber=1;rowNumber<=sheet.getLastRowNum();rowNumber++){
                Row rowData = sheet.getRow(rowNumber);
                HashMap <String, int[] > writableData = new HashMap<>();

                for(int cellNumber=0;cellNumber<rowData.getLastCellNum();cellNumber++){
                    GetCellLocation cellLocation = new GetCellLocationImpl(mappingLocation.get(((columnHeader.getCell(cellNumber)).toString()).toLowerCase()));
                    writableData.put((rowData.getCell(cellNumber)).toString(), cellLocation.getCellLocation());
                }
                WriteExcelFile writeExcelFile = new WriteExcelFileImpl();
                writeExcelFile.writeExcelFile(rowNumber,writableData);
                //printingMap(writableData);
            }
        }
    }

    private void printingMap(HashMap<String, int[]> writableData) {
        writableData.forEach((key,value)->{
            System.out.println(key + "->" +value[0]+","+value[1]);
        });
    }
}
