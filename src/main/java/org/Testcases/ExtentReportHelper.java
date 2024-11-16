package org.Testcases;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.Status;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportHelper {

    private String currentTestCaseUuid;
    private String currentTestSuiteUuid;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static ExtentReports extentReports;

    // Starts a new test case in Extent Reports
    public void startNewTestCase(String testName, boolean isSuccess) {
        currentTestCaseUuid = UUID.randomUUID().toString();
        ExtentTest extentTest = getExtentReports().createTest(testName);
        test.set(extentTest);

        // Set the status of the test
        extentTest.log(isSuccess ? Status.PASS : Status.FAIL, "Test started");

        // Log the test case name and status
        extentTest.info("Test Case UUID: " + currentTestCaseUuid);
    }

    // Ends the current test case in Extent Reports
    public void endTestCase(boolean isSuccess) {
        if (currentTestCaseUuid != null) {
            ExtentTest extentTest = test.get();
            extentTest.log(isSuccess ? Status.PASS : Status.FAIL, "Test case " + (isSuccess ? "passed" : "failed"));
            extentTest.info("Ending Test Case: " + currentTestCaseUuid);
            test.get().getModel().setStatus(isSuccess ? Status.PASS : Status.FAIL);
        }
    }

    // Starts a new test suite for each row
    public void startNewTestSuite(int rowNumber) {
        currentTestSuiteUuid = UUID.randomUUID().toString();
        ExtentTest suiteTest = getExtentReports().createTest("Test Suite for Row " + rowNumber);
        test.set(suiteTest);
        suiteTest.log(Status.INFO, "Test Suite Started for Row " + rowNumber);
    }

    // Ends the current test suite
    public void endTestSuite() {
        if (currentTestSuiteUuid != null) {
            ExtentTest suiteTest = test.get();
            suiteTest.log(Status.INFO, "Ending Test Suite");
            test.remove();  // Remove thread-local after suite ends
        }
    }

    // Logs input data as an HTML table in Extent Reports
    public void logInputData(List<String> keys, List<String> values) {
        // Ensure keys and values have the same size
        int maxColumns = Math.min(keys.size(), values.size());

        // Adjust lists to the smaller size to avoid ArrayIndexOutOfBoundsException
        List<String> adjustedKeys = keys.subList(0, maxColumns);
        List<String> adjustedValues = values.subList(0, maxColumns);

        StringBuilder tableBuilder = new StringBuilder();
        tableBuilder.append("<table style='color: black; border: 1px solid black; border-collapse: collapse;'>");

        // Add headers
        tableBuilder.append("<tr>");
        for (String key : adjustedKeys) {
            tableBuilder.append("<th style='border: 1px solid black;'>").append(key).append("</th>");
        }
        tableBuilder.append("</tr>");

        // Add values
        tableBuilder.append("<tr>");
        for (String value : adjustedValues) {
            tableBuilder.append("<td style='border: 1px solid black;'>").append(value).append("</td>");
        }
        tableBuilder.append("</tr>");
        tableBuilder.append("</table>");

        // Attach table to Extent Reports
        ExtentTest extentTest = test.get();
        extentTest.info("Input Data: ");
        extentTest.info(tableBuilder.toString());
    }

    // Logs an error message in Extent Reports
    public void logErrorInExtent(String errorMessage) {
        ExtentTest extentTest = test.get();
        extentTest.log(Status.FAIL, "Error encountered: " + errorMessage);
    }

    // Get ExtentReports instance
    private static ExtentReports getExtentReports() {
        if (extentReports == null) {
            extentReports = new ExtentReports();

            String dateTim = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
            com.aventstack.extentreports.reporter.ExtentSparkReporter sparkReporter = new com.aventstack.extentreports.reporter.ExtentSparkReporter("test-output/SparkReport/MMSREPORT_" + dateTim + ".html");
            sparkReporter.config().setTheme(Theme.STANDARD);
            extentReports.attachReporter(sparkReporter);
        }
        return extentReports;
    }
}
