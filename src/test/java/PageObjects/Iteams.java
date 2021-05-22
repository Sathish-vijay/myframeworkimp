package PageObjects;
import base.BaseTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utilities.ObjectUtil;
import utilities.TestUtil;
import base.WaitStatementsLib;

public class Iteams extends BaseTest{

	@FindBy(how = How.ID, using = "item_search_title_lbl")
    public WebElement item_search_Title;
	
	@FindBy(how = How.ID, using = "item_search_create_btn")
    public WebElement Btn_item_search_create;
	
	@FindBy(how = How.ID, using = "item_form_save_btn")
    public WebElement Btn_item_form_save;
	
	@FindBy(how = How.ID, using = "item_form_title_lbl")
	public WebElement item_form_Title;
	
	@FindBy(how = How.ID, using = "item_form_main_lbl")
    public WebElement Heading_item_main;
	
	@FindBy(how = How.ID, using = "item_form_fv_lbl")
    public WebElement Lbl_item_form_fv;
	
	@FindBy(how = How.ID, using = "item_form_item_code_lbl")
    public WebElement Lbl_item_form_code;
	
	@FindBy(how = How.ID, using = "item_form_family_lbl")
    public WebElement Lbl_item_form_family;
	
	@FindBy(how = How.ID, using = "item_form_item_type_lbl")
    public WebElement Lbl_item_form_item_type;
	
	@FindBy(how = How.ID, using = "item_form_func_code_lbl")
    public WebElement Lbl_item_form_func_code;
	
	@FindBy(how = How.ID, using = "item_form_serialized_lbl")
    public WebElement Lbl_item_form_serialized;
	
	@FindBy(how = How.ID, using = "item_form_designation_lbl")
    public WebElement Lbl_item_form_func_designation;
	
	@FindBy(how = How.ID, using = "item_form_floc_lbl")
    public WebElement Lbl_item_form_floc;
	
	@FindBy(how = How.ID, using = "item_form_item_num_lbl")
    public WebElement Lbl_item_form_item_num;
	
	@FindBy(how = How.ID, using = "item_form_life_lbl")
    public WebElement Lbl_item_form_life;
	

	@FindBy(how = How.ID, using = "item_form_fv_ctrl")
    public WebElement ctrl_item_form_fv;
	
	@FindBy(how = How.ID, using = "item_form_chapter_ctrl")
    public WebElement ctrl_item_form_code_chapter;
	
	@FindBy(how = How.ID, using = "item_form_section_ctrl")
    public WebElement ctrl_item_form_code_section;
	
	@FindBy(how = How.ID, using = "item_form_subject_ctrl")
    public WebElement ctrl_item_form_code_subject;
	
	@FindBy(how = How.ID, using = "item_form_sheet_ctrl")
    public WebElement ctrl_item_form_code_sheet;
	
	@FindBy(how = How.ID, using = "item_form_marks_ctrl")
    public WebElement ctrl_item_form_code_marks;
	

	@FindBy(how = How.ID, using = "item_form_family_ctrl")
    public WebElement ctrl_item_form_family;
	
	@FindBy(how = How.ID, using = "item_form_item_type_ctrl")
    public WebElement ctrl_item_form_item_type;
	
	@FindBy(how = How.ID, using = "item_form_func_code_ctrl")
    public WebElement ctrl_item_form_func_code;
	
	@FindBy(how = How.ID, using = "item_form_searialized_ctrl")
    public WebElement ctrl_item_form_serialized;
	
	@FindBy(how = How.ID, using = "item_form_designation_ctrl")
    public WebElement ctrl_item_form_func_designation;
	
	@FindBy(how = How.ID, using = "item_form_floc_ctrl")
    public WebElement ctrl_item_form_floc;
	
	@FindBy(how = How.ID, using = "item_form_item_num_ctrl")
    public WebElement ctrl_item_form_item_num;
	
	@FindBy(how = How.ID, using = "item_form_life_ctrl")
    public WebElement ctrl_item_form_life;
	
	@FindBy(how = How.ID, using = "item_form_pns_lbl")
    public WebElement heading_item_form_pns;
	
	@FindBy(how = How.ID, using = "item_version_popup_title_lbl")
    public WebElement Title_ItemVersion_Management;
	
	@FindBy(how = How.ID, using = "item_version_popup_number_lbl")
    public WebElement lbl_item_version_popup_number;
	
	@FindBy(how = How.ID, using = "item_version_popup_number_ctrl")
    public WebElement ctrl_item_version_popup_number;
	
	@FindBy(how = How.ID, using = "item_version_popup_validate_btn")
    public WebElement Btn_ItemVersion_Validate;
	
	@FindBy(how = How.ID, using = "item_version_popup_cancel_btn")
    public WebElement Btn_ItemVersion_Cancel;
	
	@FindBy(how = How.ID, using = "item_form_general_lbl")
    public WebElement Title_ItemVersion_general;
	
	@FindBy(how = How.ID, using = "item_form_unit_lbl")
    public WebElement lbl_ItemVersion_unit;
	
