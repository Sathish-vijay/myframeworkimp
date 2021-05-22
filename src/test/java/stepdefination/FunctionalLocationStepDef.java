package stepdefination;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import PageObjects.FunctionalLocation;
import PageObjects.Homepage;
import base.BaseTest;
import base.WaitStatementsLib;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CommonFunctionUtil;
import utilities.ObjectUtil;
import utilities.TestUtil;

public class FunctionalLocationStepDef extends BaseTest {
	

	CommonFunctionUtil cf = new CommonFunctionUtil();
	Homepage hp = new Homepage();
	FunctionalLocation fl = new FunctionalLocation();
	LinkedHashMap<String, ArrayList<String>> flPageIconList = null;
	LinkedHashMap<String, String> flDataSet = null;
	String sModel, sfamilyVariant,FamilyVariant,FamilyVariantrow,IsinMEL, Ordernumber;
    String FLCode, FLDescription, FLFunction, NominalQuantity, RequiredQuantity,docPath,docDescription;
	
	
	public FunctionalLocationStepDef() throws Exception {
	fl = PageFactory.initElements(driver, FunctionalLocation.class);
	flPageIconList = excel.getDriverSheetData("FunctionalLocation");
	logger = reporting.startTestCase("FunctionalLocation");
	flDataSet = excel.getDriverSheetDataObj("FunctionalLocation");

	}
	
	
	@When("click on Engineering Data Tab")
	public void click_on_Engineering_Data_Tab() throws IOException {
		WaitStatementsLib.iWaitForSeconds(driver, 30);
		Assert.assertTrue(isElementPresent(ObjectUtil.getButtonXpathTagBtn("Engineering Data")),"Engineering Data tab not present");
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		click(ObjectUtil.getButtonXpathTagBtn("Engineering Data"));
	}
	
	@Then("verify user navigated to Functional Location page")
	public void verify_user_navigated_to_Functional_Location_page() throws IOException {
		WaitStatementsLib.eWaitForVisibility(driver,40, fl.Flocation_search_Title);
		TestUtil.assertLabel(fl.Flocation_search_Title,"Functional Location");
	    
	}

	@Then("click on Create button to create Functional Location")
	public void click_on_Create_button_to_create_Functional_Location() throws IOException {
	    click(fl.Btn_Flocation_search_create);
	}

	@Then("fl verify the name of the page Functional Location")
	public void fl_verify_the_name_of_the_page_Functional_Location() throws IOException {
		WaitStatementsLib.eWaitForVisibility(driver,40, fl.Flocation_form_Title);
		TestUtil.assertLabel(fl.Flocation_form_Title,"Functional Location");
	}

	@Then("fl verify there is \"(.*?)\" tab")
	public void fl_verify_there_is_tab(String tab) throws IOException {
		TestUtil.assertLabel(ObjectUtil.getXapthselectTabWithId("functional_location_form_tabs",tab),tab);
	}

	@Then("fl verify there is \"(.*?)\" heading under Home")
	public void fl_verify_there_is_heading_under_Home(String heading) throws IOException {
		TestUtil.assertLabel(fl.Heading_Flocation_main,heading);
	}

	@Then("fl verify below Main Information fields")
	public void fl_verify_below_Main_Information_fields() throws Exception {
	    fl.ValidateMainInformationfields();
	}

	@Then("fl verify there is \"(.*?)\" heading under Items")
	public void fl_verify_there_is_heading_under_Items(String heading) throws IOException {
		TestUtil.assertLabel(fl.Heading_Flocation_form_items,heading);
	}

	@Then("fl verify below Items table column fields")
	public void fl_verify_below_Items_table_column_fields() throws Exception {
	    fl.ValidateItemTabletTitle(flPageIconList);
	}
	
	@Then("fl Click on Add button under Items")
	public void fl_Click_on_Add_button_under_Items() throws IOException {
		clickjs(ObjectUtil.getSelectButtonXpathUsingId("functional_location_form_fvs_tbl", "Add"));
	}

