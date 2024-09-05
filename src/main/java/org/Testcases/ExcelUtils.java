package org.Testcases;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.poi.sl.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelUtils {
//    private static Workbook workbook;
//    private static org.apache.poi.ss.usermodel.Sheet sheet;
//
//    public static void setExcelFile(String excelFilePath, String sheetName) throws IOException {
//        FileInputStream fis = new FileInputStream(excelFilePath);
//        workbook = new XSSFWorkbook(fis);
//        sheet = workbook.getSheet(sheetName);
//    }
//
//    public static Map<String, String> getRowData(int rowNum) {
//        Row row = sheet.getRow(rowNum);
//        Map<String, String> data = new HashMap<>();
//        
//        for (Cell cell : row) {
//            String header = sheet.getRow(0).getCell(cell.getColumnIndex()).getStringCellValue();
//            String value = "";
//            if (cell.getCellType() == CellType.STRING) {
//                value = cell.getStringCellValue();
//            } else if (cell.getCellType() == CellType.NUMERIC) {
//                value = String.valueOf((int) cell.getNumericCellValue());
//            } else if (cell.getCellType() == CellType.BLANK) {
//                value = "";
//            }
//            data.put(header, value);
//        }
//        return data;
//    }
//
//    public static int getRowCount() {
//        return sheet.getPhysicalNumberOfRows();
//    }
//}


//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//public class ExcelUtils {
//    private static Workbook workbook;
//    private static Sheet sheet;
//
//    // Method to set the Excel file and sheet
//    public static void setExcelFile(String excelFilePath, String sheetName) throws IOException {
//        try (FileInputStream fis = new FileInputStream(excelFilePath)) {
//            workbook = new XSSFWorkbook(fis);
//            sheet = workbook.getSheet(sheetName);
//        }
//    }
//
//    // Method to get data from a specific row
//    public static Map<String, String> getRowData(int rowNum) {
//        Map<String, String> data = new HashMap<>();
//        if (sheet == null) {
//            System.out.println("Sheet is not initialized.");
//            return data; // Return empty map if the sheet is null
//        }
//        
//        Row row = sheet.getRow(rowNum);
//        if (row == null) {
//            return data; // Return empty map if the row is null
//        }
//
//        // Get header row
//        Row headerRow = sheet.getRow(0);
//        if (headerRow == null) {
//            return data; // Return empty map if header row is null
//        }
//
//        for (Cell cell : row) {
//            String header = getCellValue(headerRow.getCell(cell.getColumnIndex()));
//            String value = getCellValue(cell);
//            data.put(header, value);
//        }
//        return data;
//    }
//
//    // Helper method to get cell value as string
//    private static String getCellValue(Cell cell) {
//        if (cell == null) {
//            return "";
//        }
//        switch (cell.getCellType()) {
//            case STRING:
//                return cell.getStringCellValue();
//            case NUMERIC:
//                if (DateUtil.isCellDateFormatted(cell)) {
//                    return cell.getDateCellValue().toString();
//                } else {
//                    return String.valueOf(cell.getNumericCellValue());
//                }
//            case BOOLEAN:
//                return String.valueOf(cell.getBooleanCellValue());
//            case FORMULA:
//                return cell.getCellFormula();
//            case BLANK:
//            default:
//                return "";
//        }
//    }
//
//    // Method to get the total number of rows in the sheet
////    public static int getRowCount(String sheetName) {
////        Sheet specifiedSheet = workbook.getSheet(sheetName);
////        if (specifiedSheet != null) {
////            int lastRowNum = specifiedSheet.getLastRowNum();
////            int firstRowNum = specifiedSheet.getFirstRowNum();
////
////            // Calculate the actual number of data rows, excluding header
////            return lastRowNum > firstRowNum ? lastRowNum : 0;
////        }
////        return 0;
////    }
//
//    
////    public static int getRowCount() {
////        if (sheet != null) {
////            return sheet.getLastRowNum(); // This returns the index of the last row, so it counts all rows (including header)
////        }
////        return 0;
////    }
//    
//    public static int getRowCount(String sheetName) {
//        if (sheet != null && sheet.getSheetName().equals(sheetName)) {
//            return sheet.getLastRowNum(); // This returns the index of the last row, so it counts all rows (including header)
//        }
//        return 0;
//    }
//    
//
//
//    // Close the workbook to release resources
//    public static void close() throws IOException {
//        if (workbook != null) {
//            workbook.close();
//        }
//    }
//
//}


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtils {
    private static Workbook workbook;
    private static Sheet sheet;

    // Method to set the Excel file and sheet
    public static void setExcelFile(String excelFilePath, String sheetName) throws IOException {
        try (FileInputStream fis = new FileInputStream(excelFilePath)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        }
    }

    // Method to get data from a specific row
    public static Map<String, String> getRowData(String sheetName, int rowNum) {
        Map<String, String> data = new HashMap<>();
        if (workbook == null) {
            System.out.println("Workbook is not initialized.");
            return data; // Return empty map if the workbook is null
        }

        sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            System.out.println("Sheet not found: " + sheetName);
            return data; // Return empty map if the sheet is null
        }

        Row row = sheet.getRow(rowNum);
        if (row == null || isRowEmpty(row)) {
            return data; // Return empty map if the row is null or empty
        }

        // Get header row
        Row headerRow = sheet.getRow(0);
        if (headerRow == null) {
            return data; // Return empty map if header row is null
        }

        for (Cell cell : row) {
            String header = getCellValue(headerRow.getCell(cell.getColumnIndex()));
            String value = getCellValue(cell);
            data.put(header, value);
        }
        return data;
    }

    // Helper method to check if a row is empty
    private static boolean isRowEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    // Helper method to get cell value as string
    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
            default:
                return "";
        }
    }

    // Method to get the total number of data rows (excluding header and empty rows)
    public static int getRowCount(String sheetName) {
        if (workbook == null) {
            System.out.println("Workbook is not initialized.");
            return 0; // Return 0 if workbook is not initialized
        }

        sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            System.out.println("Sheet not found: " + sheetName);
            return 0; // Return 0 if sheet is not found
        }

        int rowCount = 0;

        // Start from the second row (index 1), assuming the first row (index 0) is the header
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null && !isRowEmpty(row)) {
                rowCount++;
            }
        }

        return rowCount;
    }

    // Close the workbook to release resources
    public static void close() throws IOException {
        if (workbook != null) {
            workbook.close();
            workbook = null;
            sheet = null;
        }
    }
}





