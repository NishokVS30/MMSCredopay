package org.Runner;

import org.junit.runner.RunWith;	

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
	
@RunWith(Cucumber.class)
@CucumberOptions(strict = true, monochrome = true, glue = "org.Testcases",
           tags = "@run",

  //           feature	s = "src/test/resources/Login.feature",
	
		

 //           features = "src/test/resources/Bankvalidation.feature",

 //            features = "src/test/resources/Aggregator.feature",

           features = "src/test/resources/SystemUser-Bank.feature",

//                features = "src/test/resources/SystemUser-MultipleBank.feature",

//        features = "src/test/resources/SystemUser-Aggregator.feature",
             
//            features = "src/test/resources/SystemUser-ISO.feature",

            		 
//		 features = "src/test/resources/Test.feature",

		plugin = { "pretty", "html:target/cucumber-report/cucumber.html",
				"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm", "json:target/cucumber-report/cucumber.json",
				"junit:target/cucumber-report/cucumber.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/cucumber-reports" })

public class MMSCredopayRunner {

}
	