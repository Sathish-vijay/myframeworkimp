package PageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseTest;
import base.WaitStatementsLib;
import utilities.ObjectUtil;
import utilities.TestUtil;

public class Homepage extends BaseTest{

	public void Home_Page_icon(LinkedHashMap<String, ArrayList<String>> iconList) throws IOException 
	{
	
		WaitStatementsLib.iWaitForSeconds(driver, 100);
		WaitStatementsLib.iWait(15);
		List<WebElement> total_icon = driver.findElements(By.xpath("//ul[@class='list--unstyled nav-container']//li//button"));
		System.out.println("homepage");
		System.out.println(iconList);
		ArrayList<String> homeTab = iconList.get("Home_Page_Icon");
		System.out.println("::::"+homeTab.size());
		for (int i=0; i<total_icon.size();i++)

		{
			int p = i +1;
			System.out.println(total_icon.size());
			WebElement all = driver.findElement(By.xpath("//ul[@class='list--unstyled nav-container']//li["+p+"]//button"));
			System.out.println(all.getText());
			String str = homeTab.get(i);
			System.out.println("::::::::1::::::::::"+str);
			WaitStatementsLib.iWaitForSeconds(driver, 10);
				if (all.getText().contains(str))
				{
						log.info(str+" present in Home Page icon");
						System.out.println(all.getText());
						reporting.logIntoReport(logger,LogStatus.PASS,"TC-Login-060", "Menu of homepage Contains " +str);
				}
				else
				{
					System.err.println(str+" not present in Home Page icon ");
					log.info(str+" not present in Home Page icon ");
					Assert.fail(str+" not present in Home Page icon ");
					reporting.logIntoReport(logger,LogStatus.FAIL,"TC-Login-060", "Menu of homepage Not Contains " +str);

				}
		}


	}

	
	public void Home_Administration_tab(LinkedHashMap<String, ArrayList<String>> iconList) throws Exception
	{
		WaitStatementsLib.iWaitForSeconds(driver, 30);
		click(ObjectUtil.getXpathMenuItem("Administration"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		List<WebElement> total_icon = driver.findElements(By.xpath(ObjectUtil.getXPathHomeMenuLabel()));
		ArrayList<String> homeAdministrationTab = iconList.get("Administration_DD");
		System.out.println(total_icon.size());
          for (int i=0; i<total_icon.size();i++) {
				String str = homeAdministrationTab.get(i);
				
				WaitStatementsLib.iWaitForSeconds(driver, 10);
				System.out.println("::::::"+total_icon.get(i).getText());
				if (total_icon.get(i).getText().contains(str))
				{
					log.info(str+" present in Administration tab ");	
					reporting.logIntoReport(logger,LogStatus.PASS,"TC-Login-070", "Menu of Administration tab contains:"+str);

				}
				else
				{
					System.err.println(str+" not present in Administration_tab ");
					log.info(str+" not present in Administration_tab ");

					reporting.logIntoReport(logger,LogStatus.FAIL,"TC-Login-070", "Menu of Administration tab Not contains:"+str);
					Assert.fail(str+" not present in Administration_tab ");
				}
			}
		click(ObjectUtil.getXpathMenuItem("Administration"));
	}	
	
	
	public void Home_Engineering_Data(LinkedHashMap<String, ArrayList<String>> iconList) throws IOException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> total_icon = driver.findElements(By.xpath(ObjectUtil.getXPathHomeMenuLabel()));
		ArrayList<String> homeEngTab = iconList.get("Engineering_DD");

		for (int i=0; i<total_icon.size();i++) {
				String str = homeEngTab.get(i);

				if (total_icon.get(i).getText().contains(str))
				{
					log.info(str+" present in Engineering Data tab ");
					reporting.logIntoReport(logger,LogStatus.PASS,"TC-Login-090", "Engineering Data tab contains: "+str);

				}
				else
				{
					log.info(str+" not present in Engineering Data ");
					System.err.println(str+" not present in Engineering Data ");
					reporting.logIntoReport(logger,LogStatus.FAIL,"TC-Login-090", "Engineering Data tab Not contains: "+str);
					Assert.fail(str+" not present in Engineering Data ");
					
				}
				System.out.println("3");
			}
		System.out.println("!");
		click(ObjectUtil.getXpathMenuItem("Engineering Data"));
		System.out.println("2");
	}	


	
	
	
	
	public void Home_Fleet_Management_Data(LinkedHashMap<String, ArrayList<String>> iconList) throws IOException
	{

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> total_icon = driver.findElements(By.xpath(ObjectUtil.getXPathHomeMenuLabel()));
		ArrayList<String> homeEngTab = iconList.get("Fleet_DD");

		for (int i=0; i<total_icon.size();i++) {
			String str = homeEngTab.get(i);

			if(total_icon.get(i).getText().contains(str))
				{
					log.info(str+" present in Fleet Management tab ");
					reporting.logIntoReport(logger,LogStatus.PASS,"TC-Login-120", "Menu of Fleet Management tab contains: "+str);

				}
				else
				{
					reporting.logIntoReport(logger,LogStatus.FAIL,"TC-Login-120", "Menu of Fleet Management tab Not contains: "+str);
					log.info(str+" not present in Fleet Management ");
					System.err.println(str+" not present in Fleet Management ");

					Assert.fail(str+" not present in Fleet Management ");
				}

			}
		click(ObjectUtil.getXpathMenuItem("Fleet Management"));
	}	
	
}
