package base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitStatementsLib {
	
	/***************************************************************/
	public static void iWait(int secs){
		try {
			Thread.sleep(secs*1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/***************************************************************/
	public static void iWaitForSeconds(WebDriver driver, int secs){
		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}
	
	/***************************************************************/
	
	public static void iWaitForMinutes(WebDriver driver, int mins){
		driver.manage().timeouts().implicitlyWait(mins, TimeUnit.MINUTES);
	}
	
	/***************************************************************/
	
	
	public static void eWaitForVisibility(WebDriver driver, int secs, WebElement ele){
		WebDriverWait wait=new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	/***************************************************************/
	
	
	public static void eWaitForClickable(WebDriver driver, int secs, WebElement ele){
		WebDriverWait wait=new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	/***************************************************************/
	
	
	public static void eWaitForTitle(WebDriver driver, int secs, String title){
		WebDriverWait wait=new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	/***************************************************************/
	
	
	
	public static void eWaitForStaleness(WebDriver driver, int secs, WebElement ele){
		WebDriverWait wait=new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.stalenessOf(ele));
	}
	
	
	/***************************************************************/
	

}
