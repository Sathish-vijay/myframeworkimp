package utilities;

 

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import PageObjects.Login;
import base.BaseTest;
import base.WaitStatementsLib;

 

public class TestUtil extends BaseTest{
	
	
    public static String destDir;
    public static DateFormat dateFormat;
    public static String destFile;
    public static String mailscreenshotpath;
    public static String xPath, Action;
        
        public static void captureScreenshot() throws IOException {
//            destDir = "test-output/html";
        	 destDir = System.getProperty("user.dir")+File.separator+"test-output"+File.separator+"html";
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

 

            dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

 

            new File(destDir).mkdir();

 

            destFile = dateFormat.format(new Date()) + ".png";
            mailscreenshotpath = destDir + "/" + destFile;
            System.out.println(" mailscreenshotpath : "+mailscreenshotpath);
            FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
            
        
    }
        
        /**

    	 * Static method to get the screenshot
    	 * 
    	 * @param driver
    	 * @param imgPath
    	 * 
    	 * @return dest : String value of Path
    	 * 
    	 * @throws IOException
    	 */
    	public static String capture(String imgPath) throws IOException {
        	String newTime = time();
            TakesScreenshot ts = (TakesScreenshot)driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = imgPath + newTime + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
            String relativePath = "." + File.separator + "Screenshots" + File.separator + newTime + ".png";
            return relativePath;
        }

        /**

    	 * Method to return date in format dd_MMM_yyyy_hh_mm_ss_aa
    	 * @return String
    	 */
    	public static String time() {
    		Date now = new Date();
    		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ss_aa");
    		String time = dateFormat.format(now);
    		
    		return time;
    	}
    	//"****************Checking for editable*********************"  	
    	public static boolean isEditable(String xPath, String attribute){
    		String attr = driver.findElement(By.xpath(xPath)).getAttribute(attribute);
    		System.out.println("111"+ attr);
    		return attr.equals("true");
    	}
    	
    	public static boolean isEditable(WebElement id, String attribute){
    		String attr = id.getAttribute(attribute);
    		System.out.println("111"+ attr);
    		return attr.equals("true");
    	}
    	
    	public static boolean isEditableWithAllAttri(WebElement id){
    		String attr = id.getAttribute("outerHTML");
    		String modAttr = attr.replace("\"", "\\\"");
    		System.out.println("out put is"+modAttr);
    		if (modAttr.contains("disabled")&&!(modAttr.contains(("disabled" + "="+ "\"false\"")))){
        		System.out.println("111 true");
    			return true;

    		}else return false;
    		
    	}
    	
    	public static boolean isEditableWithAllAttri(String xPath){
    		String attr = driver.findElement(By.xpath(xPath)).getAttribute("outerHTML");
    		String modAttr = attr.replace("\"", "\\\"");
    		System.out.println("out put is"+modAttr);
    		if (modAttr.contains("disabled")&&!(modAttr.contains(("disabled" + "="+ "\"false\"")))){
        		System.out.println("111 true");
    			return true;

    		}else return false;
    		
    	
    	}
    	//public static boolean isClear(String xPath){
    	//	String clr = driver.findElement(By.xpath(OR.getProperty(xPath))).clear();
    	//SSSSSS	return ();

		public int countOfListElement(List<WebElement> elementList) {
			// TODO Auto-generated method stub
			int count = 0;
			try {				
					if (!elementList.isEmpty())
					{
						Thread.sleep(1000);					
						count = elementList.size();
					}
				} catch (Exception Ex) {
					System.err.println("Timeout Exception for element -" + Thread.currentThread().getStackTrace());
				}
			return count;
		}
		
		public String getPageSource()
		{
			return driver.getPageSource();
			
		}

    	//"****************Delete*********************"
		
