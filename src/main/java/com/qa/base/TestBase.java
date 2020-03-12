package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtentReportListener.EventListner;
import com.qa.util.TestUtil;




public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	//public  static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	
	Logger logger = Logger.getLogger(TestBase.class);
	PropertyConfigurator.configure("log4j.properties");
	  
	driver.get("http://10.67.89.41/Automation/PackAndGo_v2/index.html");
	logger.info("Opening Pack and Go application");
	
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
			else if(browserName.equals("IE")) {
				System.setProperty("webdriver.ie.driver", ".//Drivers//IEdriver.exe"); 
				driver=new InternetExplorerDriver();  
			}
			else if (browserName.equals("FF")) {
				System.setProperty("webdriver.gecko.driver",".//Drivers//geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
				
			}
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

			driver.get(prop.getProperty("url"));
		}

		@BeforeSuite
		public void setupSuite() {
			String dateName = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss").format(new Date());
			//extent = new ExtentReports(System.getProperty("user.dir")+"/Reports/"
					//+ "OAProject_" + dateName + ".html", true);
			
		}
		
		@BeforeMethod
		public void setUp() throws IOException{
			logger.info("****************************************************************************************");
			 
			logger.info("****************************************************************************************");
			 
			logger.info("$$$$$$$$$$$$$$$$$$$$$          "+"Starting Test case"+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
			 
			logger.info("*****************************************************************************************");
			intialization();
		}
		/*@AfterMethod
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
		}*/
		
		
		public  WebDriver getEventDriver(WebDriver driver,com.aventstack.extentreports.ExtentTest test) {
			EventFiringWebDriver d=new EventFiringWebDriver(driver);
			EventListner event =new  EventListner(test);
			d.register(event);
			//waitForPageLoad(driver);
			return d;
		}
		
}