	@FindBy(how = How.ID, using = "item_form_dissassembly_lbl")
    public WebElement lbl_ItemVersion_dissassembly;
	
	@FindBy(how = How.ID, using = "item_form_level_lbl")
    public WebElement lbl_ItemVersion_level;
	
	@FindBy(how = How.ID, using = "item_form_head_lbl")
    public WebElement lbl_ItemVersion_head;
	
	@FindBy(how = How.ID, using = "item_form_mel_lbl")
    public WebElement lbl_ItemVersion_mel;
	
	@FindBy(how = How.ID, using = "item_form_inspection_lbl")
    public WebElement lbl_ItemVersion_inspection;
	
	@FindBy(how = How.ID, using = "item_form_illustrated_lbl")
    public WebElement lbl_ItemVersion_illustrated;
	
	@FindBy(how = How.ID, using = "item_form_attaching_lbl")
    public WebElement lbl_ItemVersion_attaching;
	
	@FindBy(how = How.ID, using = "item_form_config_lbl")
    public WebElement lbl_ItemVersion_config;
	
	@FindBy(how = How.ID, using = "item_form_class_lbl")
    public WebElement lbl_ItemVersion_class;
	
	@FindBy(how = How.ID, using = "item_form_refer_ctrl")
    public WebElement lbl_ItemVersion_refer;
	
//update	@FindBy(how = How.ID, using = "Refer to")
//    public WebElement lbl_ItemVersion_unit;
	
	//update	@FindBy(how = How.ID, using = "Fixed element")
//  public WebElement lbl_ItemVersion_unit;	
	 
	//update	@FindBy(how = How.ID, using = "Comment")
//  public WebElement lbl_ItemVersion_unit;		
	 
	@FindBy(how = How.ID, using = "item_form_unit_ctrl")
    public WebElement ctrl_ItemVersion_unit;
	 
	@FindBy(how = How.ID, using = "item_form_dissassembly_ctrl")
    public WebElement ctrl_ItemVersion_dissassembly;
	
	@FindBy(how = How.ID, using = "item_form_level_ctrl")
    public WebElement ctrl_ItemVersion_level;
	
	@FindBy(how = How.ID, using = "item_form_head_ctrl")
    public WebElement ctrl_ItemVersion_head;
	
	@FindBy(how = How.ID, using = "item_form_mel_ctrl")
    public WebElement ctrl_ItemVersion_mel;
	
	@FindBy(how = How.ID, using = "item_form_inspection_ctrl")
    public WebElement ctrl_ItemVersion_inspection;
	
	@FindBy(how = How.ID, using = "item_form_illustrated_ctrl")
    public WebElement ctrl_ItemVersion_illustrated;
	
	@FindBy(how = How.ID, using = "item_form_attaching_ctrl")
    public WebElement ctrl_ItemVersion_attaching;
	
	@FindBy(how = How.ID, using = "item_form_config_ctrl")
    public WebElement ctrl_ItemVersion_config;
	
	@FindBy(how = How.ID, using = "item_form_class_ctrl")
    public WebElement ctrl_ItemVersion_class;
	
	
	
	Boolean value;
	
	/*************************************************************************************************/


