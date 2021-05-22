package stepdefination;

import com.relevantcodes.extentreports.LogStatus;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import base.WaitStatementsLib;
import org.openqa.selenium.support.PageFactory;


import utilities.ObjectUtil;
import utilities.TestUtil;

import PageObjects.Homepage;
import PageObjects.Login;

import base.BaseTest;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDef extends BaseTest {
	

	Homepage hp = new Homepage();
	Login lgf = new Login();
	LinkedHashMap<String, ArrayList<String>> loginPageIconList = null;
	LinkedHashMap<String, String> loginDataSet = null;
	
	public LoginStepDef() throws Exception {
	super.setUp();
    lgf= PageFactory.initElements(driver, Login.class);
    System.out.println(">>>>>>>>"+lgf);
	loginPageIconList = excel.getDriverSheetData("Login");
	logger = reporting.startTestCase("Login");
	loginDataSet = excel.getDriverSheetDataObj("Login");

	}


	
	@Given("^User navigated to login page$")
	public void user_navigated_to_login_page() throws Exception {
		System.out.println("1st");
		TestUtil.WaittoPageLoad();

		reporting.logIntoReport(logger,LogStatus.INFO,"", "URL open successfully");
	}

	@When("^User enter Username and Password$")
	public void user_enter_below_and()  throws Exception {
		LinkedHashMap<String, String> homePageIconList = excel.getDriverSheetDataObj("Login");	
		String username = homePageIconList.get("Activeusername");
		TestUtil.WaittoPageLoad();
		System.out.println(username);
		String password = homePageIconList.get(username);
		System.out.println(password);
		lgf.AeroWebb_login(username,password);

	}

	@When("^Select given Workspace and Language$")
	public void select_below_given_Workspace_and_Language()  throws Exception {
		System.out.println("not Required");
	}

	@When("^click on connect button$")
	public void click_on_connect_button()  throws Exception {
			WaitStatementsLib.iWait(5);
		WaitStatementsLib.eWaitForVisibility(driver,40, lgf.Btn_login_connect);
		clickjs(lgf.Btn_login_connect);
	}

	@Then("^verify user logged in successfully$")
	public void verify_user_logged_in_successfully()  throws Exception {
		if (!isElementPresent(ObjectUtil.getXPathAerowebbLogo())) {
			log.info("User not able to login");
			Assert.assertFalse(isElementPresent(ObjectUtil.getXPathAerowebbLogo()), "User not able to login");
		} else
			log.info("login sucessfully");
	}




	
	

}
