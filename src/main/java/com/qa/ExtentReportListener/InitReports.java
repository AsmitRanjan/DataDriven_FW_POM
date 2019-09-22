package com.qa.ExtentReportListener;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.qa.util.MYExtentReport;


public class InitReports extends TestListenerAdapter{
	/**
	 * @description: Calling initialization of extent reports.
	 * 
	 * @throws Exception
	 */
	public InitReports() throws IOException
	{
		MYExtentReport extentReports=new MYExtentReport(); // Initialization of -Extent reports and ATU Reports
		extentReports.initExtentReports();
		
	}
	protected static Logger logger = Logger.getLogger(InitReports.class);
	static File directory;
	@Override
	public void onTestStart(ITestResult testResult)
	{
		// TODO Auto-generated method stub
		logger.info("Test '" + testResult.getName() + "' STARTED\n");
	}
	@Override
	public void onFinish(ITestContext context)
	{
		logger.info("All Tests were Finished.........\n\n");
	}
	@Override
	public void onTestSuccess(ITestResult testResult)
	{
		// TODO Auto-generated method stub
		logger.info("Test '" + testResult.getName() + "' PASSED");
		logger.info("test ID:" + testResult.getMethod().getDescription() + "\n\n");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
	{
		// TODO Auto-generated method stub
	}
	@Override
	public void onTestFailure(ITestResult testResult)
	{
		logger.info("Test '" + testResult.getName() + "' FAILED");
		logger.info("test ID:" + testResult.getMethod().getDescription() + "\n\n");
		
	}
	@Override
	public void onTestSkipped(ITestResult arg0)
	{
		// TODO Auto-generated method stub
		// Utils.getDriver().manage().deleteAllCookies() ;
	}
	

}
