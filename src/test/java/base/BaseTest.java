package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import extentlisteners.Report;
//import utilities.DbManager;
import utilities.ExcelReader;
import utilities.SkipExecution;
import utilities.TestUtil;
//import utilities.MonitoringMail;

public class BaseTest {

	public static WebDriver driver;
	public static ExtentTest logger;
	public static Properties OR = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("BaseTest");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static String reportFilepath = System.getProperty("user.dir") + File.separator + "reports" +File.separator+ TestUtil.time();
	public static Report reporting = new Report(reportFilepath);
	//public static MonitoringMail mail = new MonitoringMail();
	public static WebDriverWait wait;

	public static WebElement dropdown;
	static WebElement ele;





	@BeforeClass
	public void setUp() throws IOException {
		
	//	@BeforeTest 
		String testCaseName = this.getClass().getSimpleName();
	    if (!SkipExecution.isSkipExecution(testCaseName)) {                    
	           throw new SkipException("Runmode Is 'No' Or Blank. So Skipping Execution Of test case:  "+ testCaseName);
	    }
		
		if (driver == null) {

//			reporting.startTestCase("Pre requisite");
			PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");
			
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			try {
				config.load(fis);
				log.info("Config properties loaded");
			} catch (IOException e) {
				e.printStackTrace();
			}

			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			try {
				OR.load(fis);
				log.info("OR properties loaded");
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",(System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe"));
				driver = new FirefoxDriver();
				log.info("Firefox driver launched");
//				reporting.logIntoReport(logger,LogStatus.INFO,"","Firefox driver launched succesfully");
			} else if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",(System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe"));
				driver = new ChromeDriver();
				log.info("Chrome driver launched");
//				reporting.logIntoReport(logger,LogStatus.INFO,"","Chrome driver launched succesfully");
			} else if (config.getProperty("browser").equals("ie")) {
				System.setProperty("webdriver.ie.driver",(System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe"));
				driver = new InternetExplorerDriver();
				log.info("IE driver launched");
//				reporting.logIntoReport(logger,LogStatus.INFO,"","IE driver launched succesfully");
			}

			driver.get(config.getProperty("testsiteurl"));
			log.info("Navigated to URL " + config.getProperty("testsiteurl"));
//			reporting.logIntoReport(logger,LogStatus.INFO,"","Navigated to URL " + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implict.wait")),TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("explicit.wait")));

		}
		else
		{
			PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			try {
				config.load(fis);
				log.info("Config properties loaded");
			} catch (IOException e) {
				e.printStackTrace();
			}

			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			try {
				OR.load(fis);
				log.info("OR properties loaded");
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",(System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe"));
				driver = new FirefoxDriver();
				log.info("Firefox driver launched");
//				reporting.logIntoReport(logger,LogStatus.INFO,"","Firefox driver launched succesfully");
			} else if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",(System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe"));
				driver = new ChromeDriver();
				log.info("Chrome driver launched");
//				reporting.logIntoReport(logger,LogStatus.INFO,"","Chrome driver launched succesfully");
			} else if (config.getProperty("browser").equals("ie")) {
				System.setProperty("webdriver.ie.driver",(System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe"));
				driver = new InternetExplorerDriver();
				log.info("IE driver launched");
//				reporting.logIntoReport(logger,LogStatus.INFO,"","IE driver launched succesfully");
			}

			driver.get(config.getProperty("testsiteurl"));
			log.info("Navigated to URL " + config.getProperty("testsiteurl"));
//			reporting.logIntoReport(logger,LogStatus.INFO,"","Navigated to URL " + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implict.wait")),TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("explicit.wait")));
		}

	}
