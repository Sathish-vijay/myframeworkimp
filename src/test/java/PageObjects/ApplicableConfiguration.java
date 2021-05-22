package PageObjects;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import base.BaseTest;
import base.WaitStatementsLib;
import utilities.ObjectUtil;
import utilities.TestUtil;

public class ApplicableConfiguration extends BaseTest{

	@FindBy(how = How.ID, using = "applicable_configuration_search_title_lbl")
    public WebElement applicable_configuration_Title;
	
	@FindBy(how = How.ID, using = "applicable_configuration_search_create_btn")
    public WebElement Btn_applicable_configuration_create;
	
	@FindBy(how = How.ID, using = "applicable_configuration_form_main_lbl")
    public WebElement Heading_ac_Home_main;
	
	@FindBy(how = How.ID, using = "applicable_configuration_form_structure_lbl")
    public WebElement Heading_ac_Home_structure;
	
	@FindBy(how = How.ID, using = "applicable_configuration_form_family_variant_lbl")
    public WebElement Lbl_ac_Home_family_variant;
	
	@FindBy(how = How.ID, using = "applicable_configuration_form_function_lbl")
    public WebElement Lbl_ac_Home_family_function;	
	
	@FindBy(how = How.ID, using = "applicable_configuration_form_variant_lbl")
    public WebElement Lbl_ac_Home_variant;	
	
	@FindBy(how = How.ID, using = "applicable_configuration_form_variant_name_lbl")
    public WebElement Lbl_ac_Home_variant_name;	
	
	@FindBy(how = How.ID, using = "applicable_configuration_form_structure_lbl")
    public WebElement Lbl_ac_Home_structure;	
	
	@FindBy(how = How.ID, using = "applicable_configuration_form_air_docs_lbl")
    public WebElement Heading_ac_Airworthiness_Documents;
	
	
	@FindBy(how = How.ID, using = "applicable_configuration_form_rev_date_lbl")
    public WebElement Lbl_ac_Home_rev_date;	
	
	@FindBy(how = How.ID, using = "applicable_configuration_form_rev_number_lbl")
    public WebElement Lbl_ac_Home_rev_number;	
	
	@FindBy(how = How.ID, using = "applicable_configuration_form_structure_lbl")
    public WebElement Lbl_ac_Home_tabs;	
	

	@FindBy(how = How.ID, using = "applicable_configuration_form_family_code_lbl")
    public WebElement txt_ac_Home_family_code;
	
	@FindBy(how = How.ID, using = "applicable_configuration_form_variant_ctrl")
    public WebElement txt_ac_Home_variant;	
	
	@FindBy(how = How.ID, using = "applicable_configuration_form_variant_name_ctrl")
    public WebElement txt_ac_Home_variant_name;		
	
	@FindBy(how = How.ID, using = "applicable_configuration_form_rev_date_ctrl")
    public WebElement txt_ac_Home_rev_date;	
	
	@FindBy(how = How.ID, using = "applicable_configuration_form_rev_number_ctrl")
    public WebElement txt_ac_Home_rev_number;	
	
	@FindBy(how = How.ID, using = "dialog_table_title_lbl")
    public WebElement title_ac_ProductFamily;	
	
	@FindBy(how = How.ID, using = "dialog_table_validate_btn")
    public WebElement Btn_Product_Family_validate;
	
	@FindBy(how = How.ID, using = "dialog_document_config_title_lbl")
    public WebElement title_ac_Documentconfig;	
	
	@FindBy(how = How.ID, using = "dialog_document_config_type_lbl")
    public WebElement lbl_Product_Document_type;
	
	@FindBy(how = How.ID, using = "dialog_document_config_number_lbl")
    public WebElement lbl_Product_Document_number;
	
	@FindBy(how = How.ID, using = "dialog_document_config_revision_lbl")
    public WebElement lbl_Product_Document_revision;
	
	@FindBy(how = How.ID, using = "dialog_document_config_date_lbl")
    public WebElement lbl_Product_Document_date;
	
	@FindBy(how = How.ID, using = "dialog_document_config_type_ctrl")
    public WebElement txt_Product_Document_type;
	
	@FindBy(how = How.ID, using = "dialog_document_config_open_lbl")
    public WebElement txt_Product_Document_number;
	
	@FindBy(how = How.ID, using = "dialog_document_config_revision_ctrl")
    public WebElement txt_Product_Document_revision;
	
	@FindBy(how = How.ID, using = "dialog_document_config_date_ctrl")
    public WebElement txt_Product_Document_date;
	
	@FindBy(how = How.ID, using = "dialog_ddocument_config_validate_btn")
    public WebElement Btn_Product_Document_validate;
	