	// Validate on create Items Page Main Information
	public void ValidateItemscreateMainPage() throws Exception {
		
		try {
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			TestUtil.assertLabel(Lbl_item_form_fv,"Family Variant");
			TestUtil.assertLabel(Lbl_item_form_code,"Item Code");
			
			TestUtil.assertLabel(Lbl_item_form_family,"Item Family");
			TestUtil.assertLabel(Lbl_item_form_item_type,"Item Type");
			TestUtil.assertLabel(Lbl_item_form_func_code,"Function Code");
			TestUtil.assertLabel(Lbl_item_form_serialized,"Serialized part");
			TestUtil.assertLabel(Lbl_item_form_func_designation,"Designation");
			TestUtil.assertLabel(Lbl_item_form_floc,"FLoc Type");
			TestUtil.assertLabel(Lbl_item_form_item_num,"Item Number");
			TestUtil.assertLabel(Lbl_item_form_life,"Life Restriction Type");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	// Validate on create Items Page Main Information
	public void ValidateMandatoryItemscreateMainPage() throws Exception {
		
		try {
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			Assert.assertTrue(mandatory(Lbl_item_form_fv),"Family Variant is not mandatory");
			Assert.assertTrue(mandatory(Lbl_item_form_code),"Item Code is not mandatory");

			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// Enter mandatory Text for Main Information
	public void EnterMandatoryTextforMain(String FamilyVariant,String chapte, String section, String subject, String sheet,String marks) throws Exception {
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		try {

			click(ctrl_item_form_fv);
			TestUtil.selecValueFromDropdown(FamilyVariant);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			type(ctrl_item_form_code_chapter, chapte);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			type(ctrl_item_form_code_section, section);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			type(ctrl_item_form_code_subject, subject);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			type(ctrl_item_form_code_sheet, sheet);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			type(ctrl_item_form_code_marks, marks);

			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// Enter Text for Main Information
	public void EnterTextforMain(String ItemFamily,String type, String code, String designation, String floctype,String num,String life) throws Exception {
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		try {

			WaitStatementsLib.iWaitForSeconds(driver, 15);
			click(ctrl_item_form_family);
			System.out.println(ItemFamily+type+code);
	
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			TestUtil.selecValueFromDropdown(ItemFamily);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			click(ctrl_item_form_item_type);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			TestUtil.selecValueFromDropdown(type);
			
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			type(ctrl_item_form_func_code,code);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			click(ctrl_item_form_serialized);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			type(ctrl_item_form_func_designation, designation);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			click(ctrl_item_form_floc);
			TestUtil.selecValueFromDropdown(floctype);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			type(ctrl_item_form_item_num, num);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			click(ctrl_item_form_life);
			TestUtil.selecValueFromDropdown(life);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	// Validate on create Items Page Main Information
	public void ValidateItemscreatePage() throws Exception {
		
		try {
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			TestUtil.assertLabel(Lbl_item_form_fv,"Family Variant");
			TestUtil.assertLabel(Lbl_item_form_code,"Item Code");
			
			TestUtil.assertLabel(Lbl_item_form_family,"Item Family");
			TestUtil.assertLabel(Lbl_item_form_item_type,"Item Type");
			TestUtil.assertLabel(Lbl_item_form_func_code,"Function Code");
			TestUtil.assertLabel(Lbl_item_form_serialized,"Serialized part");
			TestUtil.assertLabel(Lbl_item_form_func_designation,"Designation");
			TestUtil.assertLabel(Lbl_item_form_floc,"FLoc Type");
			TestUtil.assertLabel(Lbl_item_form_item_num,"Item Number");
			TestUtil.assertLabel(Lbl_item_form_life,"Life Restriction Type");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	
	// Check Table title Part Number
	public void CheckTableTitlePartNumber(LinkedHashMap<String, ArrayList<String>> iconList) throws Exception {
		
		try {
//			
				WaitStatementsLib.iWaitForSeconds(driver, 15);
				TestUtil.SearchAndCompair(1,"PartNumbers", ObjectUtil.SelectTitleRowFromTableWithId("item_form_pm_list_tbl"),iconList);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	
	// Validate popup for Item Version
	public void ValidatePopupforItemVersion() throws Exception {

		try {
			
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			WaitStatementsLib.eWaitForVisibility(driver,40, Title_ItemVersion_Management);
			TestUtil.assertLabel(Title_ItemVersion_Management,"Item Version Management");
			TestUtil.assertLabel(lbl_item_version_popup_number,"Item Version");
			Assert.assertTrue(isElementPresent(Btn_ItemVersion_Cancel)," Cancel button not present");
			Assert.assertTrue(isElementPresent(Btn_ItemVersion_Validate)," Validate button not present");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	// Enter Value for Item Version
	public void EnterValueforItemVersion(String ItemVersion) throws Exception {
		
		try {
			WaitStatementsLib.iWaitForSeconds(driver, 40);
			type(ctrl_item_version_popup_number,ItemVersion);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	// Validate on create Items Page Additional Information
	public void ValidateAdditionalInformationscreatePage() throws Exception {
		
		try {
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			TestUtil.assertLabel(lbl_ItemVersion_unit,"Replaceable Unit Type");
			TestUtil.assertLabel(lbl_ItemVersion_dissassembly,"Disassembly Group");
			TestUtil.assertLabel(lbl_ItemVersion_level,"Level");
			TestUtil.assertLabel(lbl_ItemVersion_head,"Is head of group");
			TestUtil.assertLabel(lbl_ItemVersion_inspection,"Visible on Inspection");
			TestUtil.assertLabel(lbl_ItemVersion_mel,"In MEL / CDL");
			TestUtil.assertLabel(lbl_ItemVersion_illustrated,"Is Illustrated");
			TestUtil.assertLabel(lbl_ItemVersion_attaching,"Attaching Part");
			TestUtil.assertLabel(lbl_ItemVersion_config,"Configurable Item");
			TestUtil.assertLabel(lbl_ItemVersion_class,"Is class item");
			Assert.assertTrue(isElementPresent(lbl_ItemVersion_refer),"Refer for NHA not present");

			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	// Enter on create Items Page Additional Information
	public void EntereAdditionalInformationscreatePage(String unit, String Disassembly , String Level) throws Exception {
		
		try {
			System.out.println(Disassembly+Level);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			click(ctrl_ItemVersion_unit);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			TestUtil.selecValueFromDropdown(unit);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			click(ctrl_ItemVersion_dissassembly);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			TestUtil.selecValueFromDropdown(Disassembly);
//			click(ctrl_ItemVersion_dissassembly);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			click(ctrl_ItemVersion_level);
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			TestUtil.selecValueFromDropdown(Level);
			
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			click(ctrl_ItemVersion_head);
			click(ctrl_ItemVersion_inspection);
			click(ctrl_ItemVersion_mel);
			click(ctrl_ItemVersion_illustrated);
			click(ctrl_ItemVersion_attaching);
			click(ctrl_ItemVersion_config);
			click(ctrl_ItemVersion_class);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}

