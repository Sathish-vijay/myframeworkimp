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

public class CommonFunctionUtil extends BaseTest{
	
	
    public static String destDir;
    public static DateFormat dateFormat;
    public static String destFile;
    public static String mailscreenshotpath;
    public static String xPath, Action;
        
	public void selectMenuOption(String menuOption) throws IOException {
		boolean optionFound = false;
		WaitStatementsLib.iWait(5);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='list--unstyled nav-container']//li//button"));
		for (WebElement ele : list) {
			System.out.println(ele.getText());
			if (ele.getText().contains(menuOption)) {
				ele.click();
				optionFound = true; 
				break;
			}
			WaitStatementsLib.iWait(1);
		}
		if (!optionFound)
			{
			reporting.logIntoReport(logger,LogStatus.FAIL,"","Menu option " + menuOption + " Not available");
			new Exception("Menu option "+ menuOption + " not available");}
		else 
			reporting.logIntoReport(logger,LogStatus.FAIL,"","Menu option selected as " + menuOption);
			
	}
	
	public void selectSubMenuOption(String menuOption) throws IOException {
		boolean optionFound = false;
		WaitStatementsLib.iWait(1);
		List<WebElement> list = driver.findElements(By.xpath(ObjectUtil.getXPathHomeMenuLabelSpan()));
		for (WebElement ele : list) {
			System.out.println(ele.getText());
			System.out.println(">>"+menuOption);
			if (menuOption.contains(ele.getText())) {
				System.out.println("done");
				System.out.println(ele);
				ele.click();
				optionFound = true; 
				break;
			}
			WaitStatementsLib.iWait(1);
		}
		if (!optionFound)
			{
			reporting.logIntoReport(logger,LogStatus.FAIL,"","Menu option " + menuOption + " Not available");
			new Exception("Menu option "+ menuOption + " not available");}
		else 
			reporting.logIntoReport(logger,LogStatus.FAIL,"","Menu option selected as " + menuOption);
			
	}

}