/*
	public static void click(String locatorKey) throws IOException {
		try {
			if (locatorKey.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(locatorKey))).click();
			} else if (locatorKey.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).click();
			} else if (locatorKey.endsWith(OR.getProperty("_ID"))) {
				driver.findElement(By.id(locatorKey)).click();
			}
			log.info("Clicking on an Element : " + locatorKey);
		} catch (Throwable t) {
			log.info("Error while clicking on element :" + locatorKey + " exception message is : " + t.getMessage());
			reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while clicking on element :" + locatorKey + " exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while clicking on element :" +locatorKey);
			return;
		}
	}
	*/
	public static void click(String locatorKey) throws IOException {
		try {
				driver.findElement(By.xpath(locatorKey)).click();

			log.info("Clicking on an Element : " + locatorKey);
		} catch (Throwable t) {
			log.info("Error while clicking on element :" + locatorKey + " exception message is : " + t.getMessage());
			reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while clicking on element :" + locatorKey + " exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while clicking on element :" +locatorKey);
			return;
		}
	}
	public static void click(WebElement locatorKey) throws IOException {
		try {
			 locatorKey.click();

			log.info("Clicking on an Element : " + locatorKey);
		} catch (Throwable t) {
			log.info("Error while clicking on element :" + locatorKey + " exception message is : " + t.getMessage());
			reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while clicking on element :" + locatorKey + " exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while clicking on element :" +locatorKey);
			return;
		}
	}	
	
/*	
	public static void clickjs(String locatorKey) throws IOException {
		WebElement cljs;
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;

		try {
			if (locatorKey.endsWith("_XPATH")) {
				cljs = driver.findElement(By.xpath(OR.getProperty(locatorKey)));
		        executor1.executeScript("arguments[0].click();", cljs);
			} else if (locatorKey.endsWith("_CSS")) {
				cljs = driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));
		        executor1.executeScript("arguments[0].click();", cljs);
			} else if (locatorKey.endsWith(OR.getProperty("_ID"))) {
				cljs = driver.findElement(By.id(OR.getProperty(locatorKey)));
		        executor1.executeScript("arguments[0].click();", cljs);
			}
			log.info("Clicking on an Element : " + locatorKey);
		} catch (Throwable t) {
			log.info("Error while clicking on element :" + locatorKey + " exception message is : " + t.getMessage());
			reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while clicking on element :" + locatorKey + " exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while clicking on element :" +locatorKey);
			return;
		}
	}
	*/
	public static void clickjs(String locatorKey) throws IOException {
		WebElement cljs;
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;

		try {
				cljs = driver.findElement(By.xpath(locatorKey));
		        executor1.executeScript("arguments[0].click();", cljs);
		        
			log.info("Clicking on an Element : " + locatorKey);
		} catch (Throwable t) {
			log.info("Error while clicking on element :" + locatorKey + " exception message is : " + t.getMessage());
			reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while clicking on element :" + locatorKey + " exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while clicking on element : " +locatorKey);
			return;
		}
	}
	
	public static void clickjs(WebElement locatorKey) throws IOException {
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		try {
		        executor1.executeScript("arguments[0].click();", locatorKey);
		        
			log.info("Clicking on an Element : " + locatorKey);
		} catch (Throwable t) {
			log.info("Error while clicking on element :" + locatorKey + " exception message is : " + t.getMessage());
			reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while clicking on element :" + locatorKey + " exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while clicking on element : " +locatorKey);
			return;
		}
	}
/*	public static void type(String locatorKey, String value) throws IOException {
		try {
			if (locatorKey.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(locatorKey))).sendKeys(value);
			} else if (locatorKey.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).sendKeys(value);
			} else if (locatorKey.endsWith(OR.getProperty("_ID"))) {
				driver.findElement(By.id(locatorKey)).sendKeys(value);
			}

			log.info("Typing in an Element : " + locatorKey + " entered the value as : " + value);
		} catch (Throwable t) {
			log.info("Error while type on element : " + locatorKey + " ,exception message is : " + t.getMessage());
			reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while type on element : " + locatorKey + " ,exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while type on element : " + locatorKey );
			return;
		}

	}
	*/
	public static void type(String locatorKey, String value) throws IOException {
		try {

				driver.findElement(By.xpath(locatorKey)).sendKeys(value);

			log.info("Typing in an Element : " + locatorKey + " entered the value as : " + value);
		} catch (Throwable t) {
			log.info("Error while type on element : " + locatorKey + " ,exception message is : " + t.getMessage());
			reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while type on element : " + locatorKey + " ,exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while type on element : " + locatorKey );
			return;
		}

	}

	public static void type(WebElement locatorKey, String value) throws IOException {
		try {

			locatorKey.sendKeys(value);

			log.info("Typing in an Element : " + locatorKey + " entered the value as : " + value);
		} catch (Throwable t) {
			log.info("Error while type on element : " + locatorKey + " ,exception message is : " + t.getMessage());
			reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while type on element : " + locatorKey + " ,exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while type on element : " + locatorKey );
			return;
		}

	}
