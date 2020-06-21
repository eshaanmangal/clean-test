package com.xebia.service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public interface ReadExcelFile {
    public void readExcelFile() throws IOException, InvalidFormatException, Exception;
}
