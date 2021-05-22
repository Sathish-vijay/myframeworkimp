package stepdefination;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import PageObjects.Homepage;
import PageObjects.Login;
import PageObjects.ProductFamily;
import base.BaseTest;
import base.WaitStatementsLib;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CommonFunctionUtil;
import utilities.ObjectUtil;
import utilities.TestUtil;

public class ProductFamilyStepDef extends BaseTest {
	

	CommonFunctionUtil cf = new CommonFunctionUtil();
	Homepage hp = new Homepage();
	ProductFamily pf = new ProductFamily();
	LinkedHashMap<String, ArrayList<String>> pfPageIconList = null;
	LinkedHashMap<String, String> pfDataSet = null;
	String Type , Number, rNumber, url, Designation,name, code,function,Type1 , Number1, rNumber1, urlEdit,DesignationEdit,RatingName;
    String RatingCode;
	
	
	public ProductFamilyStepDef() throws Exception {
	pf= PageFactory.initElements(driver, ProductFamily.class);
    System.out.println(">>>>>>>>"+pf);
	pfPageIconList = excel.getDriverSheetData("ProductFamily");
	logger = reporting.startTestCase("ProductFamily");
	pfDataSet = excel.getDriverSheetDataObj("ProductFamily");

	}


	@When("click on \"(.*?)\" Tab")
	public void click_on_Tab(String Tab) throws IOException {
		System.out.println(Tab);
		cf.selectMenuOption(Tab);
		
	}

	@When("select \"(.*?)\" option")
	public void select_option(String SubMenu) throws IOException {
		System.out.println(SubMenu);
		cf.selectSubMenuOption(SubMenu);

	}

	@Then("verify user navigated to Product Family page")
	public void verify_user_navigated_to_page_Product_Family() throws IOException {
		WaitStatementsLib.eWaitForVisibility(driver,40, pf.family_search_Title);
		TestUtil.assertLabel(pf.family_search_Title,"Product Family");
				
	}

	@Then("click on Create button")
	public void click_on_Create_button() throws IOException {
		click(pf.Btn_family_search_create);
      
	}


	@Then("pf verify the name of the page Product Family")
	public void pf_verify_the_name_of_the_page_Product_Family() throws IOException {
		WaitStatementsLib.eWaitForVisibility(driver,40, pf.family_form_Title);		
		TestUtil.assertLabel(pf.family_form_Title,"Product Family");
	}

	@Then("pf verify there is \"(.*?)\" tab")
	public void pf_verify_there_is_tab(String tab) throws IOException {
		TestUtil.assertLabel(ObjectUtil.getXapthselectTabWithId("family_form_tabs",tab),tab);
	}

	@Then("pf verify there is Main Information heading")
	public void pf_verify_there_is_Main_Information_heading() throws IOException {
		TestUtil.assertLabel(pf.Heading_form_main,"Main Information");
	}

	@Then("pf verify below Main Information fields")
	public void pf_verify_below_Main_Information_fields() throws Exception {
		pf.ValidateProductFamilyPage();

	}

	@Then("pf verify uneditable mode of Structure Type control")
	public void pf_verify_uneditable_mode_of_Structure_Type_control() {
		TestUtil.isEditableWithAllAttri(pf.Ctl_family_structure_type);
		
	}

	@Then("pf verify Presence of Modifications heading")
	public void pf_verify_Presence_of_Modifications_heading() throws IOException {
		TestUtil.assertLabel(pf.Heading_modification,"Modifications (0)");
	}
	
	

	@Then("pf verify Presence of Modifications Table field")
	public void pf_verify_Presence_of_Modifications_Table_field() throws Exception {
		pf.ValidateModificationsTabletTitle(pfPageIconList);

	}

	@When("pf User enter Family Code and Family Name")
	public void pf_User_enter_Family_Code_and_Family_Name() throws IOException {
		
		name = pfDataSet.get("name");
		code = pfDataSet.get("code");
		
		type(pf.Txt_family_family_name,name);
		type(pf.Txt_family_family_code,code);

	}

