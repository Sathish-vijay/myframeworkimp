package listeners;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utilities.TestUtil;

public class Customlisteners implements ITestListener{
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure() {

			
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub		
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {

	
	}

	public void onTestFailure(ITestResult result) {
		
		// TODO Auto-generated method stub
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        
        try {
            TestUtil.captureScreenshot();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

 

        Reporter.log("<a target=\"_blank\" href=\""+TestUtil.destFile+"\">Screenshot link</a>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href=\""+TestUtil.destFile+"\"><img src=\""+TestUtil.destFile+"\" height=200 width=200></a>");
		
	}

}
