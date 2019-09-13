package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.qa.util.TestUtil;
import com.qa.util.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public ExtentReports extent;
	public ExtentTest extentTest;
	public  static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	
	Logger log = Logger.getLogger(TestBase.class);
	
	
	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(".//Resource//com//qa//config//config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Initialization of Driver and launching of browser with proper URL 
		public static void intialization() throws IOException {
			String browserName = prop.getProperty("browser");
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
				driver = new ChromeDriver();
			}
			
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

			driver.get(prop.getProperty("url"));
		}

		@BeforeSuite
		public void setupSuite() {
			String dateName = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss").format(new Date());
			extent = new ExtentReports(System.getProperty("user.dir")+"/Reports/"
					+ "OAProject_" + dateName + ".html", true);
		}
		
		@BeforeMethod
		public void setUp() throws IOException{
			log.info("****************************************************************************************");
			 
			log.info("****************************************************************************************");
			 
			log.info("$$$$$$$$$$$$$$$$$$$$$          "+"Starting Test case"+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
			 
			log.info("*****************************************************************************************");
			intialization();
		}
		@AfterMethod
		public void tearDown(ITestResult result){
			driver.quit();
			if(result.getStatus()==ITestResult.FAILURE){
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
				
			}
			else if(result.getStatus()==ITestResult.SKIP){
				extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
			}
			else if(result.getStatus()==ITestResult.SUCCESS){
				extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
			}
			extent.endTest(extentTest); 
			extent.flush();
		}
		
}