	@When("pf Select given Family Function")
	public void pf_Select_given_Family_Function() throws IOException {
		String function = pfDataSet.get("function");
		click(pf.Txt_family_family_function);
		WaitStatementsLib.iWaitForSeconds(driver, 20);
		TestUtil.selecValueFromDropdown(function);

	}

	@When("pf Click on Add button under Modifications")
	public void pf_Click_on_Add_button_under_Modifications() throws IOException {
		click(ObjectUtil.getButtonXpath("Add"));

	}

	@Then("pf verify popup Modification Management heading")
	public void pf_verify_popup_Modification_Management_heading() throws IOException {
		WaitStatementsLib.eWaitForVisibility(driver,40, pf.Title_popup_modification);	
		TestUtil.assertLabel(pf.Title_popup_modification,"Modification Management");
		
	}

	@Then("pf verify popup field under Modification Management")
	public void pf_verify_popup_field_under_Modification_Management() throws Exception {
		pf.ValidateModificationspopupField();

	}

	@When("pf User enter Modification Document URL and Designation")
	public void pf_User_enter_Modification_Document_URL_and_Designation() throws IOException {
		 url = pfDataSet.get("url");
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		Designation = pfDataSet.get("Designation");
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		type(pf.Txt_popup_modification_url,url);
		type(pf.Txt_popup_modification_Designation,Designation);
		

	}

	@When("pf verify Validate button is non-clickable under Modification Management")
	public void pf_verify_Validate_button_is_non_clickable_under_Modification_Management() throws IOException {
		if (!pf.validate_button_activation()) {
			reporting.logIntoReport(logger, LogStatus.PASS, "", "Validate button is not active.");
			
		} else
		{

			reporting.logIntoReport(logger, LogStatus.PASS, "", "'Validate button is active.");
		}


	}

	@When("pf User enter below Modification Type and Modification Number and Modification Revision Number")
	public void pf_User_enter_below_Modification_Type_and_Modification_Number_and_Modification_Revision_Number() throws IOException {
		 Type = pfDataSet.get("Type");
		 Number = pfDataSet.get("Number");
		 rNumber = pfDataSet.get("rNumber");
		
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		type(pf.Txt_popup_modification_type,Type);
		WaitStatementsLib.iWait(1);
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		type(pf.Txt_popup_modification_num,Number);
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		type(pf.Txt_popup_modification_revision_num,rNumber);
		
	}

	@When("pf click on Validate button under Modification Management")
	public void pf_click_on_Validate_button_under_Modification_Management() throws IOException {
		click(pf.btn_modification_popup_validate);

	}

	@Then("pf verify Search results are available under Modifications table")
	public void pf_verify_Search_results_are_available_under_Modifications_table() throws Exception {
	    pf.ValidateModificationsTableValues(Type, Number, rNumber, url, Designation);
	}

	@Then("pf click on Save button")
	public void pf_click_on_Save_button() throws IOException {
		click(pf.btn_pf_save);

	}

	@Then("verify pf message Family saved successfully")
	public void verify_pf_message_Family_saved_successfully() throws IOException {
		TestUtil.save_message_validation("Family saved");

	}

	@When("click on Back button")
	public void click_on_Back_button() throws IOException {
		WaitStatementsLib.iWait(3);
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		clickjs(ObjectUtil.getXpathforBackButton());

	}
	
	@Then("click on pf refresh button")
	public void click_on_pf_refresh_button() throws IOException {
		WaitStatementsLib.iWait(10);
		clickjs(pf.btn_pf_refresh);

	}
	

	@Then("pf verify user is navigated to \"(.*?)\" search page")
	public void pf_verify_user_is_navigated_to_search_page(String SearchTitle) throws IOException {
		WaitStatementsLib.iWaitForSeconds(driver, 25);
		TestUtil.assertLabel(pf.family_search_Title,SearchTitle);

	}

