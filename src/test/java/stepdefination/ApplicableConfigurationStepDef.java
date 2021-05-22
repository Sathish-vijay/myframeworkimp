package stepdefination;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.openqa.selenium.support.PageFactory;

import PageObjects.ApplicableConfiguration;
import PageObjects.Homepage;
import PageObjects.ProductFamily;
import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CommonFunctionUtil;
import utilities.ObjectUtil;
import utilities.TestUtil;

public class ApplicableConfigurationStepDef extends BaseTest {
	

	CommonFunctionUtil cf = new CommonFunctionUtil();
	Homepage hp = new Homepage();
	ApplicableConfiguration ac = new ApplicableConfiguration();
	LinkedHashMap<String, ArrayList<String>> acPageIconList = null;
	LinkedHashMap<String, String> acDataSet = null;
	String familycode, variantCode, variantName,  revDate, revNum;
    String RatingCode;
	
	
	public ApplicableConfigurationStepDef() throws Exception {
	ac= PageFactory.initElements(driver, ApplicableConfiguration.class);
	acPageIconList = excel.getDriverSheetData("ApplicableConfiguration");
	logger = reporting.startTestCase("ApplicableConfiguration");
	acDataSet = excel.getDriverSheetDataObj("ApplicableConfiguration");

	}


	@Then("ac verify user navigated to \"(.*?)\" page")
	public void ac_verify_user_navigated_to_page(String Pageheading) throws IOException {
		TestUtil.assertLabel(ac.applicable_configuration_Title,Pageheading);
	}
	
	@Then("click on Create button to create Applicable Configuration")
	public void click_on_Create_button_to_create_Applicable_Configuration() throws IOException {
	   click(ac.Btn_applicable_configuration_create);
	}
	
	@Then("ac verify there is \"(.*?)\" tab")
	public void ac_verify_there_is_tab(String tabs) throws IOException {
		TestUtil.assertLabel(ObjectUtil.getElementXpathOntabIds(tabs, "applicable_configuration_form_tabs"),tabs);
	    
	}
	
	@Then("ac verify there is Main Information heading")
	public void ac_verify_there_is_Main_Information_heading() throws IOException {
		TestUtil.assertLabel(ac.Heading_ac_Home_main,"Main Information");
	}
	
	@Then("ac verify the fileds present under Main Information")
	public void ac_verify_the_fileds_present_under_Main_Information() throws Exception {
	    ac.navigationCreatePageHometab();
	}
	
	@Then("ac verify the mandatory fileds present under Main Information")
	public void ac_verify_the_mandatory_fileds_present_under_Main_Information() throws Exception {
	    ac.ValidatemandatoryFieldUnderHomeTab();
	}
	
	
	
	@Then("ac enter values in fileds present under Main Information")
	public void ac_enter_values_in_fileds_present_under_Main_Information() throws Exception {
		familycode = acDataSet.get("familycode");
		variantCode = acDataSet.get("variantCode");
		variantName = acDataSet.get("variantName");
		revDate = acDataSet.get("revDate");
		revNum = acDataSet.get("revNum");
		
	    ac.EnterValuesUnderHomemain(familycode, variantCode, variantName, revDate, revNum);
	}

	@Then("ac verify there is Item Structure heading")
	public void ac_verify_there_is_Item_Structure_heading() throws IOException {
	//	TestUtil.assertLabel(ac.Heading_ac_Home_structure,"Item Structure (0)");
	}

	@Then("ac navigate to \"(.*?)\" tab")
	public void ac_navigate_to_tab(String tabs) throws IOException {
		TestUtil.assertLabel(ObjectUtil.getElementXpathOntabIds(tabs, "applicable_configuration_form_tabs"),tabs);
		  
	}

	@Then("ac verify there is \"(.*?)\" heading")
	public void ac_verify_there_is_heading(String heading) throws IOException {
		TestUtil.assertLabel(ac.Heading_ac_Airworthiness_Documents,heading);
	}

	@Then("ac verify the Airworthiness Documents table columns")
	public void ac_verify_the_Airworthiness_Documents_table_columns() throws Exception {
		ac.ValidateAirworthinessTabletTitle(acPageIconList);
	}

	@Then("click on Add button present under Airworthiness Documents")
	public void click_on_Add_button_present_under_Airworthiness_Documents() throws IOException {
	   click(ObjectUtil.getButtonXpath("Add"));
	}

	@Then("ac verify the fileds present under Document Matching")
	public void ac_verify_the_fileds_present_under_Document_Matching() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("ac verify the mandatory fileds present under Document Matching")
	public void ac_verify_the_mandatory_fileds_present_under_Document_Matching() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("ac enter values in fileds present under Document Matching")
	public void ac_enter_values_in_fileds_present_under_Document_Matching() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("ac verify there is {string} heading under Documents")
	public void ac_verify_there_is_heading_under_Documents(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("ac verify the Documents Matching table columns")
	public void ac_verify_the_Documents_Matching_table_columns() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("ac verify there is {string} heading under Evolution Interdependences")
	public void ac_verify_there_is_heading_under_Evolution_Interdependences(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

}
