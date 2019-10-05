package com.qa.ExtentReportListener;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class EventListner implements WebDriverEventListener{

   ExtentTest test;
	
	public EventListner(ExtentTest test)
	{
		this.test=test;
	}
   
	
	public void beforeNavigateTo(String url, WebDriver driver)
	{
	}
	/**
	 * @description:Logs each navigation of AUT into extent report.
	 * 
	 * @param url
	 * @param WebDriver
	 * 
	 */
	
	public void afterNavigateTo(String url, WebDriver arg)
	{
		test.log(Status.INFO, "afterClickOn() " +arg.getTitle());

		//System.out.println("navigated to " + url + " page title : " + arg.getTitle());
	}
	
	public void beforeNavigateBack(WebDriver driver)
	{
		// TODO Auto-generated method stub
	}
	
	public void afterNavigateBack(WebDriver driver)
	{
		// TODO Auto-generated method stub
	}
	
	public void beforeNavigateForward(WebDriver driver)
	{
		// TODO Auto-generated method stub
	}
	
	public void afterNavigateForward(WebDriver driver)
	{
		// TODO Auto-generated method stub
	}
	/*
	public void beforeNavigateRefresh(WebDriver driver)
	{
		// TODO Auto-generated method stub
	}
	
	public void afterNavigateRefresh(WebDriver driver)
	{
		// TODO Auto-generated method stub
	}*/
	
	public void beforeFindBy(By by, WebElement element, WebDriver driver)
	{
		// test.log(LogStatus.INFO, "beforeFindBy() ", by.toString());
	}
	
	public void afterFindBy(By by, WebElement element, WebDriver driver)
	{
		// test.log(LogStatus.INFO, "element found with ", by.toString());
	}
	
	public void beforeClickOn(WebElement element, WebDriver driver)
	{
		// test.log(LogStatus.INFO, "beforeClickOn()",
		// "before click on locator - [" + element.toString().split("-> ",
		// 2)[1]);
	}
	/**
	 * @description:Logs each click of AUT into extent report.
	 * 
	 * @param WebElement
	 * @param WebDriver
	 * 
	 */
	
	public void afterClickOn(WebElement element, WebDriver driver)
	{
		try
		{
			String html=element.getAttribute("outerHTML");
			test.log(Status.INFO, "afterClickOn() " +html);

			
			
		} catch (StaleElementReferenceException e)
		{

			
			test.log(Status.INFO, "afterClickOn() "+element.toString());
			//System.out.println("ignoring staleElement Exception");
			//System.out.println("afterClickOn " + element);
		}
	}
	
	public void beforeScript(String script, WebDriver driver)
	{
		// TODO Auto-generated method stub
	}
	
	public void afterScript(String script, WebDriver driver)
	{
		// TODO Auto-generated method stub
	}
	
	public void onException(Throwable throwable, WebDriver driver)
	{
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * beforeChangeValueOf(org.openqa.selenium.WebElement,
	 * org.openqa.selenium.WebDriver)
	 */
	public void beforeChangeValueOf(WebElement element, WebDriver driver)
	{
		// TODO Auto-generated method stub
	}
	/**
	 * @description:Logs each change value of AUT into extent report.
	 * 
	 * @param WebElement
	 * @param WebDriver
	 * 
	 */
	public void afterChangeValueOf(WebElement element, WebDriver driver)
	{
		try
		{
			if(element.getAttribute("type").contains("password"))
			{
				 test.log(Status.INFO, "afterChangeValueOf()"+ element.toString().split("-> ", 2)[1] + " value - ********" );
				
				
			}
			else
			{
		 test.log(Status.INFO, "afterChangeValueOf()"+ element.toString().split("-> ", 2)[1] + " value - " + element.getAttribute("value"));
		//System.out.println("after send keys locator - [" + element.toString().split("-> ", 2)[1] + " value - "
				//+ element.getAttribute("value"));
		
			}
		}
		catch(StaleElementReferenceException e)
		{
			test.log(Status.INFO, "afterChangeValueOf()"+ element.toString().split("-> ", 2)[1] );
			//System.out.println("after send keys locator - [" + element.toString().split("-> ", 2)[1] );
		}
	}


	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}


	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}


	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}


	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}


	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