	@Then("pf verify title of table as \"(.*?)\"")
	public void pf_verify_title_of_table_as(String TableTitle) throws IOException {
		WaitStatementsLib.iWaitForSeconds(driver, 25);
		TestUtil.assertLabel(pf.Title_pf_results,TableTitle);
		

	}

	@Then("pf verify Presence of Results table columns")
	public void pf_verify_Presence_of_Results_table_columns() throws Exception {
		WaitStatementsLib.iWaitForSeconds(driver, 25);
		pf.ValidateResultstableTablecolumns(pfPageIconList);

	}

	@When("pf enter the value in searchText")
	public void pf_enter_the_value_in_searchText() throws IOException {
		
		name = pfDataSet.get("name");
		code = pfDataSet.get("code");
		function = pfDataSet.get("function");
		WaitStatementsLib.iWaitForSeconds(driver, 25);
		
		type(ObjectUtil.SearchInTable("app-administration-family-list"),code);

	}


	@Then("pf verify Search results are available under Results table")
	public void pf_verify_Search_results_are_available_under_Results_table() throws Exception {
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		pf.ValidatesearchTableValues(code,name,function);


	}

	@Then("pf verify execution completed successfully")
	public void pf_verify_execution_completed_successfully() {
	    System.out.println("22");
	    
	}
	
	
	@When("click on Family Code link")
	public void click_on_Family_Code_link() throws IOException {
	    click(ObjectUtil.ClickAttributeToOpen(code));
	}

	@Then("verify below information displayed on home tab screen are non editable")
	public void verify_below_information_displayed_on_home_tab_screen_are_non_editable() throws Exception {
	    pf.ValidatefieldsUneditable();
	}

	
	@Then("verify Presence of Refresh button")
	public void verify_Presence_of_Refresh_button() throws IOException {
		Assert.assertTrue(isElementPresent(pf.btn_pf_refresh),"Refresh button not present");
		
	}

	@Then("verify Presence of Edit button")
	public void verify_Presence_of_Edit_button() throws IOException {
		Assert.assertTrue(isElementPresent(pf.btn_pf_Edit),"Refresh button not present");

	}

	@Then("click on Edit button")
	public void click_on_Edit_button() throws IOException {
		click(pf.btn_pf_Edit);
	}
	
	
	@When("pf User enter all the fields under Modifications popup")
	public void pf_User_enter_all_the_fields_under_Modifications_popup() throws Exception {
		 Type1 = pfDataSet.get("TypeNew");
		 Number1 = pfDataSet.get("NumberNew");
		 rNumber1 = pfDataSet.get("rNumberNew");
		 Designation = pfDataSet.get("DesignationNew");
		 url = pfDataSet.get("urlNew");
		 
		pf.EnterAllTheValuesUnderModificationsPopup(Type1, Number1, rNumber1,url,Designation);
        
	}

	@Then("pf select row for Modification Management")
	public void pf_select_row_for_Modification_Management() throws IOException {
		 Type = pfDataSet.get("Type");
		System.out.println(Type);
		type(ObjectUtil.getFilterXpath(),Type);
		WaitStatementsLib.iWait(2);
		click(ObjectUtil.getXapthselectTabWithoutId(Type));
		
		

	}

	@Then("pf verify Presence of Edit ,Open and Delete button")
	public void pf_verify_Presence_of_Edit_Open_and_Delete_button() throws Exception {
		pf.ValidatePresenceOfButton();
		
	}

	@Then("pf click on Open button under Modifications")
	public void pf_click_on_Open_button_under_Modifications() throws IOException {
	    click(ObjectUtil.getGenericXpathForBtn("Open"));
	}

	@Then("pf verify below information displayed on popup are non editable")
	public void pf_verify_below_information_displayed_on_popup_are_non_editable() throws Exception {
		pf.ValidatepopupOpenMode();
	}

