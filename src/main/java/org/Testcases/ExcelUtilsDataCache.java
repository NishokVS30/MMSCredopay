package org.Testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class ExcelUtilsDataCache {

    private static ExcelUtilsDataCache instance;
    private Map<String, List<Map<String, String>>> cachedData; // Store data for multiple sheets

    // Private constructor to implement Singleton pattern
    private ExcelUtilsDataCache() {
        cachedData = new HashMap<>(); // Initialize the map
    }

    // Get the single instance of this class
    public static ExcelUtilsDataCache getInstance() {
        if (instance == null) {
            instance = new ExcelUtilsDataCache();
        }
        return instance;
    }

    // Method to load data from Excel into the cache (only once)
    public void loadData(String excelPath) throws InvalidFormatException, IOException {
        if (cachedData.isEmpty()) {  // Check if cache is empty before loading data
            ExcelUtils utils = new ExcelUtils(); // Assuming ExcelUtils is a utility class for reading Excel data
            cachedData = utils.getAllData(excelPath); // Load all sheets at once into the cache
        }
    }

    // Retrieve cached data for a specific sheet
    public List<Map<String, String>> getCachedData(String sheetName) {
        return cachedData.get(sheetName); // Return data for the requested sheet
    }

    // Method to update cached data for a specific sheet
    public void setCachedData(String sheetName, List<Map<String, String>> data) {
        cachedData.put(sheetName, data); // Update the cache with new data for the given sheet
    }
}


