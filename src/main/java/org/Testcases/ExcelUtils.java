package org.Testcases;
//
//
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
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
//    public static Map<String, String> getRowData(String sheetName, int rowNum) {
//        Map<String, String> data = new HashMap<>();
//        if (workbook == null) {
//            System.out.println("Workbook is not initialized.");
//            return data; // Return empty map if the workbook is null
//        }
//
//        sheet = workbook.getSheet(sheetName);
//        if (sheet == null) {
//            System.out.println("Sheet not found: " + sheetName);
//            return data; // Return empty map if the sheet is null
//        }
//
//        Row row = sheet.getRow(rowNum);
//        if (row == null || isRowEmpty(row)) {
//            return data; // Return empty map if the row is null or empty
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
//    // Helper method to check if a row is empty
//    private static boolean isRowEmpty(Row row) {
//        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
//            Cell cell = row.getCell(c);
//            if (cell != null && cell.getCellType() != CellType.BLANK) {
//                return false;
//            }
//        }
//        return true;
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
//    // Method to get the total number of data rows (excluding header and empty rows)
//    public static int getRowCount(String sheetName) {
//        if (workbook == null) {
//            System.out.println("Workbook is not initialized.");
//            return 0; // Return 0 if workbook is not initialized
//        }
//
//        sheet = workbook.getSheet(sheetName);
//        if (sheet == null) {
//            System.out.println("Sheet not found: " + sheetName);
//            return 0; // Return 0 if sheet is not found
//        }
//
//        int rowCount = 0;
//
//        // Start from the second row (index 1), assuming the first row (index 0) is the header
//        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//            Row row = sheet.getRow(i);
//            if (row != null && !isRowEmpty(row)) {
//                rowCount++;
//            }
//        }
//
//        return rowCount;
//    }
//
//    // Close the workbook to release resources
//    public static void close() throws IOException {
//        if (workbook != null) {
//            workbook.close();
//            workbook = null;
//            sheet = null;
//        }
//    }
//}

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {
    private Workbook workbook;

    // Method to load the Excel file
    public void setExcelFile(String excelFilePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(excelFilePath)) {
            workbook = new XSSFWorkbook(fis);
        }
    }

    // Method to retrieve all data from all sheets
    public Map<String, List<Map<String, String>>> getAllData(String excelFilePath) throws IOException {
        setExcelFile(excelFilePath);
        Map<String, List<Map<String, String>>> allData = new HashMap<>();

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            String sheetName = sheet.getSheetName();
            List<Map<String, String>> sheetData = new ArrayList<>();

            // Get header row
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) continue; // Skip empty sheets

            for (int j = 1; j <= sheet.getLastRowNum(); j++) { // Start from 1 to skip header
                Row row = sheet.getRow(j);
                if (row == null || isRowEmpty(row)) continue; // Skip empty rows
                Map<String, String> rowData = new HashMap<>();

                for (int k = 0; k < headerRow.getPhysicalNumberOfCells(); k++) {
                    Cell cell = row.getCell(k);
                    String header = headerRow.getCell(k).getStringCellValue();
                    String value = getCellValue(cell);
                    rowData.put(header, value);
                }
                sheetData.add(rowData);
            }
            allData.put(sheetName, sheetData);
        }

        return allData;
    }

    // Helper method to check if a row is empty
    private boolean isRowEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    // Helper method to get cell value as string
    private String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return cell.getNumericCellValue() % 1 == 0 ? String.valueOf((int) cell.getNumericCellValue()) : String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
            default:
                return "";
        }
    }

    // Close the workbook to release resources
    public void close() throws IOException {
        if (workbook != null) {
            workbook.close();
            workbook = null;
        }
    }
}