    	public static boolean DeletedforYes(WebElement IdOfButton, String stepName, String msg) throws IOException {
    		try{
        	clickjs(IdOfButton);

    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalTitle()),"Heading is not present");
    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalContent()),"Delete message is not present");
    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalFooterButton("No")),"No Button is not present");
    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalFooterButton("Yes")),"Yes Button is not present");
			reporting.logIntoReport(logger,LogStatus.INFO,"","User clicked on Delete button and pop up message displayed");
			
    		WaitStatementsLib.eWaitForVisibility(driver,30, getWeblement(ObjectUtil.DeleteModalFooterButton("Yes")));
			clickjs(ObjectUtil.DeleteModalFooterButton("Yes"));
    		Assert.assertTrue(isElementPresent("//div[contains(text(),'deleted successfully')]"),
    				"Success message to save data is not displayed on screen");
    		try {
    			if (isElementPresent("//div[contains(text(),'deleted successfully')]")) {
    				click("//p-toast//button");
    				
    			}
    		} catch (Exception e) {

    		}
			reporting.logIntoReport(logger,LogStatus.PASS,stepName,msg);
			return true;
			
			} catch (IOException e) {
				e.printStackTrace();
				reporting.logIntoReport(logger,LogStatus.FAIL,stepName,"Unable to delete the element");
				return false;
			}

}
    	public static boolean DeletedforYes(String IdOfButton, String stepName, String msg) throws IOException {
    		try{
    			WaitStatementsLib.iWaitForSeconds(driver, 15);
        	click(IdOfButton);

    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalTitle()),"Heading is not present");
    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalContent()),"Delete message is not present");
    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalFooterButton("No")),"No Button is not present");
    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalFooterButton("Yes")),"Yes Button is not present");

			reporting.logIntoReport(logger,LogStatus.INFO,"","User clicked on Delete button and pop up message displayed");
			
    		WaitStatementsLib.eWaitForVisibility(driver,30, getWeblement(ObjectUtil.DeleteModalFooterButton("Yes")));
			WaitStatementsLib.iWaitForSeconds(driver, 15);
    		clickjs(ObjectUtil.DeleteModalFooterButton("Yes"));
			
    		Assert.assertTrue(isElementPresent("//div[contains(text(),'deleted')]"),
    				"Success message to save data is not displayed");
    		try {
    			if (isElementPresent("//div[contains(text(),'deleted')]")) {
    				click("//p-toast//button");
    				
    			}
    		} catch (Exception e) {

    		}
			reporting.logIntoReport(logger,LogStatus.PASS,stepName,msg);
			return true;
			
			} catch (IOException e) {
				e.printStackTrace();
				reporting.logIntoReport(logger,LogStatus.FAIL,stepName,"Unable to delete the element");
				return false;
			}

} 	
    	public static boolean DeletedforYes(WebElement IdOfButton, String stepName, String msg,String DeleteMsg) throws IOException {
    		try{
    			WaitStatementsLib.iWaitForSeconds(driver, 15);
        	click(IdOfButton);

    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalTitle()),"Heading is not present");
    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalContent()),"Delete message is not present");
    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalFooterButton("No")),"No Button is not present");
    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalFooterButton("Yes")),"Yes Button is not present");

			reporting.logIntoReport(logger,LogStatus.INFO,"","User clicked on Delete button and pop up message displayed");
			
    		WaitStatementsLib.eWaitForVisibility(driver,30, getWeblement(ObjectUtil.DeleteModalFooterButton("Yes")));
			WaitStatementsLib.iWaitForSeconds(driver, 15);
    		clickjs(ObjectUtil.DeleteModalFooterButton("Yes"));
			
    		Assert.assertTrue(isElementPresent("//div[contains(text(),'"+DeleteMsg+"')]"),
    				"Success message to save data is not displayed");
    		try {
    			if (isElementPresent("//div[contains(text(),'"+DeleteMsg+"')]")) {
    				click("//p-toast//button");
    				
    			}
    		} catch (Exception e) {

    		}
			reporting.logIntoReport(logger,LogStatus.PASS,stepName,msg);
			return true;
			
			} catch (IOException e) {
				e.printStackTrace();
				reporting.logIntoReport(logger,LogStatus.FAIL,stepName,"Unable to delete the element");
				return false;
			}

}
    	
    	public static boolean DeletedforYes(String IdOfButton, String stepName, String msg,String DeleteMsg) throws IOException {
    		try{
    			WaitStatementsLib.iWaitForSeconds(driver, 30);
        	click(IdOfButton);

    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalTitle()),"Heading is not present");
    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalContent()),"Delete message is not present");
    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalFooterButton("No")),"No Button is not present");
    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalFooterButton("Yes")),"Yes Button is not present");

			reporting.logIntoReport(logger,LogStatus.INFO,"","User clicked on Delete button and pop up message displayed");
			
    		WaitStatementsLib.eWaitForVisibility(driver,30, getWeblement(ObjectUtil.DeleteModalFooterButton("Yes")));
			WaitStatementsLib.iWaitForSeconds(driver, 15);
    		clickjs(ObjectUtil.DeleteModalFooterButton("Yes"));
			WaitStatementsLib.iWaitForSeconds(driver, 30);
    		Assert.assertTrue(isElementPresent("//div[contains(text(),'"+DeleteMsg+"')]"),
    				"Success message to save data is not displayed");
    		try {
    			if (isElementPresent("//div[contains(text(),'"+DeleteMsg+"')]")) {
    				click("//p-toast//button");
    				
    			}
    		} catch (Exception e) {

    		}
			reporting.logIntoReport(logger,LogStatus.PASS,stepName,msg);
			return true;
			
			} catch (IOException e) {
				e.printStackTrace();
				reporting.logIntoReport(logger,LogStatus.FAIL,stepName,"Unable to delete the element");
				return false;
			}

}
    	public static boolean DeletedforNo(String IdOfButton, String stepName, String msg) throws IOException {
        	try{
    		click(IdOfButton);

    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalTitle()),"Heading is not present");
    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalContent()),"Delete message is not present");
    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalFooterButton("No")),"No Button is not present");
    		Assert.assertTrue(isElementPresent(ObjectUtil.DeleteModalFooterButton("Yes")),"Yes Button is not present");
    		
			reporting.logIntoReport(logger,LogStatus.INFO,"","User clicked on Delete button and pop up message displayed");
			
    		WaitStatementsLib.eWaitForVisibility(driver,30, getWeblement(ObjectUtil.DeleteModalFooterButton("No")));
			clickjs(ObjectUtil.DeleteModalFooterButton("No"));
			reporting.logIntoReport(logger,LogStatus.PASS,stepName,msg);


			return true;
			
			}catch (IOException e) {
				e.printStackTrace();
				return false;
			}
        	
    	}
    	//"****************Label Check *********************"    	
    	public static boolean assertLabel(String labelxpath, String fieldLabel) throws IOException {
    		try{
        		String labeltxt = driver.findElement(By.xpath(labelxpath)).getText();
        		Assert.assertEquals(labeltxt, fieldLabel);

			return true;
			
			} catch (Exception e) {
				e.printStackTrace();
				reporting.logIntoReport(logger,LogStatus.FAIL,"",fieldLabel+"Unable to find the field label");
				return false;
			}
    	}
    	    	
    	
    	public static boolean assertLabel(WebElement labelxpath, String fieldLabel) throws IOException {
    		try{
        		String labeltxt = labelxpath.getText();
        		Assert.assertEquals(labeltxt, fieldLabel);

			return true;
			
			} catch (Exception e) {
				e.printStackTrace();
				reporting.logIntoReport(logger,LogStatus.FAIL,"",fieldLabel+"Unable to find the field label");
				return false;
			}
    	}  
    	
    	//"****************DropDown*********************"   	
    	public static void SelectValueDromDropDownpopup(String labelName, String valueToSelect) throws IOException {
    		String xpathToDropDown = "//a-modal//label[contains(.,'" + labelName
    		+ "')]/..//div[contains(@class,'dropdown-trigger')]";
    		String xpathToValue = "//li/span[contains(.,'" + valueToSelect + "')]";
    		WaitStatementsLib.iWaitForSeconds(driver, 10);
    		BaseTest.clickjs(xpathToDropDown);
    		WaitStatementsLib.iWaitForSeconds(driver, 10);
    		BaseTest.clickjs(xpathToValue);
    	}
    	
    	public static void SelectValueDromDropDown(String labelName, String valueToSelect) throws IOException {
    		String xpathToDropDown = "//label[contains(.,'" + labelName+ "')]/..//div[contains(@class,'dropdown-trigger')]";
    		System.out.println(xpathToDropDown);
    		String xpathToValue = "//li/span[contains(.,'" + valueToSelect + "')]";
    		click(xpathToDropDown);
    		WaitStatementsLib.iWaitForSeconds(driver, 20);
    		click(xpathToValue);
    	}
    	
    	public static void SelectValueDromDropDown1(String labelName, String valueToSelect) throws IOException {
    		String xpathToDropDown = "//aw-tab-container[@class='ng-star-inserted']//label[contains(.,'" + labelName+ "')]/..//div[contains(@class,'dropdown-trigger')]";
    		System.out.println(xpathToDropDown);
    		String xpathToValue = "//li/span[contains(.,'" + valueToSelect + "')]";
    		click(xpathToDropDown);
    		WaitStatementsLib.iWaitForSeconds(driver, 20);
    		click(xpathToValue);
    	}
    	
    	public static boolean selecValueFromDropdown(String value) {
    		boolean clicked=false;
    		try {
    			
    			WaitStatementsLib.iWaitForSeconds(driver, 30);		
    			List<WebElement> techData= driver.findElements(By.xpath("//li[@role='option']"));
    			WaitStatementsLib.iWaitForSeconds(driver, 10);	
                System.out.println(techData.size());
    			for (WebElement element : techData) {
    				System.out.println(element.getText());			
    				  if (element.getText().contains(value))
    				  { 
    		    		WaitStatementsLib.iWaitForSeconds(driver, 10);
    		    		System.out.println("yaha tak");
    		    		element.click();
    		//			clickjs(element);
    				  	break; 
    				  }			 
    			}			

    			clicked=true;
    			} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return clicked;
    	}
    
    	public static boolean selecFirstValueFromDropdown(String id) {
    		boolean clicked=false;
    		try {
    		
    			WaitStatementsLib.iWaitForSeconds(driver, 30);		
    			click(driver.findElement(By.xpath(".//*[@id='"+id+"']//p-dropdownitem[1]/li[1]")));
     						

    			clicked=true;
    			} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return clicked;
    	}
    	
    	public static boolean CheckAllValuesOfDropDown(String NameKeySet, LinkedHashMap<String, ArrayList<String>> iconList) {
    		boolean clicked=false;
    		try {

    			WaitStatementsLib.iWaitForSeconds(driver, 30);
    			
    			List<WebElement> techData= driver.findElements(By.xpath("//li[@role='option']"));
    			int totalEle = techData.size();
    			
    			for (int i = 1;i<totalEle-1;i++)
    			{
    				ArrayList<String> homeAdministrationTab = iconList.get(NameKeySet);
    				System.out.println(i +"=========="+homeAdministrationTab);
        				if (homeAdministrationTab.contains(techData.get(i).getText())){
        			        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", 
        			        		driver.findElement(By.xpath(".//*[contains(@role,'listbox')]//p-dropdownitem["+i+"]")));

    	    				System.out.println(techData.get(i).getText()+" is present in search result page ");
    	    				}else
    					{
    						System.err.println(techData.get(i).getText() + " not present in table");
    						reporting.logIntoReport(logger, LogStatus.FAIL, "", techData.get(i).getText() + " not present in table");
    						Assert.fail(techData.get(i).getText() + " not present in Table");		 
    			}			
    			}
    			clicked=true;
    			} 
    		catch (Exception e) {
    			e.printStackTrace();
    		}
    		return clicked;
    	}	
    	
    	public static boolean CheckAllValuesOfDropDown1(String NameKeySet, LinkedHashMap<String, ArrayList<String>> iconList) {
    		boolean clicked=false;
    		try {

    			WaitStatementsLib.iWaitForSeconds(driver, 30);
    			
    			List<WebElement> techData= driver.findElements(By.xpath("//li[@role='option']"));
    			int totalEle = techData.size();
    			
    			for (int i = 0;i<totalEle-1;i++)
    			{
    				ArrayList<String> homeAdministrationTab = iconList.get(NameKeySet);
    				System.out.println(i +"=========="+homeAdministrationTab);
        				if (homeAdministrationTab.contains(techData.get(i).getText())){
        			        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", 
        			        		driver.findElement(By.xpath(".//*[contains(@role,'listbox')]//p-dropdownitem["+i+"]")));

    	    				System.out.println(techData.get(i).getText()+" is present in search result page ");
    	    				}else
    					{
    						System.err.println(techData.get(i).getText() + " not present in table");
    						reporting.logIntoReport(logger, LogStatus.FAIL, "", techData.get(i).getText() + " not present in table");
    						Assert.fail(techData.get(i).getText() + " not present in Table");		 
    			}			
    			}
    			clicked=true;
    			} 
    		catch (Exception e) {
    			e.printStackTrace();
    		}
    		return clicked;
    	}	

    	//"****************ZoomIn*********************"
    	
    	public static void zoomInScreen(int value) {
    		Robot robot;
			try {
				robot = new Robot();
				WaitStatementsLib.iWait(5);
	    		for (int i = 0; i < value; i++) {
	    			robot.keyPress(KeyEvent.VK_CONTROL); 
	    			robot.keyPress(KeyEvent.VK_SUBTRACT);
	    			robot.keyRelease(KeyEvent.VK_SUBTRACT);
	    			robot.keyRelease(KeyEvent.VK_CONTROL); 
	    			}
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
      	}
 
    	//"****************ZoomOut*********************"

    	public static void zoomOutScreen(int value) {
    		Robot robot;
			try {
				robot = new Robot();
				WaitStatementsLib.iWait(5);
	    		for (int i = 0; i < value; i++) {
	    			robot.keyPress(KeyEvent.VK_CONTROL); 
	    			robot.keyPress(KeyEvent.VK_ADD);
	    			robot.keyRelease(KeyEvent.VK_ADD);
	    			robot.keyRelease(KeyEvent.VK_CONTROL); 
	    			}
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
      	}

    	//"****************Page Load*********************"
    	
    	public static void WaittoPageLoad() {
    		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
    			public Boolean apply(WebDriver driver) {
    				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
    						.equals("complete");
    			}
    		};
    		try {
    			Thread.sleep(1000);
    			WebDriverWait wait = new WebDriverWait(driver, 60);
    			wait.until(expectation);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}

    	
    	//"****************Date*********************"
    	
    	public static boolean selectDate(String month, int Year, int date) {
    		boolean clicked=false;
    		try {

    			WaitStatementsLib.iWaitForSeconds(driver, 40);

        		String xpathToValue = "//div[contains(@class,'datepicker-title')]//select[1]";
        		clickjs(xpathToValue);
 			   WaitStatementsLib.iWait(5);
    			List<WebElement> techData= driver.findElements(By.xpath(xpathToValue+"//option"));
    			for (WebElement element : techData) {
    				System.out.println(element.getText());		
    				System.out.println(month);
    				  if (element.getAttribute("text").contentEquals(month)) 
    				  { element.click();
    				  System.out.println("monthclickdone");
    				  	break; 
    				  }	
    	
    			}		
    			
/*    			WaitStatementsLib.iWaitForSeconds(driver, 30);
    			
        		String xpathToValue1 = "//div[contains(@class,'datepicker-title')]//select[2]";
    			WaitStatementsLib.iWaitForSeconds(driver, 30);
    			System.out.println("year");
    		
        		clickjs(xpathToValue1);
    			WaitStatementsLib.iWaitForSeconds(driver, 30);
    			System.out.println("xpathToValue1");
    			List<WebElement> techData1= driver.findElements(By.xpath(xpathToValue+"//option"));
    			for (WebElement element : techData1) {
    				System.out.println(element.getText());		
    				String Myear = String.valueOf(Year);
    				  if (element.getText().contains(Myear));
    				  { 
    					  clickjs(element);
    					  clicked=true;
    				  	break; 
    				  }	
    			}
   */ 			  WaitStatementsLib.iWaitForSeconds(driver, 30);
	  WaitStatementsLib.iWait(5);		
      String data = "//table[contains(@class,'datepicker-calendar')]//span[text()='"+ date +"']";
    	     clickjs(data);
    	       	System.out.println("dateclicked");
    	       	return clicked;
    			
    			//((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    			
    			} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return clicked;
    	}
    
    	//"****************Login*********************"
   	
    	public static void Commonlogin() {
    		Login lg = new Login();
    		try {



    			WaitStatementsLib.iWaitForSeconds(driver, 20);
    			log.info("TC-Login-020 pass");
    			reporting.logIntoReport(logger,LogStatus.INFO,"", "URL open successfully");

    			LinkedHashMap<String, String> homePageIconList = excel.getDriverSheetDataObj("Login");	
    			  
    			String username = homePageIconList.get("Activeusername");
    			System.out.println(username);
    			String password = homePageIconList.get(username);
    			System.out.println(password);

    			lg.AeroWebb_login(username, password);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	//"****************Tables / List*********************"

    	/**
    	 * Method to make xpath based on Row and Column
    	 * ex. XpathColumn string : .//*[@id=\"leftcontainer\"]/table/thead/tr/th"))
    	 * ex. XpathColumn string : .//*[@id='leftcontainer']/table/tbody/tr/td[1]")
    	 * @param element: String value of xpath
    	 * @param token:   String value of variable
    	 * @return WebElement: WebElement xpath
    	 */
    	public static int SearchTabelGetRowSize(String XpathRow) {
    		int TotalRow = 0;
    		try {

    	        //No.of rows 
    	        List<WebElement>  rows = driver.findElements(By.xpath(XpathRow)); 
    	        TotalRow = rows.size();
    	        System.out.println("No of cols are : " +rows.size()); 
 	    
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return TotalRow;
    	}
    	
    	public static void SearchAndCompair(String XpathRow,LinkedHashMap<String, ArrayList<String>> iconList) {

    		try {

    	        //No.of rows 
    	        List<WebElement> rows = driver.findElements(By.xpath(XpathRow)); 
    	        int TotalRow = rows.size();
       			System.out.println(TotalRow);

    			for (int i = 1;i<TotalRow-1;i++)
    			{
    				ArrayList<String> homeAdministrationTab = iconList.get("Key_Set");
    				System.out.println(i +"=========="+homeAdministrationTab);
        				if (homeAdministrationTab.contains(rows.get(i).getText())){
    	    				System.out.println(rows.get(i).getText()+" is present in search result page ");
    	    				}else
    					{
    						System.err.println(rows.get(i).getText() + " not present in table");
    						reporting.logIntoReport(logger, LogStatus.FAIL, "", rows.get(i).getText() + " not present in table");
    						Assert.fail(rows.get(i).getText() + " not present in Table");

    			}
    			}

    		}
 	         catch (Exception e) {
    			e.printStackTrace();
    		}
    		}

    	public static void SearchAndCompair(int StartingRow,String Key_Set,String XpathRow,LinkedHashMap<String, ArrayList<String>> iconList) {

    		try {

    	        //No.of rows 
    	        List<WebElement> rows = driver.findElements(By.xpath(XpathRow)); 
    	        int TotalRow = rows.size();
       			System.out.println(TotalRow);

    			for (int i = StartingRow;i<TotalRow;i++)
    			{
    				ArrayList<String> homeAdministrationTab = iconList.get(Key_Set);
    				System.out.println(i +"=========="+homeAdministrationTab);
        				if (homeAdministrationTab.contains(rows.get(i).getText())){
    	    				System.out.println(rows.get(i).getText()+" present in table");
    	    				}else
    					{
    						System.err.println(rows.get(i).getText() + " not present in table");
    						reporting.logIntoReport(logger, LogStatus.FAIL, "", rows.get(i).getText() + " not present in table");
    						Assert.fail(rows.get(i).getText() + " not present in Table");

    			}
    			}

    		}
 	         catch (Exception e) {
    			e.printStackTrace();
    		}
    		}
    	
    	public static void SearchAndCompairNewTableTitle(String ListContainer,String NameKeySet, LinkedHashMap<String, ArrayList<String>> iconList) {

    		try {

    	        //No.of rows "+ListContainer+"
    	        List<WebElement> rows = driver.findElements(By.xpath("//"+ListContainer+"//*[contains(@class,'table-header')]/div/div")); 
    	        int TotalRow = rows.size(); 
       			System.out.println(TotalRow);

    			for (int i = 1;i<=TotalRow;i++)
    			{
    				ArrayList<String> EnterTab = iconList.get(NameKeySet);
    				System.out.println(i +"=========="+EnterTab);
        				if (EnterTab.contains(rows.get(i).getText())){
    	    				System.out.println(rows.get(i).getText()+" is present in Table ");
    	    				}else
    					{
    						System.err.println(rows.get(i).getText() + " not present in table");
    						reporting.logIntoReport(logger, LogStatus.FAIL, "", rows.get(i).getText() + " not present in table");
    						Assert.fail(rows.get(i).getText() + " not present in Table");

    			}
    			}

    /*			for (int rowNum=1; rowNum<TotalRow;rowNum++)
    			{
    				
    				if (iconList.keySet().contains(rows.get(rowNum).getText())){
	    				System.out.println(rows.get(rowNum).getText()+" is present in search result page ");
					}else
					{
						System.err.println(rows.get(rowNum).getText() + " not present in table");
						reporting.logIntoReport(logger, LogStatus.FAIL, "", rows.get(rowNum).getText() + " not present in table");
						Assert.fail(rows.get(rowNum).getText() + " not present in Catalog area ");
				}
    			}         */
    		}
 	         catch (Exception e) {
    			e.printStackTrace();
    		}
    		}
    	
       	public static void SearchAndCompairNewTableTitleWithId(String Id,String NameKeySet, LinkedHashMap<String, ArrayList<String>> iconList) {

    		try {

    	        //No.of rows "+ListContainer+"
    	        List<WebElement> rows = driver.findElements(By.xpath("//aw-tab-container[@class='ng-star-inserted']//*[@id='"+Id+"']//*[contains(@class,'table-header')]/div/div")); 
    	        int TotalRow = rows.size(); 
       			System.out.println(TotalRow);

    			for (int i = 0;i<=TotalRow;i++)
    			{
    				ArrayList<String> EnterTab = iconList.get(NameKeySet);
    				System.out.println(i +"=========="+EnterTab);
        				if (EnterTab.contains(rows.get(i).getText())){
    	    				System.out.println(rows.get(i).getText()+" is present in Table ");
    	    				}else
    					{
    						System.err.println(rows.get(i).getText() + " not present in table");
    						reporting.logIntoReport(logger, LogStatus.FAIL, "", rows.get(i).getText() + " not present in table");
    						Assert.fail(rows.get(i).getText() + " not present in Table");

    			}
    			}

    /*			for (int rowNum=1; rowNum<TotalRow;rowNum++)
    			{
    				
    				if (iconList.keySet().contains(rows.get(rowNum).getText())){
	    				System.out.println(rows.get(rowNum).getText()+" is present in search result page ");
					}else
					{
						System.err.println(rows.get(rowNum).getText() + " not present in table");
						reporting.logIntoReport(logger, LogStatus.FAIL, "", rows.get(rowNum).getText() + " not present in table");
						Assert.fail(rows.get(rowNum).getText() + " not present in Catalog area ");
				}
    			}         */
    		}
 	         catch (Exception e) {
    			e.printStackTrace();
    		}
    		}
    	
    	public static String SearchTabelGetValue(int RowNum, int ColNum) {
    		String valueIneed = null;
    		try {
    			   WaitStatementsLib.iWait(3);
    	        List<WebElement>  rows = driver.findElements(By.xpath("//table/tbody/tr")); 
    	        System.out.println("No of cols are : " +rows.size()); 

    			    //to get 3rd row's= RowNum and 2nd column = ColNum data
    			    WebElement cellIneed = driver.findElement(By.xpath("//table/tbody/tr["+RowNum+"]/td["+ColNum+"]"));
    			    valueIneed = cellIneed.getText();
	    
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return valueIneed;
    	}
    	
    	public static String SearchTabelValueClick(String Ids, int RowNum, int ColNum) {
    		String valueIneed = null;
    		try {			    
    			    //to get 3rd row's= RowNum and 2nd column = ColNum data
    			    WebElement cellIneed = driver.findElement(By.xpath(Ids+"//table/tbody/tr["+RowNum+"]/td["+ColNum+"]"));
    			    cellIneed.click();
	    
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return valueIneed;
    	}
    	public static String SearchTabelGetPerticularRow(String RowNum) {

			String rowtext=null;
    		try {

    			 //To find third row of table
    			 WebElement tableRow = driver.findElement(By.xpath("//table/tbody/tr["+RowNum+"]"));
    	         rowtext = tableRow.getText();
    			 System.out.println("Third row of table : "+rowtext);
	    
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return rowtext;
    	}
    	
    	public static int SearchTabelGetCol(String XpathColumn) {
    		int TotalCol = 0;
    		try {

    	        //No.of Columns
    	        List<WebElement> col = driver.findElements(By.xpath(XpathColumn));
    	        TotalCol = col.size();
    	        System.out.println("No of cols are : " +col.size()); 
	    
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return TotalCol;
    	}
    	
    	
    	
    	public static void SearchGetValue(String XpathColumn,String XpathRow, String TableId, String RowNum, String ColNum) {
    		Login lg = new Login();
    		try {

    	        //No.of Columns
    	        List  col = driver.findElements(By.xpath(XpathColumn));
    	        System.out.println("No of cols are : " +col.size()); 
    	        //No.of rows 
    	        List  rows = driver.findElements(By.xpath(XpathRow)); 
    	        System.out.println("No of cols are : " +rows.size()); 
    	        
    			 //To find third row of table
    			 WebElement tableRow = driver.findElement(By.xpath("//table/tbody/tr["+RowNum+"]"));
    	         String rowtext = tableRow.getText();
    			 System.out.println("Third row of table : "+rowtext);
    			    
    			    //to get 3rd row's 2nd column data
    			    WebElement cellIneed = driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]//table/tbody/tr["+RowNum+"]/td["+ColNum+"]"));
    			    String valueIneed = cellIneed.getText();
    			    
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    
    	public static int SearchTabelSearchAndClickValue(String IdTable, String value) {
    		int TotalCol = 0;
    		try {

    	        //No.of Columns
    	        List<WebElement> col = driver.findElements(By.xpath(".//*[@id='"+IdTable+"']//table/tbody//tr"));
    	        TotalCol = col.size();
    	        System.out.println("No of cols are : " +col.size()); 
    	        
    			for (int i = 1;i<=TotalCol;i++)
    			{
    			    WebElement cellIneed = driver.findElement(By.xpath(".//*[@id='"+IdTable+"']//table/tbody//tr["+i+"]"));

    			    System.out.println(cellIneed.getText());
    			    System.out.println(value);
        				if (cellIneed.getText().contains(value)){
        					cellIneed.click();
    	    				System.out.println(cellIneed.getText()+" is present in search result page ");
    	    				break;

    			}
    			}
	    
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return TotalCol;
    	}
    	public static int SearchTabelSearchAndClickValueWithDivId(String IdTable, String value) {
    		int TotalCol = 0;
    		try {

    	        //No.of Columns
    	        List<WebElement> col = driver.findElements(By.xpath(".//*[@id='"+IdTable+"']//*[contains(@class,'body')]//*[contains(@class,'row')]"));
    	        TotalCol = col.size();
    	        System.out.println("No of cols are : " +col.size()); 
    	        
    			for (int i = 1;i<=TotalCol;i++)
    			{
    			    WebElement cellIneed = driver.findElement(By.xpath(".//*[@id='"+IdTable+"']//*[contains(@class,'body')]//*[contains(@class,'row')]["+i+"]"));

        				if (cellIneed.getText().contains(value)){
        					cellIneed.click();
    	    				System.out.println(cellIneed.getText()+" is present in search result page ");
    	    				break;

    			}
    			}
	    
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return TotalCol;
    	}	

public static int SearchTabelSearchAndClickValueWithoutId(String ListContainer, String value) {
	int TotalCol = 0;
	try {
		WaitStatementsLib.iWait(3);
        //No.of Columns
        List<WebElement> col = driver.findElements(By.xpath(
        		"//aw-tab-container[@class='ng-star-inserted']//"+ListContainer+"//*[contains(@class,'table-body')]//*[(@class='yac-table-row') and not(contains(@class,'yac-table-row hidden'))]"));
        TotalCol = col.size();  
        System.out.println("No of cols are : " +col.size()); 
        System.out.println(value);
        
		for (int i = 1;i<=TotalCol;i++)
		{
		    WebElement cellIneed = driver.findElement(By.xpath("//aw-tab-container[@class='ng-star-inserted']//"+ListContainer+"//*[contains(@class,'table-body')]//*[(@class='yac-table-row') and not(contains(@class,'yac-table-row hidden'))]["+i+"]"));
              System.out.println(cellIneed.getText());
				if (cellIneed.getText().contains(value)){
					cellIneed.click();
    				System.out.println(cellIneed.getText()+" is present in search result page ");
    				break;

		}
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	return TotalCol;
}

public static int SearchTabelSearchAndClickFirstRowWithoutId( String value) {
	int TotalCol = 0;
	try {
		WaitStatementsLib.iWait(3);
        //No.of Columns
        List<WebElement> col = driver.findElements(By.xpath(
        		".//*[contains(@class,'p-datatable-tbody')]/tr"));
        TotalCol = col.size();  
        System.out.println("No of cols are : " +col.size()); 
        System.out.println(value);
        
		for (int i = 1;i<=TotalCol;i++)
		{
		    WebElement cellIneed = driver.findElement(By.xpath(".//*[contains(@class,'p-datatable-tbody')]/tr[1]"));
              System.out.println(cellIneed.getText());
				if (cellIneed.getText().contains(value)){
					cellIneed.click();
    				System.out.println(cellIneed.getText()+" is present in search result page ");
    				break;

		}
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	return TotalCol;
}

//"****************GLOBAL fILTER*********************"


public static int GlobalFilterTestWithoutId(String ListContainer, String value) {
	int TotalCol = 0;
	try {
		
        //No.of Columns
        List<WebElement> col = driver.findElements(By.xpath("//"+ListContainer+"//*[contains(@class,'table-body')]//*[contains(@class,'table-row')]"));
        TotalCol = col.size();
        System.out.println("No of cols are : " +col.size()); 
        
		for (int i = 1;i<=TotalCol;i++)
		{
		    WebElement cellIneed = driver.findElement(By.xpath("//"+ListContainer+"//*[contains(@class,'table-body')]//*[contains(@class,'table-row')]["+i+"]"));
                System.out.println(cellIneed.getText());
				if (cellIneed.getText().contains(value)){
    				System.out.println(cellIneed.getText()+" is present in search result page ");
    				break;

		}
				else {
    				System.out.println(cellIneed.getText()+" is Not present in search result page ");
				}
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	return TotalCol;
}


//"****************Messages*********************"

public static void save_message_validation() throws IOException {

	Assert.assertTrue(isElementPresent("//div[contains(text(),'saved successfully')]"),
			"Success message to save data is not displayed on screen");
	try {
		if (isElementPresent("//div[contains(text(),'saved successfully')]")) {
			click("//p-toast//button");
			
		}
	} catch (Exception e) {

	}
	
}
public static void save_message_validation(String message) throws IOException {
	WaitStatementsLib.iWaitForSeconds(driver, 25);
	Assert.assertTrue(isElementPresent("//div[contains(text(),'"+message+"')]"),
			"Success message to save data is not displayed on screen");
	try {
		if (isElementPresent("//div[contains(text(),'"+message+"')]")) {
			clickjs("//p-toast//button");
		}
	} catch (Exception e) {

	}
	
}
	public static void save_error_message() throws IOException {
		WaitStatementsLib.iWaitForSeconds(driver, 20);
		Assert.assertTrue(isElementPresent("//div[contains(text(),'Please fill all required fields')]"),
				"Fail message after cliking save is not displayed on screen");
		WaitStatementsLib.iWaitForSeconds(driver, 20); 
		try {
			if (isElementPresent("//div[contains(text(),'Please fill all required fields')]")) {
				click("//p-toast//button");
				
			}
		} catch (Exception e) {

		}
	}
		
		public static void save_error_message(String message) throws IOException {
			WaitStatementsLib.iWaitForSeconds(driver, 20);
			Assert.assertTrue(isElementPresent("//div[contains(text(),'"+message+"')]"),
					"Fail message after cliking save is not displayed on screen");
			try {
				if (isElementPresent("//div[contains(text(),'"+message+"')]")) {
					clickjs("//p-toast//button");
					
				}
			} catch (Exception e) {

			}
}


}
