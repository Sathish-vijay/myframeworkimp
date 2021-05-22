package PageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.BaseTest;
import base.WaitStatementsLib;
import io.cucumber.java.en.Then;
import utilities.ObjectUtil;
import utilities.TestUtil;

public class FunctionalLocation extends BaseTest{

	@FindBy(how = How.ID, using = "functional_location_search_title_lbl")
    public WebElement Flocation_search_Title;
	
	@FindBy(how = How.ID, using = "functional_location_search_create_btn")
    public WebElement Btn_Flocation_search_create;
	
	@FindBy(how = How.ID, using = "functional_location_form_title_lbl")
	public WebElement Flocation_form_Title;
	
	@FindBy(how = How.ID, using = "functional_location_form_main_lbl")
    public WebElement Heading_Flocation_main;
	
	@FindBy(how = How.ID, using = "functional_location_form_fl_c_lbl")
    public WebElement lbl_Flocation_form_fl_c;	
	
	@FindBy(how = How.ID, using = "functional_location_form_fl_desc_lbl")
    public WebElement lbl_Flocation_form_fl_desc;	
	
	@FindBy(how = How.ID, using = "functional_location_form_fl_func_lbl")
    public WebElement lbl_Flocation_form_fl_func;	
	
	@FindBy(how = How.ID, using = "functional_location_form_fl_nominal_quantity_lbl")
    public WebElement lbl_Flocation_form_fl_nominal_quantity;	
	
	@FindBy(how = How.ID, using = "functional_location_form_fl_required_quantity_lbl")
    public WebElement lbl_Flocation_form_required_quantity;	
	
	@FindBy(how = How.ID, using = "functional_location_form_fl_is_mel_lbl")
    public WebElement lbl_Flocation_form_fl_is_mel;	
	
	
	@FindBy(how = How.ID, using = "functional_location_form_fl_c_ctrl")
    public WebElement ctrl_Flocation_form_fl_c;	
	
	@FindBy(how = How.ID, using = "functional_location_form_fl_desc_ctrl")
    public WebElement ctrl_Flocation_form_fl_desc;	
	
	@FindBy(how = How.ID, using = "functional_location_form_fl_func_ctrl")
    public WebElement ctrl_Flocation_form_fl_func;	
	
	@FindBy(how = How.ID, using = "functional_location_form_fl_nominal_quantity_ctrl")
    public WebElement ctrl_Flocation_form_fl_nominal_quantity;	
	
	@FindBy(how = How.ID, using = "functional_location_form_fl_required_quantity_ctrl")
    public WebElement ctrl_Flocation_form_required_quantity;	
	
	@FindBy(how = How.ID, using = "functional_location_form_fl_is_mel_ctrl")
    public WebElement ctrl_Flocation_form_fl_is_mel;	
	
	@FindBy(how = How.ID, using = "functional_location_form_items_results_lbl")
    public WebElement Heading_Flocation_form_items;
	
	//functional_location_form_fvs_tbl
	
	@FindBy(how = How.ID, using = "functional_location_form_structure_results_lbl")
    public WebElement Heading_Flocation_form_structure;
	
	//functional_location_form_structure_tbl
	
	@FindBy(how = How.ID, using = "functional_location_form_documentation_lbl")
    public WebElement Heading_Flocation_form_documentation;
	
	@FindBy(how = How.ID, using = "functional_location_form_upload_ctrl")
    public WebElement btn_Flocation_form_upload;	
	
	@FindBy(how = How.ID, using = "functional_location_form_doc_description_lbl")
    public WebElement lbl_Flocation_form_doc_description;
	
	@FindBy(how = How.ID, using = "functional_location_form_doc_description_ctrl")
    public WebElement ctrl_Flocation_form_doc_description;
	
	@FindBy(how = How.ID, using = "functional_location_form_name_lbl")
    public WebElement lbl_Flocation_form_name;
	
	@FindBy(how = How.ID, using = "functional_location_form_name_ctrl")
    public WebElement ctrl_Flocation_form_name;
	
	@FindBy(how = How.ID, using = "functional_location_form_save_btn")
    public WebElement btn_Flocation_save;
	
