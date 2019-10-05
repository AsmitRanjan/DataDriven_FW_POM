package com.qa.util;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//import com.qa.util.Wait;
//import com.relevantcodes.extentreports.LogStatus;
import com.qa.base.TestBase;

public class GenericFunction extends TestBase{
	
//	Wait wait = new Wait();

	public GenericFunction() {
		super();
	}
	
	// ------------------------------------------------------------------------------------
     // ---------------------- OneAmerica Reusable Library Starts Here --------------------- 	 
	// ------------------------------------------------------------------------------------
	
	
	public void ComboSelectValue(WebElement element,String strValue,String strdesc) {
	 	try 
	 	{		
	 		Select select = new Select(element);
	 		if (!strValue.isEmpty()) 
	 		{
	 			
	 			select.selectByVisibleText(strValue);
	 			System.out.println("SelectByVisibleText "+
	 					 "'" + strValue +  "' is selected in "+ strdesc);
	 						
	 		}
	 		else
	 		{
//	 			System.out.println("SelectByVisibleText "+
//		                "'" + getSelectedComboOption(element) +"'"+ "  by default is selected in '" +strdesc);
	 		}
	 	} 
	 	catch (NoSuchElementException e) 
	 	{
	 		System.out.println("Select Value :"+
	                 strValue + " is not selected in "+ strdesc);
	 						}
	 	catch(Exception e1)
	 	{
	 		System.out.println("Select Value : Exception"+
	                 strValue + " Throws error "+ e1.getStackTrace());
	 					
	 		
	 	}

	 }

	 public void EnterText(WebElement element, String strValue, String strdesc)
	 {
	 	try
	 	{
	 		
	 		if(!strValue.isEmpty())
	 		{
	 			strValue = strValue.trim();
	 			element.clear();			
	 			element.sendKeys(strValue);

	 	 		System.out.println("EnterText "+
	 	                 "'" +strValue + "'  is entered in  "+ strdesc);
	 		}
	 		else
	 		{
	 			System.out.println("EnterText "+
		              "'" +element.getAttribute("value") + "'" +" by default is set in '"+ strdesc);
	 		}
	 			
	 			
	 	}	
	 	catch(Exception e)
	 	{
	 		System.out.println("EnterText:Exception Message : "+e.getLocalizedMessage()+
	                 strValue + "  is not entered in  "+ strdesc);
	 				
	 	}
	 }
	 public void EnterValue(WebElement element, String intValue, String strdesc)
	 {
	 	try
	 	{
	 		
	 		if(!intValue.isEmpty())
	 		{
	 			intValue = intValue.trim();
	 			element.clear();			
	 			element.sendKeys(intValue);
	 			
	 		}
	 		
	 		System.out.println("EnterValue: "+
	 				intValue + "  is entered in  "+ strdesc);
	 				
	 			
	 	}	
	 	catch(Exception e)
	 	{
	 		System.out.println("EnterValue:Exception Message : "+e.getLocalizedMessage()+
	 				intValue + "  is not entered in  "+ strdesc);
	 				
	 	}
	 }

	 public void getSelectedComboValue(WebElement element,String strValue)
	 {
	       
	       Select select = new Select(element);
	       WebElement selectedvalue = select.getFirstSelectedOption();
	       
	     	  if(selectedvalue.getText().contains(strValue))
	           {
	     		  System.out.println("DropDown: "+
	     	                strValue + "  is selected ");
	     		 		  
	           }
	     	  else
	     	  {
	     		  System.out.println("DropDown: "+
	   	                strValue + "  is not selected ");
	           }
	       
	 }

	 
	 public void ClickElement(WebElement element, String strButtonName)
	 {
	 	try 
	 	{	
	 		
//		 	wait.waitForElementToEnable(driver,element);
		 	element.click();	
		 	 System.out.println("Click "+strButtonName + "  is clicked ");
//		 	extentTest.log(LogStatus.INFO, "Click "+strButtonName + "  is clicked ");
	 	
	 		
	 	}
	 	catch(NoSuchElementException e)
		{
	 		 System.out.println("Click : e.getLocalizedMessage() "+
	 				 strButtonName + "  is not clicked ");	
		}
	 	catch(Exception e)
	 	{
	 		
	 		 System.out.println("Click : e.getLocalizedMessage() "+
	 				 strButtonName + "  is not clicked ");		
	 		
	 	}
	 }
	
	
	

}