/*	public static void select(String locatorKey, String value) throws IOException {
		try {
			if (locatorKey.endsWith("_XPATH")) {
				dropdown = driver.findElement(By.xpath(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_CSS")) {
				dropdown = driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith(OR.getProperty("_ID"))) {
				dropdown = driver.findElement(By.id(locatorKey));
			}
			Select select = new Select(dropdown);
			select.selectByVisibleText(value);

			log.info("Typing in an Element : " + locatorKey + " entered the value as : " + value);
		} catch (Throwable t) {
			log.info("Error while select on element : " + locatorKey + " ,exception message is : " + t.getMessage());
			reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while select on element : " + locatorKey + " ,exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while select on element : " + locatorKey );
			return;
		}
	}
*/
	public static void select(String locatorKey, String value) throws IOException {
		try {

			dropdown = driver.findElement(By.xpath(locatorKey));
			Select select = new Select(dropdown);
			select.selectByVisibleText(value);

			log.info("Typing in an Element : " + locatorKey + " entered the value as : " + value);
		} catch (Throwable t) {
			log.info("Error while select on element : " + locatorKey + " ,exception message is : " + t.getMessage());
			reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while select on element : " + locatorKey + " ,exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while select on element : " + locatorKey );
			return;
		}
	}
	
	
	public static void select(WebElement locatorKey, String value) throws IOException {
		try {

			dropdown = locatorKey;
			Select select = new Select(dropdown);
			select.selectByVisibleText(value);

			log.info("Typing in an Element : " + locatorKey + " entered the value as : " + value);
		} catch (Throwable t) {
			log.info("Error while select on element : " + locatorKey + " ,exception message is : " + t.getMessage());
			reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while select on element : " + locatorKey + " ,exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while select on element : " + locatorKey );
			return;
		}
	}
		
	
/*
	public static boolean isElementPresent(String locatorKey) throws IOException {
		try {
			if (locatorKey.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith(OR.getProperty("_ID"))) {
				driver.findElement(By.id(locatorKey));
			}

			log.info("Finding the Element : " + locatorKey);
			return true;
		} catch (Throwable t) {

			log.info("Error while finding an element : " + locatorKey + " exception message is : " + t.getMessage());
			reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while finding an element : " + locatorKey + " exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while isElementPresent on element : " + locatorKey );
			return false;

		}

	}

	
	public static boolean isElementPresent(String type,String locatorKey) throws IOException {
		try {
			if(type == "id"){
				driver.findElement(By.id(locatorKey));
			}else if (type == "xpath") driver.findElement(By.xpath(locatorKey));
			log.info("Finding the Element : " + locatorKey);
			return true;
		} catch (Throwable t) {
			log.info("Error while finding an element : " + locatorKey + " exception message is : " + t.getMessage());
			reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while finding an element : " + locatorKey + " exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while isElementPresent on element : " + locatorKey );
			return false;

		}

	}
		*/
	public static boolean isElementPresent(String locatorKey) throws IOException {
		try {
				driver.findElement(By.xpath(locatorKey));
			log.info("Finding the Element : " + locatorKey);
			return true;
		} catch (Throwable t) {

			log.info("Error while finding an element : " + locatorKey + " exception message is : " + t.getMessage());
			reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while finding an element : " + locatorKey + " exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while isElementPresent on element : " + locatorKey );
			return false;

		}

	}
	
	public static boolean isElementPresent(WebElement locatorKey) throws IOException {
		try {
			if (locatorKey.toString().contains("Proxy")){
				log.info("Error while finding an element : " + locatorKey);
	//			reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while finding an element : " + locatorKey );
				Assert.fail("Error while isElementPresent on element : " + locatorKey );
				return false;
				}else{
				log.info("Finding the Element : " + locatorKey.toString());
			} return true;
		//	locatorKey.isSelected();
		//	driver.findElement(locatorKey);
						
		} catch (Throwable t) {
			log.info("Error while finding an element : " + locatorKey + " exception message is : " + t.getMessage());
			reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while finding an element : " + locatorKey + " exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while isElementPresent on element : " + locatorKey );
			return false;

		}
		
	}
	/*
	 * To check whether element is enabled/selected
	 */
