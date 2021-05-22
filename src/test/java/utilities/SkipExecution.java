package utilities;

import base.BaseTest;

public class SkipExecution extends BaseTest {

	//static boolean flag;
	
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * if (!isSkipExecution("TC14")) {
	 * System.out.println("Runmode of the test case is NO"); } else {
	 * System.out.println("Runmode of the test case is YES"); } }
	 */
	 


	public static boolean isSkipExecution(String testCaseID) {
		boolean flag=true;
		int testCount = excel.getRowCount("TestSuite");

		for (int i=2; i<=testCount; i++) {
			if (excel.getCellData("TestSuite","TestCase", i).equals(testCaseID)) 
			{	
				String tcID =excel.getCellData("TestSuite","TestCase", i);
				String runMode= excel.getCellData("TestSuite", "RunMode", i);
				System.out.println(tcID +" | "+ runMode);
				if (runMode.equalsIgnoreCase("Yes")) {
					flag=true;
					break;
				}
				else if (runMode.equalsIgnoreCase("No")) {
					flag=false;
					break;
				}
				else {
					System.out.println(testCaseID + " is not available in Test Suite");
					
				}
			}
		}
		return flag;
	}
}