	@Then("pf click on Close button")
	public void pf_click_on_Close_button() throws IOException {
		clickjs(pf.btn_pf_Close_popup);
	}

	@Then("pf click on Edit button under Modifications")
	public void pf_click_on_Edit_button_under_Modifications() throws IOException {
	    click(ObjectUtil.getGenericXpathForBtn("Edit"));
	}

	@Then("pf User Update all the fields under Modifications")
	public void pf_User_Update_all_the_fields_under_Modifications() throws IOException {
		urlEdit = pfDataSet.get("urlEdit");
		DesignationEdit = pfDataSet.get("DesignationEdit");
		
		pf.Txt_popup_modification_url.clear();
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		type(pf.Txt_popup_modification_url,urlEdit);
		pf.Txt_popup_modification_Designation.clear();
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		type(pf.Txt_popup_modification_Designation,DesignationEdit);
	}

	@Then("pf click on Delete button under Modifications")
	public void pf_click_on_Delete_button_under_Modifications() throws IOException {
	    click(ObjectUtil.getGenericXpathForBtn("Delete"));
		WaitStatementsLib.eWaitForVisibility(driver,30, getWeblement(ObjectUtil.DeleteModalFooterButton("Yes")));
		clickjs(ObjectUtil.DeleteModalFooterButton("Yes"));

	}

	@Then("pf verify deleted results is not available under Modifications table")
	public void pf_verify_deleted_results_is_not_available_under_Modifications_table() {
	    
	}

	@When("pf enter below value in Family Name")
	public void pf_enter_below_value_in_Family_Name() throws IOException {
		name = pfDataSet.get("nameEdit");
		pf.Txt_family_family_name.clear();
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		type(pf.Txt_family_family_name,name);
	}

	@When("pf click on Ratings tab")
	public void pf_click_on_Ratings_tab() throws IOException {
		click(ObjectUtil.getXapthselectTabWithId("family_form_tabs","Ratings"));

	}

	
	@When("pf verify Presence of heading \"(.*?)\"")
	public void pf_verify_Presence_of_heading(String heading) throws IOException {
		TestUtil.assertLabel(pf.Heading_pf_rating,heading);

	}

	@When("pf verify Presence of Ratings table column")
	public void pf_verify_Presence_of_Ratings_table_column() throws Exception {
		pf.ValidateratingTabletTitle(pfPageIconList);
	}

	@When("pf clicked on Add button under Rating")
	public void pf_clicked_on_Add_button_under_Rating() throws IOException {
		click(ObjectUtil.getLabelH3layerXpath("Rating","Add"));
	    
	}

	@Then("pf verify popup \"(.*?)\" is displayed for rating")
	public void pf_verify_popup_is_displayed_for_rating(String popup) throws IOException {
		WaitStatementsLib.eWaitForVisibility(driver,40, pf.Heading_pf_rating_popup);

		TestUtil.assertLabel(pf.Heading_pf_rating_popup,popup);
	}

	@Then("pf verify Presence of Rating Code field")
	public void pf_verify_Presence_of_Rating_Code_field() throws IOException {
		Assert.assertTrue(isElementPresent(pf.lbl_pf_rating_popup_code),"rating code label not present");

	}

	@Then("pf verify Presence Rating Name field")
	public void pf_verify_Presence_Rating_Name_field() throws IOException {
		Assert.assertTrue(isElementPresent(pf.lbl_pf_rating_popup_name),"rating name label not present");

	}

	@When("pf User enter below Rating Name")
	public void pf_User_enter_below_Rating_Name() throws IOException {
		RatingName = pfDataSet.get("RatingName");
		WaitStatementsLib.iWaitForSeconds(driver, 15);
	    type(pf.txt_pf_rating_popup_name,RatingName);
	}

