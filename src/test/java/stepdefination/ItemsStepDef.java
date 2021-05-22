package stepdefination;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.openqa.selenium.support.PageFactory;

import PageObjects.ApplicableConfiguration;
import PageObjects.Homepage;
import PageObjects.Iteams;
import base.BaseTest;
import base.WaitStatementsLib;
import io.cucumber.java.en.Then;
import utilities.CommonFunctionUtil;
import utilities.ObjectUtil;
import utilities.TestUtil;

public class ItemsStepDef extends BaseTest {
	

	CommonFunctionUtil cf = new CommonFunctionUtil();
	Homepage hp = new Homepage();
	Iteams it = new Iteams();
	LinkedHashMap<String, ArrayList<String>> itPageIconList = null;
	LinkedHashMap<String, String> itDataSet = null;
	String ItemFamily, type, code, designation, floctype, num, life,unit, Disassembly, Level;
    String FamilyVariant, chapte, section, subject, sheet, marks;
	
	
	public ItemsStepDef() throws Exception {
	it = PageFactory.initElements(driver, Iteams.class);
	itPageIconList = excel.getDriverSheetData("Iteamsoptimal");
	logger = reporting.startTestCase("Iteamsoptimal");
	itDataSet = excel.getDriverSheetDataObj("Iteamsoptimal");

	}

	@Then("verify user navigated to Item page")
	public void verify_user_navigated_to_Item_page() throws IOException {
		WaitStatementsLib.eWaitForVisibility(driver,40, it.item_search_Title);
		TestUtil.assertLabel(it.item_search_Title,"Item");
		
	}

	@Then("click on Create button to create Item")
	public void click_on_Create_button_to_create_Item() throws IOException {
	    click(it.Btn_item_search_create);
	}

	@Then("item verify the name of the page Item")
	public void item_verify_the_name_of_the_page_Item() throws IOException {
		WaitStatementsLib.eWaitForVisibility(driver,40, it.item_form_Title);
		TestUtil.assertLabel(it.item_form_Title,"Item"); 
	}

	@Then("item verify there is \"(.*?)\" tab")
	public void item_verify_there_is_tab(String tab) throws IOException {
		TestUtil.assertLabel(ObjectUtil.getXapthselectTabWithId("item_form_tabs",tab),tab);
	}

	@Then("item verify there is \"(.*?)\" heading")
	public void item_verify_there_is_heading(String heading) throws IOException {
		TestUtil.assertLabel(it.Heading_item_main,heading); 
	}

	@Then("item verify below Main Information fields")
	public void item_verify_below_Main_Information_fields() throws Exception {
	    it.ValidateItemscreateMainPage();
	}

	@Then("item verify mandatory Main Information fields")
	public void item_verify_mandatory_Main_Information_fields() throws Exception {
	    it.ValidateMandatoryItemscreateMainPage();
	}

	@Then("item enter below Main Information fields")
	public void item_enter_below_Main_Information_fields() throws Exception {
		ItemFamily = itDataSet.get("ItemFamily");
		type = itDataSet.get("type");
		code = itDataSet.get("code");
		designation = itDataSet.get("designation");
		floctype = itDataSet.get("floctype");
		num = itDataSet.get("num");
		life = itDataSet.get("life");
	    it.EnterTextforMain(ItemFamily, type, code, designation, floctype, num, life);
	}
	
	@Then("click on Save button & Verify the message when mandatory fields not filled")
	public void click_on_Save_button_Verify_the_message_when_mandatory_fields_not_filled() throws IOException {
	    click(it.Btn_item_form_save);
	    TestUtil.save_error_message("You must fill the required fields (*)");
	}


	@Then("item enter below mandatory Main Information fields")
	public void item_enter_below_mandatory_Main_Information_fields() throws Exception {
		FamilyVariant = itDataSet.get("FamilyVariant");
		chapte = itDataSet.get("chapte");
		section = itDataSet.get("section");
		subject = itDataSet.get("subject");
		sheet = itDataSet.get("sheet");
		marks = itDataSet.get("marks");
	    it.EnterMandatoryTextforMain(FamilyVariant, chapte, section, subject, sheet, marks);
	}
	@Then("item click on is \"(.*?)\" tab")
	public void item_click_on_is_tab(String tab) throws IOException {
		click(ObjectUtil.getXapthselectTabWithId("item_form_tabs",tab));
	}

	@Then("item verify below Main additional Information fields")
	public void item_verify_below_Main_additional_Information_fields() throws Exception {
	    it.ValidateAdditionalInformationscreatePage();
	}

	@Then("item Enter the details in all the fields")
	public void item_enter_the_details_in_all_the_fields() throws Exception {
		unit = itDataSet.get("unit");
		Disassembly = itDataSet.get("Disassembly");
		Level = itDataSet.get("Level");
	    it.EntereAdditionalInformationscreatePage(unit, Disassembly, Level);
	}

	@Then("click on Save button & Verify the message when a user save Item successfully")
	public void click_on_Save_button_Verify_the_message_when_a_user_save_Item_successfully() throws IOException {
	    click(it.Btn_item_form_save);
	    TestUtil.save_message_validation("Item Saved Successfuly");
	}

}
