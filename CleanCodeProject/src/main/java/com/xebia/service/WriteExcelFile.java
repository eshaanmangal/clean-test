package com.xebia.service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javax.management.InvalidAttributeValueException;
import java.io.IOException;
import java.util.HashMap;

public interface WriteExcelFile {
    public void writeExcelFile(Integer fileNumber , HashMap<String,int[] > data) throws IOException, InvalidFormatException;
}
