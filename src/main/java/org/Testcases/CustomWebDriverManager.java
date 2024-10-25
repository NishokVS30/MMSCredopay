package org.Testcases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v124.cachestorage.model.Cache;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;

//CorerctOne(10/07)

//public class CustomWebDriverManager {
//    private static WebDriver driver;
//    private static int waitTime; 
//
//    // Method to get the base URL depending on the environment
//    public static String getBaseUrl() {
//        Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
//        String environment = dotenv.get("ENVIRONMENT", "UAT");
//
//        if (environment.equalsIgnoreCase("PRODUCTION")) {
//            return dotenv.get("PRODUCTIONBASEURL");
//        } else {
//            return dotenv.get("UATBASEURL");
//        }
//    }
//
//    // Method to get the WebDriver instance based on the browser type from the .env file
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            initializeWaitTime(); // Ensure wait time is set before initializing WebDriver
//            Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
//            String browser = dotenv.get("BROWSER", "chrome").toLowerCase(); // Get browser from .env
//            String environment = dotenv.get("ENVIRONMENT", "UAT");
//
//            boolean isHeadless = environment.equalsIgnoreCase("PRODUCTION");
//
//            switch (browser) {
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    ChromeOptions chromeOptions = new ChromeOptions();
//                    if (isHeadless) {
//                        chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
//                        System.out.println("Running Chrome in headless mode for Production.");
//                    } else {
//                        System.out.println("Running Chrome in normal mode for UAT.");
//                    }
//                    driver = new ChromeDriver(chromeOptions);
//                    break;
//
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    FirefoxOptions firefoxOptions = new FirefoxOptions();
//                    if (isHeadless) {
//                        firefoxOptions.addArguments("--headless");
//                        System.out.println("Running Firefox in headless mode for Production.");
//                    } else {
//                        System.out.println("Running Firefox in normal mode for UAT.");
//                    }
//                    driver = new FirefoxDriver(firefoxOptions);
//                    break;
//
//                case "edge":
//                    WebDriverManager.edgedriver().setup();
//                    EdgeOptions edgeOptions = new EdgeOptions();
//                    if (isHeadless) {
//                        edgeOptions.addArguments("--headless");
//                        System.out.println("Running Edge in headless mode for Production.");
//                    } else {
//                        System.out.println("Running Edge in normal mode for UAT.");
//                    }
//                    driver = new EdgeDriver(edgeOptions);
//                    break;
//
//                default:
//                    throw new IllegalArgumentException("Unsupported browser: " + browser);
//            }
//
//            driver.get(getBaseUrl());
//
//            if (!isHeadless) {
//                driver.manage().window().maximize();
//            }
//        }
//        return driver;
//    }
//    
//    private static void initializeWaitTime() {
//        Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
//        waitTime = Integer.parseInt(dotenv.get("WAITTIME", "30")); // Default to 30 seconds if not set
//        System.out.println("Wait time set to: " + waitTime + " seconds");
//    }
//
//    public static int getWaitTime() {
//        return waitTime; // Getter for wait time
//    }
//
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//}

public class CustomWebDriverManager {
    private static WebDriver driver;
    private static int waitTime;
    public static String ExelPath;
    private static Dotenv dotenv;
    private static ExtentReports extent;

    // Method to get the base URL depending on the environment
    public static String getBaseUrl() {
          dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
        String environment = dotenv.get("ENVIRONMENT", "UAT");
          ExelPath = dotenv.get("EXCELFILEPATH");
        if (environment.equalsIgnoreCase("PRODUCTION")) {
            return dotenv.get("PRODUCTIONBASEURL");
        } else {
            return dotenv.get("UATBASEURL");
        }
    }

    // Method to get the WebDriver instance based on the browser type from the .env file
    public static WebDriver getDriver() {
        if (driver == null) {
            initializeWaitTime(); // Ensure wait time is set before initializing WebDriver
            Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
            String browser = dotenv.get("BROWSER", "chrome").toLowerCase(); // Get browser from .env
            String environment = dotenv.get("ENVIRONMENT", "UAT");

            boolean isHeadless = environment.equalsIgnoreCase("PRODUCTION");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (isHeadless) {
                        chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
                        System.out.println("Running Chrome in headless mode for Production.");
                    } else {
                        System.out.println("Running Chrome in normal mode for UAT.");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (isHeadless) {
                        firefoxOptions.addArguments("--headless");
                        System.out.println("Running Firefox in headless mode for Production.");
                    } else {
                        System.out.println("Running Firefox in normal mode for UAT.");
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (isHeadless) {
                        edgeOptions.addArguments("--headless");
                        System.out.println("Running Edge in headless mode for Production.");
                    } else {
                        System.out.println("Running Edge in normal mode for UAT.");
                    }
                    driver = new EdgeDriver(edgeOptions);
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            driver.get(getBaseUrl());

            if (!isHeadless) {
                driver.manage().window().maximize();
            }

            clearCache(); // Call to clear cache after driver initialization
        }
        return driver;
    }
    
    private static void initializeWaitTime() {
        Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
        waitTime = Integer.parseInt(dotenv.get("WAITTIME", "30")); // Default to 30 seconds if not set
        System.out.println("Wait time set to: " + waitTime + " seconds");
    }

    public static int getWaitTime() {
        return waitTime; // Getter for wait time
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // Method to clear browser cache
    private static void clearCache() {
        if (driver != null) {
            // Clear cookies
            driver.manage().deleteAllCookies();
            System.out.println("Cache cleared: All cookies deleted.");

            // Verify cache cleared
            verifyCacheCleared();
        }
    }

    private static void verifyCacheCleared() {
        // Check for remaining cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        if (cookies.isEmpty()) {
            System.out.println("Cookies cleared successfully.");
        } else {
            System.out.println("There are still cookies present: " + cookies.size());
        }

        // Check Local Storage
        try {
            ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
            System.out.println("Local storage cleared successfully.");
        } catch (Exception e) {
            System.out.println("Error clearing local storage: " + e.getMessage());
        }

        // Check Session Storage
        try {
            ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");
            System.out.println("Session storage cleared successfully.");
        } catch (Exception e) {
            System.out.println("Error clearing session storage: " + e.getMessage());
        }
    }
    public static  String getExcelFilePath() {
        System.out.println("ExelPathExelPathExelPathExelPathExelPathExelPathExelPathExelPath"+ExelPath);
//    	return  "SSSSSSSSSSSSSSSS";
//        
//        dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
//
    	return ExelPath;
//    	return dotenv.get("EXCELFILEPATH");
    }
    
    public static void Report() {
    	
    	 ExtentReports extentReports = ReportManager.getExtentReports();
    	 extentReports.createTest("Sample Test").info("This is a test log");

    	    // Flush the reports
    	    ReportManager.flushReports();
    }
}