	@FindBy(how = How.ID, using = "functional_location_form_edit_btn")
    public WebElement btn_Flocation_edit;
	
	@FindBy(how = How.ID, using = "functional_location_search_family_variant_lbl")
    public WebElement txt_Flocation_search_family_variant;
	
	@FindBy(how = How.ID, using = "functional_location_search_family_variant_ctrl")
    public WebElement ctrl_Flocation_search_family_variant;
	
	@FindBy(how = How.ID, using = "functional_location_search_fl_code_lbl")
    public WebElement txt_Flocation_search_fl_code;
	
	@FindBy(how = How.ID, using = "functional_location_search_fl_code_ctrl")
    public WebElement ctrl_Flocation_search_fl_code;
	
	@FindBy(how = How.ID, using = "functional_location_search_fl_function_lbl")
    public WebElement txt_Flocation_search_fl_function;
	
	@FindBy(how = How.ID, using = "functional_location_search_fl_function_ctrl")
    public WebElement ctrl_Flocation_search_fl_function;
	
	@FindBy(how = How.ID, using = "functional_location_search_fl_description_lbl")
    public WebElement txt_Flocation_search_description;
	
	@FindBy(how = How.ID, using = "functional_location_search_fl_description_ctrl")
    public WebElement ctrl_Flocation_search_description;
	
	@FindBy(how = How.ID, using = "functional_location_search_model_lbl")
    public WebElement txt_Flocation_search_model;
	
	@FindBy(how = How.ID, using = "functional_location_search_model_ctrl")
    public WebElement ctrl_Flocation_search_model;

	@FindBy(how = How.ID, using = "functional_location_search_only_mel_lbl")
    public WebElement txt_Flocation_search_only_mel;
	
	@FindBy(how = How.ID, using = "functional_location_search_only_mel_ctrl")
    public WebElement ctrl_Flocation_search_only_mel;
	
	@FindBy(how = How.ID, using = "functional_location_search_search_btn")
    public WebElement btn_Flocation_search;
	
	@FindBy(how = How.ID, using = "functional_location_form_edit_family_varient_btn")
    public WebElement btn_Flocation_edit_family_varient;
	
	@FindBy(how = How.ID, using = "functional_location_form_delete_btn")
    public WebElement btn_Flocation_delete_family_varient;
	
	@FindBy(how = How.ID, using = "functional_location_form_open_btn")
    public WebElement btn_Flocation_open_family_varient;
	
	
	@FindBy(how = How.ID, using = "family_variant_popup_form_title_lbl")
    public WebElement title_family_variant_popup_form;
	
	@FindBy(how = How.ID, using = "family_variant_popup_form_item_lbl")
    public WebElement lbl_Flocation_popup_form_item;
	
	@FindBy(how = How.ID, using = "family_variant_popup_form_close_btn")
    public WebElement btn_family_variant_popup_close;
	
	@FindBy(how = How.ID, using = "functional_location_form_documentation_delete_btn")
    public WebElement btn_fl_documentation_delete;
	
	@FindBy(how = How.ID, using = "functional_location_form_download_btn")
    public WebElement btn_fl_form_download;
	
	Boolean value;
	
	/*************************************************************************************************/


