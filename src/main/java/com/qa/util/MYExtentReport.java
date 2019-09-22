package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class MYExtentReport {
	public static String  timeStampFrJsp;
	public static ExtentReports reports;
	public static String timeStamp ;
	static Locale locale = Locale.getDefault();
	static TimeZone tz = TimeZone.getDefault();
	static Calendar cal = Calendar.getInstance(tz, locale);
	static Date d = new Date(System.currentTimeMillis());
	
	
	
	public static void setPlatformDetails(String browserType, String platform, String version, String url,String sauceOrNode)
			throws IOException
	{
	reports.setSystemInfo("User", System.getProperty("user.name"));
		reports.setSystemInfo("Browser", browserType);
		reports.setSystemInfo("Browser Version", version);
		 reports.setSystemInfo("platform", platform.toString());
		reports.setSystemInfo("URL", url);
		
	}
	
	public void initExtentReports()
	{
		try
		{
		Properties props = new Properties();

	String reportLoc="/src/main/WebContent/extentReport";

			ClassLoader loader = this.getClass().getClassLoader();
			 InputStream input = loader.getResourceAsStream("config/testdata.properties");
			props.load(input);
			String dir_path;	
			dir_path = props.getProperty("userdir");
			System.out.println("dir path in extent reports init "+dir_path);
        	String environment = props.getProperty("Environment");
			String browser = props.getProperty("browser");
			
			LocalDate.now();
			Locale locale = Locale.getDefault();
			TimeZone tz = TimeZone.getDefault();
			Calendar cal = Calendar.getInstance(tz, locale);
			Date d = new Date(System.currentTimeMillis());
			cal.setTime(d);
			int m = cal.get(Calendar.MONTH) + 1;
			int h = cal.get(Calendar.HOUR);
			int mm = cal.get(Calendar.MINUTE);
			int s = cal.get(Calendar.SECOND);
			 timeStamp = cal.get(Calendar.DAY_OF_MONTH) + "_" + m + "_" + cal.get(Calendar.YEAR) + "_" + h + "hh_"
					+ mm + "mm_" + s + "ss";
			 
		File f = new File(dir_path + reportLoc);
		if (!f.exists())
		{			f.mkdir();
		}
		String reportFilePath;
		
		f = new File(dir_path + reportLoc+"/" + timeStamp + ".html");
		f.createNewFile();
		reportFilePath = dir_path + reportLoc+"/" + timeStamp + ".html";
			
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFilePath);
		reports = new ExtentReports() ;
		reports.attachReporter(htmlReporter);
		try
		{
			String env=System.getProperty("env");
		reports.setSystemInfo("Environment",env);
		if(env==null)
			reports.setSystemInfo("Environment","QA");
		System.out.println("env for reports"+env);
		}
		catch(NullPointerException e)
		{
			System.out.println("env for reports default to QA");
			reports.setSystemInfo("Environment","QA");

		}
		
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	}
	}


