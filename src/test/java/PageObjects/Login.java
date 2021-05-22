package PageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




import com.relevantcodes.extentreports.LogStatus;

import utilities.ObjectUtil;
import base.WaitStatementsLib;
import base.BaseTest;




public class Login extends BaseTest {
	
	@FindBy(how = How.ID, using = "login_login_lbl")
    public WebElement Lbl_login_login;
	
	@FindBy(how = How.NAME, using = "login")
    public WebElement Txt_login_login;
	
	@FindBy(how = How.NAME, using = "password")
	public WebElement Txt_login_passwor;
	
	@FindBy(how = How.ID, using = "login_workspace_ctrl")
    public WebElement Txt_login_workspace;
	
	@FindBy(how = How.ID, using = "login_language_ctrl")
	public WebElement Txt_login_language;
	
	@FindBy(how = How.XPATH, using = "//*[@type='submit']")
	public WebElement Btn_login_connect;

	long totalTime;
	long endTime;
	long startTime;
	WebElement ele;
	String js;
	ArrayList<String> tabs;

	public void AeroWebb_login(String username, String password) throws IOException {
		WaitStatementsLib.iWait(15);
		System.out.println(">>>"+username);
		WaitStatementsLib.eWaitForVisibility(driver,40, Txt_login_login);
		System.out.println("2");
		System.out.println(Txt_login_login);
		WaitStatementsLib.iWaitForSeconds(driver, 40);
		Txt_login_login.sendKeys(username);
	//	type(Txt_login_login, username);
		reporting.logIntoReport(logger,LogStatus.PASS,"TC-Login-040", "Username entered successfully as: "+username);
		System.out.println(">>>"+password);
		type(Txt_login_passwor, password);
		reporting.logIntoReport(logger,LogStatus.PASS,"TC-Login-120", "Password entered successfully as: "+password);

		


	}

}
