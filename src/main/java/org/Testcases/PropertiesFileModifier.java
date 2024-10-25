package org.Testcases;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class PropertiesFileModifier {

    // Method to update the extent.properties file
    public static void updatePropertiesFile(String filePath) {
 
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(filePath)) {
            // Load existing properties
             properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Generate dynamic date and time for report filenames
        String dateTim = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());

        // Replace placeholders with actual date and time
        properties.setProperty("extent.reporter.spark.out", 
            properties.getProperty("extent.reporter.spark.out").replace("{yyyy_MM_dd_HH_mm_ss}", dateTim));
        properties.setProperty("extent.reporter.pdf.out", 
            properties.getProperty("extent.reporter.pdf.out").replace("{yyyy_MM_dd_HH_mm_ss}", dateTim));

        // Write the modified properties back to the file
        try (OutputStream outputStream = new FileOutputStream(filePath)) {
            properties.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}