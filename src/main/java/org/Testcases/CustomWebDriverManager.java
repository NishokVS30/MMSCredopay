package org.Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
//public class CustomWebDriverManager {
//    private static WebDriver driver;
//
//    // Method to get the base URL depending on the environment
//    private static String getBaseUrl() {
//        Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
//
//    	  String environment = dotenv.get("ENVIRONMENT"); // Default to UAT if not set
//
//          if (environment.equalsIgnoreCase("PRODUCTION")) {
//             return dotenv.get("PRODUCTIONBASEURL") ;
//          }else {
//        	  return dotenv.get("UATBASEURL") ;
//          } 
//    }
//
//    // Method to get the WebDriver instance
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            // Setup Chrome WebDriver using WebDriverManager
//            WebDriverManager.chromedriver().setup();
//
//            // Load environment variables from .env file
////            Dotenv dotenv = Dotenv.load();
//            
////            Dotenv dotenv = Dotenv.configure().load();
//            Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
//
//            String environment = dotenv.get("ENVIRONMENT"); // Default to UAT if not set
//
//            System.out.println("Environment variable: " + environment);
//
//            ChromeOptions options = new ChromeOptions();
//            boolean isHeadless = false;
//
//            if (environment.equalsIgnoreCase("PRODUCTION")) {
//                options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
//                isHeadless = true;
//                System.out.println("Running in headless mode for Production environment.");
//            } else {
//                System.out.println("Running in normal mode for UAT environment.");
//            }
//
//            // Initialize ChromeDriver with the appropriate options
//            driver = new ChromeDriver(options);
//
//            // Get the base URL
//            driver.get(getBaseUrl());
//
//            // Maximize the browser window if not in headless mode
//            if (!isHeadless) {
//                driver.manage().window().maximize();
//            }
//        }
//        return driver;
//    }
//
//    // Method to quit the WebDriver instance
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//}


//public class CustomWebDriverManager {
//    private static WebDriver driver;
//
//    // Method to get the base URL depending on the environment
//    public static String getBaseUrl() {  // Changed to public
//        Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
//
//        String environment = dotenv.get("ENVIRONMENT"); // Default to UAT if not set
//
//        if (environment.equalsIgnoreCase("PRODUCTION")) {
//            return dotenv.get("PRODUCTIONBASEURL");
//        } else {
//            return dotenv.get("UATBASEURL");
//        }
//    }
//
//    // Method to get the WebDriver instance
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            // Setup Chrome WebDriver using WebDriverManager
//            WebDriverManager.chromedriver().setup();
//
//            // Load environment variables from .env file
//            Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
//
//            String environment = dotenv.get("ENVIRONMENT"); // Default to UAT if not set
//
//            System.out.println("Environment variable: " + environment);
//
//            ChromeOptions options = new ChromeOptions();
//            boolean isHeadless = false;
//
//            if (environment.equalsIgnoreCase("PRODUCTION")) {
//                options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
//                isHeadless = true;
//                System.out.println("Running in headless mode for Production environment.");
//            } else {
//                System.out.println("Running in normal mode for UAT environment.");
//            }
//
//            // Initialize ChromeDriver with the appropriate options
//            driver = new ChromeDriver(options);
//
//            // Get the base URL
//            driver.get(getBaseUrl());
//
//            // Maximize the browser window if not in headless mode
//            if (!isHeadless) {
//                driver.manage().window().maximize();
//            }
//        }
//        return driver;
//    }
//
//    // Method to quit the WebDriver instance
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//}



//LastOne

//public class CustomWebDriverManager {
//    private static WebDriver driver;
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
//    // Method to get the WebDriver instance
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
//            String environment = dotenv.get("ENVIRONMENT", "UAT");
//
//            boolean isHeadless = false;
//
//            if (environment.equalsIgnoreCase("PRODUCTION")) {
//                options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
//                System.out.println("Running in headless mode for Production.");
//                isHeadless = true;
//            } else {
//                System.out.println("Running in normal mode for UAT.");
//            }
//
//            driver = new ChromeDriver(options);
//            driver.get(getBaseUrl());
//
//            if (!isHeadless) {
//                driver.manage().window().maximize();
//            }
//        }
//        return driver;
//    }
//
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//}



//CorerctOne(10/07)

public class CustomWebDriverManager {
    private static WebDriver driver;
    private static int waitTime; 

    // Method to get the base URL depending on the environment
    public static String getBaseUrl() {
        Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
        String environment = dotenv.get("ENVIRONMENT", "UAT");

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
}


