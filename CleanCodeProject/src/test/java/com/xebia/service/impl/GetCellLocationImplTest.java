package com.xebia.service.impl;

import com.xebia.model.CellLocation;
import com.xebia.service.GetCellLocation;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetCellLocationImplTest {

    @Test
    void getCellLocation() {
        GetCellLocation getCellLocation = new GetCellLocationImpl("b1");
        int[] testLocation = getCellLocation.getCellLocation();
        int[] expected = {1,2};
        assertArrayEquals(expected,testLocation);
    }
}