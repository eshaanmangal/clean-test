package com.xebia.application;

import com.xebia.service.GetMappingFromJSON;
import com.xebia.service.ReadExcelFile;
import com.xebia.service.impl.GetMappingFromJSONImpl;
import com.xebia.service.impl.ReadExcelFileImpl;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.HashMap;

public class EntryPoint {
    public static void main(String[] args) throws Exception, IOException, InvalidFormatException {
        ReadExcelFile readExcelFile = new ReadExcelFileImpl();
        readExcelFile.readExcelFile();
    }
}
