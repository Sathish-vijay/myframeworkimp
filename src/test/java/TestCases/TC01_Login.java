package TestCases;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import utilities.ObjectUtil;
import utilities.TestUtil;

import com.relevantcodes.extentreports.LogStatus;

import PageObjects.Homepage;
import PageObjects.Login;
import base.BaseTest;
import base.WaitStatementsLib;

public class TC01_Login extends BaseTest {

	String sheetName;
	String username;
	String password;

	Login lg = new Login();
	Homepage hp = new Homepage();

	@Test
	public void TC01_Login1() throws Exception {
		log.info("*******************TC01_Login********************");
		logger = reporting.startTestCase("TC01_Login");
		LinkedHashMap<String, ArrayList<String>> homePageIconList = excel.getDriverSheetData("TC01_Login");
		
		
		reporting.logIntoReport(logger,LogStatus.PASS,"TC-Login-010", "Pre-requisite passed");

		WaitStatementsLib.iWaitForSeconds(driver, 20);
		log.info("TC-Login-020 pass");

   		Login lg = new Login();
		try {

			WaitStatementsLib.iWaitForSeconds(driver, 20);
			log.info("TC-Login-020 pass");
			reporting.logIntoReport(logger,LogStatus.INFO,"", "URL open successfully");

			LinkedHashMap<String, String> homePageIconList1 = excel.getDriverSheetDataObj("Login");	
			  
			String username = homePageIconList1.get("Activeusername");
			System.out.println(username);
			String password = homePageIconList1.get(username);
			System.out.println(password);

			lg.AeroWebb_login(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		WaitStatementsLib.eWaitForVisibility(driver,30, getWeblement(ObjectUtil.getButtonXpathTagBtn("Administration")));
		log.info("TC-Login-040 pass");		
		reporting.logIntoReport(logger,LogStatus.PASS,"TC-Login-040", "Username and password are entered successfully ");
		log.info("TC-Login-050 pass");
		
		reporting.logIntoReport(logger,LogStatus.PASS,"TC-Login-050", "User login successfully in the application <font color='DodgerBlue'>");
		
		hp.Home_Page_icon(homePageIconList);
		log.info("TC-Login-060 pass");
		reporting.logIntoReport(logger,LogStatus.PASS,"TC-Login-060", "Menu of homepage is verified successfully ");
		
		hp.Home_Administration_tab(homePageIconList);
		log.info("TC-Login-080 pass");
		reporting.logIntoReport(logger,LogStatus.PASS,"TC-Login-070", "Menu of Administration tab is verified successfully ");
		
		WaitStatementsLib.iWaitForSeconds(driver, 10);
		click(ObjectUtil.getXpathMenuItem("Engineering Data"));
		log.info("TC-Login-090 pass");
		reporting.logIntoReport(logger,LogStatus.PASS,"TC-Login-090", "Engineering Data drop down is expanded successfully ");
				
		hp.Home_Engineering_Data(homePageIconList);
		log.info("TC-Login-100 pass");		
		reporting.logIntoReport(logger,LogStatus.PASS,"TC-Login-100", "Menu of Engineering Data tab is verified successfully ");
		
		WaitStatementsLib.iWaitForSeconds(driver, 10);
		click(ObjectUtil.getXpathMenuItem("Fleet Management"));
		log.info("TC-Login-110 pass");
		reporting.logIntoReport(logger,LogStatus.PASS,"TC-Login-110", "Fleet Management drop down is expanded successfully ");
				
		hp.Home_Fleet_Management_Data(homePageIconList);
		log.info("TC-Login-120 pass");		
		reporting.logIntoReport(logger,LogStatus.PASS,"TC-Login-120", "Menu of Fleet Management tab is verified successfully ");
		
		
	}

}