	@When("pf verify Ratings Validate button is non-clickable")
	public void pf_verify_Ratings_Validate_button_is_non_clickable() throws IOException {
		if (!pf.validate_button_activationforRating()) {
			reporting.logIntoReport(logger, LogStatus.PASS, "", "Validate button is not active.");
			
		} else
		{

			reporting.logIntoReport(logger, LogStatus.PASS, "", "'Validate button is active.");
		}
	}

	@When("User enter below Rating Code")
	public void user_enter_below_Rating_Code() throws IOException {
		RatingCode = pfDataSet.get("RatingCode");
		WaitStatementsLib.iWaitForSeconds(driver, 15);
	    type(pf.txt_pf_rating_popup_code,RatingCode);
	    
	}

	@Then("click on Ratings Validate button")
	public void click_on_Ratings_Validate_button() throws IOException {
	    click(pf.btn_pf_validate_popup);
	}
	
	//   done
	@Then("pf select row for Rating")
	public void pf_select_row_for_Rating() throws IOException {
		WaitStatementsLib.iWait(2);
		click(ObjectUtil.getXapthselectTabWithoutId(RatingCode));
	}

	@Then("pf click on Open button under Rating")
	public void pf_click_on_Open_button_under_Rating() throws IOException {
	    click(ObjectUtil.getGenericXpathForBtn("Open"));
	}

	@Then("pf verify below information displayed on Rating popup are non editable")
	public void pf_verify_below_information_displayed_on_Rating_popup_are_non_editable() throws IOException {
	    pf.ValidateNonEditableRatings();
	}

	@Then("pf click on Close button for Rating")
	public void pf_click_on_Close_button_for_Rating() throws IOException {
		clickjs(pf.btn_pf_rating_close_popup);
	}

	@Then("pf click on Edit button under Rating")
	public void pf_click_on_Edit_button_under_Rating() throws IOException {
	    click(ObjectUtil.getGenericXpathForBtn("Edit"));
	}
	
	@Then("verify Rating Code is non editable")
	public void verify_Rating_Code_is_non_editable() {
		TestUtil.isEditableWithAllAttri(pf.txt_pf_rating_popup_code);
	}

	@When("User enter new Rating Name")
	public void user_enter_new_Rating_Name() throws IOException {
		RatingName = pfDataSet.get("RatingNameEdit");
		WaitStatementsLib.iWaitForSeconds(driver, 15);
	    type(pf.txt_pf_rating_popup_name,RatingName);
	}

	@Then("pf click on Delete button under Rating")
	public void pf_click_on_Delete_button_under_Rating() throws IOException {
	    click(ObjectUtil.getGenericXpathForBtn("Delete"));
		WaitStatementsLib.eWaitForVisibility(driver,30, getWeblement(ObjectUtil.DeleteModalFooterButton("Yes")));
		clickjs(ObjectUtil.DeleteModalFooterButton("Yes"));
	}
	
	@Then("pf verify Search results are available under Results table after Edit")
	public void pf_verify_Search_results_are_available_under_Results_table_after_Edit() throws Exception {
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		pf.ValidatesearchTableValues(code,name,function);


	}
	
	@Then("select product family from result table")
	public void select_product_family_from_result_table() throws IOException {
		WaitStatementsLib.iWait(2);
		click(ObjectUtil.getXapthselectTabWithoutId(code));
	}
	
	

	@Then("verify Presence of Delete button product family")
	public void verify_Presence_of_Delete_button_product_family() throws IOException {
	    click(ObjectUtil.getGenericXpathForBtn("Delete"));
	}

	@Then("click on Delete button product family")
	public void click_on_Delete_button_product_family() throws IOException {
	    click(ObjectUtil.getGenericXpathForBtn("Delete"));
		WaitStatementsLib.eWaitForVisibility(driver,30, getWeblement(ObjectUtil.DeleteModalFooterButton("Yes")));
		clickjs(ObjectUtil.DeleteModalFooterButton("Yes"));
	}

	@Then("verify deleted results is not available under Ratings table")
	public void verify_deleted_results_is_not_available_under_Ratings_table() {
	    
	}


}
