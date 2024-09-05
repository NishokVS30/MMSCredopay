package org.Testcases;

	
	import org.apache.poi.ss.usermodel.*;
	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	import java.io.File;
	import java.io.IOException;
	import java.util.*;

	public class ExcelReader {

	    public List<Map<String, String>> getData(String excelFilePath, String sheetName) throws InvalidFormatException, IOException {
	        Sheet sheet = getSheetByName(excelFilePath, sheetName);
	        return readSheet(sheet);
	    }

	    public List<Map<String, String>> getData(String excelFilePath, int sheetNumber) throws InvalidFormatException, IOException {
	        Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
	        return readSheet(sheet);
	    }

	    private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
	        return getWorkbook(excelFilePath).getSheet(sheetName);
	    }

	    private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException {
	        return getWorkbook(excelFilePath).getSheetAt(sheetNumber);
	    }

	    private Workbook getWorkbook(String excelFilePath) throws IOException, InvalidFormatException {
	        return WorkbookFactory.create(new File(excelFilePath));
	    }

	    private List<Map<String, String>> readSheet(Sheet sheet) {
	        List<Map<String, String>> data = new ArrayList<>();
	        Iterator<Row> rowIterator = sheet.iterator();

	        // Assuming the first row contains headers
	        Row headerRow = rowIterator.next();
	        List<String> headers = new ArrayList<>();
	        headerRow.forEach(cell -> headers.add(cell.getStringCellValue()));

	        while (rowIterator.hasNext()) {
	            Row row = rowIterator.next();
	            Map<String, String> rowData = new LinkedHashMap<>();

	            for (int i = 0; i < headers.size(); i++) {
	                Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	                rowData.put(headers.get(i), getCellValueAsString(cell));
	            }

	            data.add(rowData);
	        }

	        return data;
	    }

	    private String getCellValueAsString(Cell cell) {
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
	                return "";
	            default:
	                return "";
	        }
	    }
	}