	@Then("click on search button under Search Item popup")
	public void click_on_search_button_under_Search_Item_popup() throws Exception {
		WaitStatementsLib.iWaitForSeconds(driver, 45);
		FamilyVariant = flDataSet.get("FamilyVariant");
		fl.SelectvalueSearch_Item_popup(FamilyVariant);

	}

	@Then("fl select value from Results table")
	public void fl_select_value_from_Results_table() throws Exception {
		WaitStatementsLib.iWaitForSeconds(driver, 35);
		FamilyVariant = flDataSet.get("FamilyVariant");
		fl.Selectvalueselect_value_from_Results_table(FamilyVariant);

	}

	@Then("fl verify there is \"(.*?)\" heading under Structure")
	public void fl_verify_there_is_heading_under_Structure(String heading) throws IOException {
		TestUtil.assertLabel(fl.Heading_Flocation_form_structure,heading);
	}
	
	@Then("fl verify below Structure table column fields")
	public void fl_verify_below_Structure_table_column_fields() throws Exception {
	    fl.ValidatestructureTabletTitle(flPageIconList);
	}
	@Then("fl Enter value in below Main Information fields")
	public void fl_Enter_value_in_below_Main_Information_fields() throws Exception {
		FLCode = flDataSet.get("FLCode");
		FLDescription = flDataSet.get("FLDescription");
		FLFunction = flDataSet.get("FLFunction");
		NominalQuantity = flDataSet.get("NominalQuantity");
		RequiredQuantity = flDataSet.get("RequiredQuantity");

	    fl.Enter_value_MainInformation_field(FLCode, FLDescription, FLFunction, NominalQuantity, RequiredQuantity);
	}

	@Then("fl click on \"(.*?)\" tab")
	public void fl_click_on_tab(String tab) throws IOException {
		clickjs(ObjectUtil.getXapthselectTabWithId("functional_location_form_tabs",tab));
	}

	@Then("fl verify there is \"(.*?)\" heading under Documentation")
	public void fl_verify_there_is_heading_under_Documentation(String heading) throws IOException {
		WaitStatementsLib.eWaitForVisibility(driver,40, fl.Heading_Flocation_form_documentation);
		TestUtil.assertLabel(fl.Heading_Flocation_form_documentation,heading);
	}

	@Then("fl verify the below Documentation fields")
	public void fl_verify_the_below_Documentation_fields() throws Exception {
	    fl.ValidateDocumentationfields();
	}

	@Then("fl click on upload button and select document")
	public void fl_click_on_upload_button_and_select_document() throws IOException {
		docPath = flDataSet.get("docPath");
		System.out.println(docPath);
		//input[contains(@accept,'defined')]
//		type(fl.btn_Flocation_form_upload,docPath);
		type("//input[contains(@accept,'undefined')]",docPath);

		
		
	}

	@Then("fl Add Description for document")
	public void fl_Add_Description_for_document() throws IOException {
		docDescription = flDataSet.get("docDescription");
	    type(fl.ctrl_Flocation_form_doc_description,docDescription);
	}

	@Then("fl click on Save button")
	public void fl_click_on_Save_button() throws IOException {
	    click(fl.btn_Flocation_save);
	}

	@Then("fl verify message Family saved successfully")
	public void fl_verify_message_Family_saved_successfully() throws IOException {
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		TestUtil.save_message_validation("Saved Successfully");
	}

	@Then("fl verify below information displayed on are non editable")
	public void fl_verify_below_information_displayed_on_are_non_editable() throws Exception {
	    fl.vefifynoneditableOpenMode();
	}

	@Then("fl click on Edit button")
	public void fl_click_on_Edit_button() throws IOException {
	    click(fl.btn_Flocation_edit);
	}

	@Then("fl update value in below Main Information fields")
	public void fl_update_value_in_below_Main_Information_fields() throws Exception {

		FLDescription = flDataSet.get("FLDescriptionEdit");
		FLFunction = flDataSet.get("FLFunctionEdit");
		NominalQuantity = flDataSet.get("NominalQuantityEdit");
		RequiredQuantity = flDataSet.get("RequiredQuantityEdit");

	    fl.update_value_MainInformation_field(FLDescription, FLFunction, NominalQuantity, RequiredQuantity);  
	}