	@FindBy(how = How.ID, using = "dialog_table_title_lbl")
    public WebElement Title_Airworthiness_Documents;
	
	@FindBy(how = How.ID, using = "dialog_table_validate_btn")
    public WebElement btn_Airworthiness_Documentsvalidate;
	
	
		/*************************************************************************************************/

		// Validation of main information under Home tab
		public void navigationCreatePageHometab() throws Exception {
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			try {
				WaitStatementsLib.iWaitForSeconds(driver, 15);
				Assert.assertTrue(isElementPresent(Lbl_ac_Home_family_variant),"family variant label not present");
				Assert.assertTrue(isElementPresent(Lbl_ac_Home_family_function),"family function label not present");
				Assert.assertTrue(isElementPresent(Lbl_ac_Home_variant),"Variant code label not present");
				Assert.assertTrue(isElementPresent(Lbl_ac_Home_variant_name),"Variant name label not present");
				Assert.assertTrue(isElementPresent(Lbl_ac_Home_structure),"Structure type label not present");
				Assert.assertTrue(isElementPresent(Lbl_ac_Home_rev_date),"Variant revision date label not present");
				Assert.assertTrue(isElementPresent(Lbl_ac_Home_rev_number),"Variant revision number label not present");

				
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		
		// Validation of mandatory main information under Home tab
		public void ValidatemandatoryFieldUnderHomeTab() throws Exception {
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			try {
				WaitStatementsLib.iWaitForSeconds(driver, 15);
				Assert.assertTrue(mandatory(Lbl_ac_Home_family_variant),"family variant is not mandatory");
				Assert.assertTrue(mandatory(Lbl_ac_Home_variant),"variant code is not mandatory");
				Assert.assertTrue(mandatory(Lbl_ac_Home_variant_name),"variant name is not mandatory");


				
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		
		// Enter values main information under Home tab
		public void EnterValuesUnderHomemain(String familycode,String variantCode,String variantName, String revDate, String revNum  ) throws Exception {
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			try {
				WaitStatementsLib.iWaitForSeconds(driver, 15);
				click(txt_ac_Home_family_code);
				WaitStatementsLib.eWaitForVisibility(driver,40, title_ac_ProductFamily);
				WaitStatementsLib.iWait(4);
				WaitStatementsLib.iWaitForSeconds(driver, 40);
				TestUtil.SearchTabelSearchAndClickValue("dialog_table_result_tbl", familycode);	
				WaitStatementsLib.iWaitForSeconds(driver, 15);
		        clickjs(Btn_Product_Family_validate);
		        
				WaitStatementsLib.iWait(1);
			       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_ac_Home_rev_date);
			       
					WaitStatementsLib.iWaitForSeconds(driver, 15);
				type(txt_ac_Home_variant,variantCode);
				type(txt_ac_Home_variant_name,variantName);
				
				WaitStatementsLib.iWaitForSeconds(driver, 15);
		        click(txt_ac_Home_rev_date);
				WaitStatementsLib.iWaitForSeconds(driver, 15);
				WaitStatementsLib.iWaitForSeconds(driver, 30);
				TestUtil.selectDate("May", 2021, 05);
	//			type(txt_ac_Home_rev_date,revDate);
				type(txt_ac_Home_rev_number,revNum);				
				
				
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		
		
		// Check Airworthiness Table
		public void ValidateAirworthinessTabletTitle(LinkedHashMap<String, ArrayList<String>> iconList) throws Exception {
			
			try {
					WaitStatementsLib.iWaitForSeconds(driver, 15);
					TestUtil.SearchAndCompair(1,"Airworthiness", ObjectUtil.SelectAllTitleFromTable("Airworthiness Documents"),iconList);
					
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		
		
		// Check Airworthiness Table
		public void EnterAirworthinessTabletValues(String AirworthinessNum ) throws Exception {
			
			try {
				WaitStatementsLib.iWaitForSeconds(driver, 15);
				click(txt_Product_Document_number);
				WaitStatementsLib.eWaitForVisibility(driver,40, Title_Airworthiness_Documents);
				WaitStatementsLib.iWait(4);
				WaitStatementsLib.iWaitForSeconds(driver, 40);
				TestUtil.SearchTabelSearchAndClickValue("dialog_table_result_tbl", AirworthinessNum);	
				WaitStatementsLib.iWaitForSeconds(driver, 15);
		        clickjs(btn_Airworthiness_Documentsvalidate);
		        
		        click(txt_Product_Document_date);
				WaitStatementsLib.iWaitForSeconds(driver, 30);
				TestUtil.selectDate("May", 2021, 05);
		        					
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
}