/*	public static boolean isElementSelected(String locatorKey) throws IOException {
		try {
			Boolean isSelected = false;
			if (locatorKey.endsWith("_XPATH")) {
				isSelected = driver.findElement(By.xpath(OR.getProperty(locatorKey))).isSelected();
			} else if (locatorKey.endsWith("_CSS")) {
				isSelected = driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).isSelected();
			} else if (locatorKey.endsWith(OR.getProperty("_ID"))) {
				isSelected = driver.findElement(By.id(locatorKey)).isSelected();
			}

			log.info("Finding the Element : " + locatorKey);
			return isSelected;
		} catch (Throwable t) {

			log.info("Error while finding an element : " + locatorKey + " exception message is : " + t.getMessage());
			reporting.logIntoReport(logger, LogStatus.FAIL, "", "<font color='Red'>Error while finding an element : "
					+ locatorKey + " exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while isElementPresent on element : " + locatorKey);
			return false;

		}
	}
*/
	public static boolean isElementSelected(String locatorKey) throws IOException {
		try {
			Boolean isSelected = false;

				isSelected = driver.findElement(By.xpath(locatorKey)).isSelected();

			log.info("Finding the Element : " + locatorKey);
			return isSelected;
		} catch (Throwable t) {

			log.info("Error while finding an element : " + locatorKey + " exception message is : " + t.getMessage());
			reporting.logIntoReport(logger, LogStatus.FAIL, "", "<font color='Red'>Error while finding an element : "
					+ locatorKey + " exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while isElementPresent on element : " + locatorKey);
			return false;

		}
	}

	public static boolean isElementSelected(WebElement locatorKey) throws IOException {
		try {
			Boolean isSelected = false;

				isSelected = locatorKey.isSelected();

			log.info("Finding the Element : " + locatorKey);
			return isSelected;
		} catch (Throwable t) {

			log.info("Error while finding an element : " + locatorKey + " exception message is : " + t.getMessage());
			reporting.logIntoReport(logger, LogStatus.FAIL, "", "<font color='Red'>Error while finding an element : "
					+ locatorKey + " exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while isElementPresent on element : " + locatorKey);
			return false;

		}
	}
/*	  public static boolean mandatory(String locatorKey) throws IOException
	  {
			try {
				if (locatorKey.endsWith("_XPATH")) {
					ele =driver.findElement(By.xpath(OR.getProperty(locatorKey)));
				} else if (locatorKey.endsWith("_CSS")) {
					ele = driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));
				} else if (locatorKey.endsWith(OR.getProperty("_ID"))) {
					ele = driver.findElement(By.id(locatorKey));
				}

				log.info("Finding the Element : " + locatorKey);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				return (js.executeScript("return window.getComputedStyle(arguments[0], ':after')." + "getPropertyValue('content');", ele).toString().contains("*"));
			}	catch (Throwable t) {

					log.info("Error while finding an element : " + locatorKey + " exception message is : " + t.getMessage());
					reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while finding an element : " + locatorKey + " exception message is : " + t.getLocalizedMessage());
					Assert.fail("Error while finding an element : " + locatorKey + " exception message is : " + t.getLocalizedMessage());
					return false;
			}
			
	 
	  }
*/
	  public static boolean mandatory(String locatorKey) throws IOException
	  {
			try {

					ele =driver.findElement(By.xpath(locatorKey));

				log.info("Finding the Element : " + locatorKey);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				return (js.executeScript("return window.getComputedStyle(arguments[0], ':after')." + "getPropertyValue('content');", ele).toString().contains("*"));
			}	catch (Throwable t) {

					log.info("Error while finding an element : " + locatorKey + " exception message is : " + t.getMessage());
					reporting.logIntoReport(logger,LogStatus.FAIL,"","<font color='Red'>Error while finding an element : " + locatorKey + " exception message is : " + t.getLocalizedMessage());
					Assert.fail("Error while finding an element : " + locatorKey + " exception message is : " + t.getLocalizedMessage());
					return false;
			}
			
	 
	  }
	  
  public static boolean mandatory(WebElement ele)
  {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return (js.executeScript("return window.getComputedStyle(arguments[0], ':after')." + "getPropertyValue('content');", ele).toString().contains("*"));
 
  }

	

	/**
	 * Function to get the WebElement for input string locator
	 * @param locatorKey
	 * @return WebElement
	 * @throws IOException
	 */