	@Then("fl select a row Items")
	public void fl_select_a_row_Items() {
		WaitStatementsLib.iWait(1);
	       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fl.Heading_Flocation_form_items);
		WaitStatementsLib.iWaitForSeconds(driver, 20);

		FamilyVariantrow = flDataSet.get("FamilyVariantrow");
	    TestUtil.SearchTabelSearchAndClickValue("functional_location_form_fvs_tbl", FamilyVariantrow);
	}

	@Then("fl verify buttons displayed under Items")
	public void fl_verify_buttons_displayed_under_Items() throws Exception {
	    fl.ValidatePresenceOfButtonforItems();
	}

	@Then("fl click on open button under Items")
	public void fl_click_on_open_button_under_Items() throws IOException {
	    clickjs(fl.btn_Flocation_open_family_varient);
	}

	@Then("fl verify popup Family-Variant Management in open mode")
	public void fl_verify_popup_Family_Variant_Management_in_open_mode() throws Exception {
	    fl.ValidateFamilyVariantManagementforItems();
	}

	@Then("fl click on close button to close popup Family-Variant")
	public void fl_click_on_close_button_to_close_popup_Family_Variant() throws IOException {
	    click(fl.btn_family_variant_popup_close);
	}

	@Then("fl click on Edit button under Items")
	public void fl_click_on_Edit_button_under_Items() throws IOException {
	    clickjs(fl.btn_Flocation_edit_family_varient);
	}

	@Then("fl select a row Items again")
	public void fl_select_a_row_Items_again() {
		WaitStatementsLib.iWait(1);
	       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fl.Heading_Flocation_form_items);
		WaitStatementsLib.iWaitForSeconds(driver, 20);

		FamilyVariantrow = flDataSet.get("FamilyVariantrowedit");
	    TestUtil.SearchTabelSearchAndClickValue("functional_location_form_fvs_tbl", FamilyVariantrow);
	}
	
	@Then("fl click on Delete button under Items")
	public void fl_click_on_Delete_button_under_Items() throws IOException {
	    clickjs(fl.btn_Flocation_delete_family_varient);
		WaitStatementsLib.eWaitForVisibility(driver,30, getWeblement(ObjectUtil.DeleteModalFooterButton("Yes")));
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		clickjs(ObjectUtil.DeleteModalFooterButton("Yes"));
	}
	
	@Then("click on search button under Search Item popup for new item")
	public void click_on_search_button_under_Search_Item_popup_for_new_item() throws Exception {
		WaitStatementsLib.iWaitForSeconds(driver, 45);
		FamilyVariant = flDataSet.get("FamilyVariantnew");
		fl.SelectvalueSearch_Item_popup(FamilyVariant);

	}

	@Then("fl select value from Results table for new item")
	public void fl_select_value_from_Results_table_for_new_item() throws Exception {
		WaitStatementsLib.iWaitForSeconds(driver, 35);
		FamilyVariant = flDataSet.get("FamilyVnewResult");
		fl.Selectvalueselect_value_from_Results_table(FamilyVariant);

	}
	
	@Then("click on search button under Search Item popup again")
	public void click_on_search_button_under_Search_Item_popup_again() throws Exception {
		WaitStatementsLib.iWaitForSeconds(driver, 45);
		FamilyVariant = flDataSet.get("FamilyVariantEdit");
		fl.SelectvalueSearch_Item_popup(FamilyVariant);
	}
	
	@Then("fl select a row from Structure")
	public void fl_select_a_row_from_Structure() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("fl verify buttons displayed under Structure")
	public void fl_verify_buttons_displayed_under_Structure() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
	@Then("fl select value from Results table again")
	public void fl_select_value_from_Results_table_again() throws Exception {
		WaitStatementsLib.iWaitForSeconds(driver, 35);
		FamilyVariant = flDataSet.get("FamilyVariantEdit");
		fl.Selectvalueselect_value_from_Results_table(FamilyVariant);
	}
	
	@Then("fl click on upload button and select another document")
	public void fl_click_on_upload_button_and_select_another_document() throws IOException {
		WaitStatementsLib.iWaitForSeconds(driver, 35);
		docPath = flDataSet.get("docPath");
		type(fl.btn_Flocation_form_upload,docPath);
	}
	
	@Then("fl verify display of delete and Download button")
	public void fl_verify_display_of_delete_and_Download_button() throws IOException {
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		Assert.assertTrue(isElementPresent(fl.btn_fl_documentation_delete),"button delete not present");
		Assert.assertTrue(isElementPresent(fl.btn_fl_form_download),"button download Code label not present");

	}

	@Then("fl click on download button to download the document")
	public void fl_click_on_download_button_to_download_the_document() throws IOException {
	    click(fl.btn_fl_form_download);
	}

	@Then("fl click on delete button to delete the document")
	public void fl_click_on_delete_button_to_delete_the_document() throws IOException {
	    click(fl.btn_fl_documentation_delete);
		WaitStatementsLib.eWaitForVisibility(driver,30, getWeblement(ObjectUtil.DeleteModalFooterButton("Yes")));
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		clickjs(ObjectUtil.DeleteModalFooterButton("Yes"));	    
	}

	@Then("fl Add new Description for document")
	public void fl_Add_new_Description_for_document() throws IOException {
		docDescription = flDataSet.get("docDescription");
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		fl.ctrl_Flocation_form_doc_description.clear();
	    type(fl.ctrl_Flocation_form_doc_description,docDescription);
	}

	@When("fl verify the below Search fields under search page")
	public void fl_verify_the_below_Search_fields_under_search_page() throws Exception {
		WaitStatementsLib.iWaitForSeconds(driver, 35);
	    fl.ValidateSearchfields();
	}

	@When("fl Enter value in below Search fields")
	public void fl_Enter_value_in_below_Search_fields() throws Exception {

		sModel = flDataSet.get("EditModel");
		sfamilyVariant = flDataSet.get("FamilyVariantnew");
		FLCode = flDataSet.get("FLCode");
		FLDescription = flDataSet.get("FLDescriptionEdit");
		FLFunction = flDataSet.get("FLFunctionEdit");
	

	    fl.EnterValueSearchfield(FLCode, FLDescription, FLFunction, sModel, sfamilyVariant);
	}

	@When("fl click on Search button")
	public void fl_click_on_Search_button() throws IOException {
	    click(fl.btn_Flocation_search);
	}

	@When("fl verify below Result table column fields")
	public void fl_verify_below_Result_table_column_fields() throws Exception {
	    fl.ValidateResultTabletTitle(flPageIconList);
		
	}

	@When("fl verify search value present under Result table")
	public void fl_verify_search_value_present_under_Result_table() throws Exception {
		sfamilyVariant = flDataSet.get("FamilyVnewResult");
		NominalQuantity = flDataSet.get("NominalQuantityEdit");
		RequiredQuantity = flDataSet.get("RequiredQuantityEdit");
		fl.ValidatesearchTableValues(FLCode, FLDescription, FLFunction, IsinMEL, NominalQuantity, RequiredQuantity, Ordernumber);
	}

	@Then("fl Click On FL Code present under Result table")
	public void fl_Click_On_FL_Code_present_under_Result_table() throws IOException {
		WaitStatementsLib.iWaitForSeconds(driver, 40);
	    click(ObjectUtil.ClickAttributeToOpen(FLCode));
	}

	@Then("fl select a row under result")
	public void fl_select_a_row_under_result() throws IOException {
		WaitStatementsLib.iWaitForSeconds(driver, 40);
		click(ObjectUtil.ClickTableElemetntToDelete(FLCode));
	}

	@Then("fl click on delete button")
	public void fl_click_on_delete_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("fl verify message Family deleted successfully")
	public void fl_verify_message_Family_deleted_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}


}
