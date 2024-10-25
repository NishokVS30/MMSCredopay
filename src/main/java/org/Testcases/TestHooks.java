package org.Testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.github.javafaker.Faker;

public class TestHooks {
 
	TestHooks(){
		this.setUp();
	}
    public void setUp() {
        try {
        	CustomWebDriverManager.getBaseUrl();
            System.out.println("aaa");
            // Initialize Faker instance
            Faker faker = new Faker();

            // Retrieve the Excel file path from environment variable or custom manager
            String excelFilePath = CustomWebDriverManager.getExcelFilePath();
            System.out.println("PPPPPP"+excelFilePath);
            System.out.println("AAAAAAAAAAAAAAAAAa"+CustomWebDriverManager.ExelPath);
            String propertiesFilePath = "C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\src\\test\\resources1\\extent.properties";

            // Update properties file
            PropertiesFileModifier.updatePropertiesFile(propertiesFilePath);

            // Validate that the Excel file path is not empty
            if (excelFilePath == null || excelFilePath.isEmpty()) {
                throw new IllegalArgumentException("Excel file path is not set. Please check the environment variable.");
            }

            // Load Excel data into cache
            ExcelUtilsDataCache cache = ExcelUtilsDataCache.getInstance();
            cache.loadData(excelFilePath);
        } catch (IOException | InvalidFormatException e) {
            System.err.println("Error during setup: " + e.getMessage());
        }
    }
}
