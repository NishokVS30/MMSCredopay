package org.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
public class CustomWebDriverManager {
    private static WebDriver driver;

    // Method to get the base URL depending on the environment
    private static String getBaseUrl() {
        Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();

    	  String environment = dotenv.get("ENVIRONMENT"); // Default to UAT if not set

          if (environment.equalsIgnoreCase("PRODUCTION")) {
             return dotenv.get("PRODUCTIONBASEURL") ;
          } else {
        	  return dotenv.get("UATBASEURL") ;
          } 
    }

    // Method to get the WebDriver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            // Setup Chrome WebDriver using WebDriverManager
            WebDriverManager.chromedriver().setup();

            // Load environment variables from .env file
//            Dotenv dotenv = Dotenv.load();
            
//            Dotenv dotenv = Dotenv.configure().load();
            Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();

            String environment = dotenv.get("ENVIRONMENT"); // Default to UAT if not set

            System.out.println("Environment variable: " + environment);

            ChromeOptions options = new ChromeOptions();
            boolean isHeadless = false;

            if (environment.equalsIgnoreCase("PRODUCTION")) {
                options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
                isHeadless = true;
                System.out.println("Running in headless mode for Production environment.");
            } else {
                System.out.println("Running in normal mode for UAT environment.");
            }

            // Initialize ChromeDriver with the appropriate options
            driver = new ChromeDriver(options);

            // Get the base URL
            driver.get(getBaseUrl());

            // Maximize the browser window if not in headless mode
            if (!isHeadless) {
                driver.manage().window().maximize();
            }
        }
        return driver;
    }

    // Method to quit the WebDriver instance
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}












//public class CustomWebDriverManager {
//    private static WebDriver driver;
//
//    // Method to get the base URL depending on the environment
//    private static String getBaseUrl() {
//        // Retrieve environment variable (default to UAT if not set)
//        String environment = System.getenv("ENVIRONMENT");
//        if (environment == null || environment.isEmpty()) {
//            environment = "UAT"; // Default to UAT
//        }
//
//        // Return the appropriate base URL based on the environment
//        switch (environment.toUpperCase()) {
//            case "PRODUCTION":
//                return "https://production.credopay.info/";
//            case "UAT":
//            default:
//                return "https://masterv3.credopay.info/"; // Your UAT URL
//        }
//    }
//
//    // Method to get the WebDriver instance
//    public static WebDriver getDriver() throws InterruptedException {
//        if (driver == null) {
//
//            // Setup Chrome WebDriver using WebDriverManager
//            WebDriverManager.chromedriver().setup();
//
//            // Retrieve environment variable
//            String environment = System.getenv("ENVIRONMENT");
//            if (environment == null || environment.isEmpty()) {
//                environment = "UAT"; // Default to UAT if environment variable is not set
//            }
//
//            // Setup ChromeOptions for headless mode in Production
//            ChromeOptions options = new ChromeOptions();
//            if (environment.equalsIgnoreCase("PRODUCTION")) {
//                // Run in headless mode for Production
//                options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
//                System.out.println("Running in headless mode for Production environment.");
//            } else {
//                // Run in normal mode for UAT
//                System.out.println("Running in normal mode for UAT environment.");
//            }
//
//            // Initialize ChromeDriver with the appropriate options
//            driver = new ChromeDriver(options);
//
//            // Get the base URL based on the environment
//            driver.get(getBaseUrl());
//
//            // Maximize the browser window
//            driver.manage().window().maximize();
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
//	private static WebDriver driver;
//
//    public static WebDriver getDriver() throws InterruptedException {
//        if (driver == null) {
//        	
//  //      	driver.manage().timeouts().wait(3000);
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            driver.get("https://masterv3.credopay.info/");
//
//    		driver.manage().window().maximize();
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
//    }