	// Validate main information under home Page
	public void ValidateMainInformationfields() throws Exception {

		try {
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			TestUtil.assertLabel(lbl_Flocation_form_fl_c,"FL Code");
			TestUtil.assertLabel(lbl_Flocation_form_fl_desc,"FL Description");
			TestUtil.assertLabel(lbl_Flocation_form_fl_func,"FL Function");
			TestUtil.assertLabel(lbl_Flocation_form_fl_nominal_quantity,"Nominal Quantity");
			TestUtil.assertLabel(lbl_Flocation_form_required_quantity,"Required Quantity");
			TestUtil.assertLabel(lbl_Flocation_form_fl_is_mel,"Is In MEL");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// Enter value in below Main Information field 
	public void Enter_value_MainInformation_field(String FLCode, String FLDescription, String FLFunction, String NominalQuantity, String RequiredQuantity ) throws Exception {
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		try {

			WaitStatementsLib.iWaitForSeconds(driver, 15);
			type(ctrl_Flocation_form_fl_c,FLCode);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			type(ctrl_Flocation_form_fl_desc,FLDescription);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			click(ctrl_Flocation_form_fl_func);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			TestUtil.selecValueFromDropdown(FLFunction);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			type(ctrl_Flocation_form_fl_nominal_quantity,NominalQuantity);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			type(ctrl_Flocation_form_required_quantity,RequiredQuantity);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			click(ctrl_Flocation_form_fl_is_mel);
			WaitStatementsLib.iWaitForSeconds(driver, 15);


			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// update value in below Main Information field 
	public void update_value_MainInformation_field(String FLDescription, String FLFunction, String NominalQuantity, String RequiredQuantity ) throws Exception {
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		try {
			WaitStatementsLib.iWait(5);
			TestUtil.isEditableWithAllAttri(ctrl_Flocation_form_fl_c);
			ctrl_Flocation_form_fl_desc.clear();
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			type(ctrl_Flocation_form_fl_desc,FLDescription);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			click(ctrl_Flocation_form_fl_func);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			TestUtil.selecValueFromDropdown(FLFunction);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			ctrl_Flocation_form_fl_nominal_quantity.clear();
			type(ctrl_Flocation_form_fl_nominal_quantity,NominalQuantity);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			ctrl_Flocation_form_required_quantity.clear();
			type(ctrl_Flocation_form_required_quantity,RequiredQuantity);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			click(ctrl_Flocation_form_fl_is_mel);
			WaitStatementsLib.iWaitForSeconds(driver, 15);


			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	// Check Item Table 
	public void ValidateItemTabletTitle(LinkedHashMap<String, ArrayList<String>> iconList) throws Exception {
		
		try {
				WaitStatementsLib.iWaitForSeconds(driver, 15);
				TestUtil.SearchAndCompair(1,"ItemTable", ObjectUtil.SelectTitleRowFromTableWithId("functional_location_form_fvs_tbl"),iconList);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	// Check structure Table 
	public void ValidatestructureTabletTitle(LinkedHashMap<String, ArrayList<String>> iconList) throws Exception {
		
		try {
				WaitStatementsLib.iWaitForSeconds(driver, 15);
				TestUtil.SearchAndCompair(1,"structureTable", ObjectUtil.SelectTitleRowFromTableWithId("functional_location_form_structure_tbl"),iconList);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	// Validate Documentation Page
	public void ValidateDocumentationfields() throws Exception {

		try {
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			TestUtil.assertLabel(lbl_Flocation_form_name,"Name");
			TestUtil.assertLabel(lbl_Flocation_form_doc_description,"Description");

			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	
	// ValidateSearchFunctionPage
	public void ValidateSearchfields() throws Exception {

		try {
			WaitStatementsLib.iWaitForSeconds(driver, 35);
			TestUtil.assertLabel(txt_Flocation_search_family_variant,"Family-Variant");
			TestUtil.assertLabel(txt_Flocation_search_fl_code,"FL Code");
			TestUtil.assertLabel(txt_Flocation_search_fl_function,"FL Function");
			TestUtil.assertLabel(txt_Flocation_search_description,"FL Description");
			TestUtil.assertLabel(txt_Flocation_search_model,"Model");
			TestUtil.assertLabel(txt_Flocation_search_only_mel,"Only MEL");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	// Enter value in below Main Information field 
	public void EnterValueSearchfield(String FLCode, String FLDescription, String FLFunction, String Model, String familyVariant ) throws Exception {
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		try {

			WaitStatementsLib.iWaitForSeconds(driver, 15);
			click(ctrl_Flocation_search_family_variant);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			TestUtil.selecValueFromDropdown(familyVariant);
			
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			type(ctrl_Flocation_search_fl_code,FLCode);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			click(ctrl_Flocation_search_fl_function);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			TestUtil.selecValueFromDropdown(FLFunction);
			
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			type(ctrl_Flocation_search_description,FLDescription);
			
			WaitStatementsLib.iWaitForSeconds(driver, 15);
//			click(ctrl_Flocation_search_model);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			type(ctrl_Flocation_search_model,Model);			
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			click(ctrl_Flocation_search_only_mel);

			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// Check result Table title
	public void ValidateResultTabletTitle(LinkedHashMap<String, ArrayList<String>> iconList) throws Exception {
		
		try {
				WaitStatementsLib.iWaitForSeconds(driver, 15);
				TestUtil.SearchAndCompair(1,"Results", ObjectUtil.SelectTitleRowFromTableWithId("functional_location_search_results_tbl"),iconList);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	// validate search table values
	public void ValidatesearchTableValues(String FLCode,String FLDescription,String FLFunction,String IsinMEL, String NominalQuantity, String RequiredQuantity, String Ordernumber) throws Exception {

		try {
	WaitStatementsLib.iWait(5);
	System.out.println("table data");
	List<WebElement> rows1 = driver.findElements(By.xpath(ObjectUtil.SelectResultfromNewTableWithId("functional_location_search_results_tbl")));
	System.out.println(rows1.get(0).getText());
	Assert.assertEquals(rows1.get(0).getText(), FLCode);	
	System.out.println(rows1.get(1).getText());
	Assert.assertEquals(rows1.get(1).getText(), FLDescription);		
	System.out.println(rows1.get(2).getText());
	Assert.assertEquals(rows1.get(2).getText(), FLFunction);	
	System.out.println(rows1.get(4).getText());
	Assert.assertEquals(rows1.get(4).getText(), NominalQuantity);		
	System.out.println(rows1.get(5).getText());
	Assert.assertEquals(rows1.get(5).getText(), RequiredQuantity);	
		

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	// click_on_search_button_under_Search_Item_popup
	public void SelectvalueSearch_Item_popup(String FamilyVariant) throws Exception {
		
		try {
	WaitStatementsLib.iWait(1);
	WaitStatementsLib.iWaitForSeconds(driver, 15);
	click(ObjectUtil.getXpathDropDown("Family-Variant"));
	TestUtil.selecValueFromDropdown(FamilyVariant);
	WaitStatementsLib.iWaitForSeconds(driver, 15);
    click(ObjectUtil.getButtonXpathOnPopup("search-item","Search"));

				

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	

	
	// fl_select_value_from_Results_table
	public void Selectvalueselect_value_from_Results_table(String FamilyVariant) throws Exception {
		
		try {
	WaitStatementsLib.iWait(1);
	WaitStatementsLib.iWaitForSeconds(driver, 15);
	clickjs(ObjectUtil.SelectValueFromTable(FamilyVariant));
	WaitStatementsLib.iWait(2);
    clickjs(ObjectUtil.getButtonXpathOnPopup("search-item","Validate"));

				

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	//vefify information displayed are non editable
	public void vefifynoneditableOpenMode() throws Exception {
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		try {

			TestUtil.isEditableWithAllAttri(ctrl_Flocation_form_fl_c);
			TestUtil.isEditableWithAllAttri(ctrl_Flocation_form_fl_desc);
			TestUtil.isEditableWithAllAttri(ctrl_Flocation_form_fl_func);
			TestUtil.isEditableWithAllAttri(ctrl_Flocation_form_fl_nominal_quantity);
			TestUtil.isEditableWithAllAttri(ctrl_Flocation_form_required_quantity);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	// Presence of Edit ,Open and Delete button
	public void ValidatePresenceOfButtonforItems() throws Exception {
		
		try {
			WaitStatementsLib.iWaitForSeconds(driver, 15);
	Assert.assertTrue(isElementPresent(btn_Flocation_edit_family_varient),"edit button not present");
	Assert.assertTrue(isElementPresent(btn_Flocation_delete_family_varient),"delete button not present");
	Assert.assertTrue(isElementPresent(btn_Flocation_open_family_varient),"open button not present");
						

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// Presence of Edit ,Open and Delete button
	public void ValidateFamilyVariantManagementforItems() throws Exception {
		
		try {
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			
	Assert.assertTrue(isElementPresent(title_family_variant_popup_form),"title Family-Variant Management not present");
	Assert.assertTrue(isElementPresent(lbl_Flocation_popup_form_item),"Item Code label not present");
	Assert.assertTrue(isElementPresent(btn_family_variant_popup_close),"close button not present");						

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
}
