package extentlisteners;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.TestUtil;

/**
 * 
 * utility to log steps in Extent report
 */
public class Report {
	String filepath;
	ExtentReports reports;
	String imgpath; 
	
	public Report(String filepath) {
		this.filepath = filepath + File.separator +"Report.html";
		this.imgpath = filepath + File.separator + "Screenshots" + File.separator;
		reports = new ExtentReports(this.filepath, false);
		reports.loadConfig(new File("extent-config.xml"));
		try {
			Files.copy(new File(System.getProperty("user.dir") + File.separator + "camera.png"), new File(filepath + File.separator + "camera.png"));
			Files.copy(new File(System.getProperty("user.dir") + File.separator + "logo.png"), new File(filepath + File.separator + "logo.png"));
			//FileUtils.copyFile(new File(System.getProperty("user.dir") + "camera.png"), new File(filepath + "camera.png"));
		} catch(Exception e) {
			System.err.println("unable to copy camera.png");
			e.printStackTrace();
		}
	}

	/** Starts test case
	 * @param test case name
	 * @return object of ExtentTest
	 */
	public ExtentTest startTestCase(String tc_name) {
		return reports.startTest(tc_name);
	}
	
	/**
	 * Method to log result into extent report
	 * @param logger
	 * @param status
	 * @param description
	 * @throws IOException
	 */
	public void logIntoReport(ExtentTest logger, LogStatus status,String stepName, String description ) throws IOException {
		

			String imgPath = TestUtil.capture(imgpath);
			
			if(!imgPath.equals(null)) {
				logger.log(status, stepName, description+ "<div align='right' style='float:right'><a  "+ NewWindowPopUpHTMLCode() + "  target='_blank' href="+imgPath +"><img src='camera.png' alt='Screenshot' height='42' width='42'></a></div>");
			} else
				logger.log(status, stepName, description+ "<div align='right' style='float:right'>Unable to take screenshot</div>");
			
//		}
		
		reports.flush();
	}
	


	/** Ends test case
	 * @param ExtentTest : Reference object
	 */
	public void endTestCase(ExtentTest logger) {
		reports.endTest(logger);
		reports.flush();
	}
	
	/**
	 * Method to open screenshot attached in the extent report in new pop up window
	 * @return String : Javascript code in String 
	 */
	public String NewWindowPopUpHTMLCode() {
		return "onclick = \"window.open(this.href,'newwindow', 'width= 1500 ,height= 800');return false;\"";
	
	}


}
