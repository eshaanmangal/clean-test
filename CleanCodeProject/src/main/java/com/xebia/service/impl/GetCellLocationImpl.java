package com.xebia.service.impl;

import com.xebia.service.GetCellLocation;

public class GetCellLocationImpl implements GetCellLocation {

    private String cellLocation;
    private final String alphabets = "abcdefghijklmnopqrstuvwxyz";
    private int rowLocation;
    private int columnLocation;
    public GetCellLocationImpl(String cellLocation) {
        this.cellLocation = cellLocation;
    }

    @Override
    public int[] getCellLocation() {
        int decimalPoint = 0;
        int alphabetPoint = 0;

        for (int i = cellLocation.length() - 1; i >= 0; i--) {
            boolean flag = Character.isDigit(cellLocation.charAt(i));
            if (flag) {
                rowLocation += (int)(Math.pow(10,decimalPoint++)*(Character.getNumericValue(cellLocation.charAt(i))));
            } else{
                columnLocation += (int)(Math.pow(26,alphabetPoint++)*( alphabets.indexOf(cellLocation.charAt(i)) + 1));
            }
        }
        return new int[]{rowLocation,columnLocation};
    }
}