/*	public static WebElement getWeblement(String locatorKey) throws IOException {
		WebElement element = null;

		try {
			if (locatorKey.endsWith("_XPATH")) {
				element = driver.findElement(By.xpath(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_CSS")) {
				element = driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith(OR.getProperty("_ID"))) {
				element = driver.findElement(By.id(locatorKey));
			}

			
			return element;
		} catch (Throwable t) {

			log.info("Error while finding an element : " + locatorKey + " exception message is : " + t.getMessage());
			reporting.logIntoReport(logger, LogStatus.FAIL, "", "<font color='Red'>Error while finding an element : "
					+ locatorKey + " exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while finding an element : " + locatorKey + " exception message is : "
					+ t.getLocalizedMessage());
			return element;
		}
	}
*/
	public static WebElement getWeblement(String locatorKey) throws IOException {
		WebElement element = null;

		try {
				element = driver.findElement(By.xpath(locatorKey));
			
			return element;
		} catch (Throwable t) {

			log.info("Error while finding an element : " + locatorKey + " exception message is : " + t.getMessage());
			reporting.logIntoReport(logger, LogStatus.FAIL, "", "<font color='Red'>Error while finding an element : "
					+ locatorKey + " exception message is : " + t.getLocalizedMessage());
			Assert.fail("Error while finding an element : " + locatorKey + " exception message is : "
					+ t.getLocalizedMessage());
			return element;
		}
	}
	/**
	 * Method to make xpath based on variable passed
	 * ex. xpath string : "//span[text()=<token>]";
	 * 
	 * @param element: String value of xpath
	 * @param token:   String value of variable
	 * @return WebElement: WebElement xpath
	 */
	public WebElement getVariablexPath(String element, String token) {
		String start = "", end = "";
		if (element.contains("<") || element.contains(">")) {
			start = element.substring(0, element.indexOf("<"));
			end = element.substring(element.indexOf(">") + 1, element.length());
		}
		System.out.println("getVariablexPath - " + start + "'" + token + "'" + end);
		return driver.findElement(By.xpath(start + "'" + token + "'" + end));
	}

	
	public static boolean clickJS(WebElement element) {
		boolean clicked=false;
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			clicked=true;
			} catch (Exception e) {
			e.printStackTrace();
		}
		return clicked;
	}

	public boolean selectDropdownValue(String DropDownXpath, String value) {
		boolean clicked=false;
		try {
			WebElement dropdown=driver.findElement(By.xpath("DropDownXpath"));				
			dropdown.click();
			WaitStatementsLib.iWaitForSeconds(driver, 30);		
			List<WebElement> techData= driver.findElements(By.xpath("//li[@role='option']"));
			for (WebElement element : techData) {
				System.out.println(element.getText());			
				  if (element.getAttribute("aria-label").contentEquals(value)) 
				  { element.click();
				  	break; 
				  }			 
			}			
			//((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			clicked=true;
			} catch (Exception e) {
			e.printStackTrace();
		}
		return clicked;
	}
	
	public boolean selectDropdownValue(WebElement DropDownid, String value) {
		boolean clicked=false;
		try {			
			DropDownid.click();
			WaitStatementsLib.iWaitForSeconds(driver, 30);		
			List<WebElement> techData= driver.findElements(By.xpath("//li[@role='option']"));
			for (WebElement element : techData) {
				System.out.println(element.getText());			
				  if (element.getAttribute("aria-label").contentEquals(value)) 
				  { element.click();
				  	break; 
				  }			 
			}			
			//((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			clicked=true;
			} catch (Exception e) {
			e.printStackTrace();
		}
		return clicked;
	}
	
	@AfterClass
	public void tearDown() throws IOException {
		driver.close();
	//	log.info("Web browser closed");
	//	reporting.logIntoReport(logger,LogStatus.INFO,"","Web browser closed Successfully");
	//	reporting.endTestCase(logger);
	}

}
