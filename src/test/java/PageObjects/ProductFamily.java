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

public class ProductFamily extends BaseTest{

	@FindBy(how = How.ID, using = "family_search_title_lbl")
    public WebElement family_search_Title;
	
	@FindBy(how = How.ID, using = "family_search_create_btn")
    public WebElement Btn_family_search_create;
	
	@FindBy(how = How.ID, using = "family_form_title_lbl")
	public WebElement family_form_Title;
	
	@FindBy(how = How.ID, using = "family_form_family_name_lbl")
    public WebElement Lbl_family_family_name;
	
	@FindBy(how = How.ID, using = "family_form_family_code_lbl")
    public WebElement Lbl_family_family_code;
	
	@FindBy(how = How.ID, using = "family_form_family_name_ctrl")
    public WebElement Txt_family_family_name;
	
	@FindBy(how = How.ID, using = "family_form_family_code_ctrl")
    public WebElement Txt_family_family_code;
	
	@FindBy(how = How.ID, using = "family_form_family_function_ctrl")
    public WebElement Txt_family_family_function;
	
	@FindBy(how = How.ID, using = "family_form_structure_type_lbl")
    public WebElement Lbl_family_structure_type;
	
	@FindBy(how = How.ID, using = "family_form_family_function_lbl")
    public WebElement Lbl_family_family_function;
	
	@FindBy(how = How.ID, using = "family_form_structure_type_display_lbl")
    public WebElement Ctl_family_structure_type;
	
	@FindBy(how = How.ID, using = "family_form_modification_lbl")
    public WebElement Heading_modification;
// popup
	
	@FindBy(how = How.ID, using = "family_modification_popup_title_lbl")
    public WebElement Title_popup_modification;
	
	@FindBy(how = How.ID, using = "family_form_main_lbl")
    public WebElement Heading_form_main;
	
	@FindBy(how = How.ID, using = "family_modification_popup_type_lbl")
    public WebElement Lbl_popup_modification_type;
	
	@FindBy(how = How.ID, using = "family_modification_popup_type_ctrl")
    public WebElement Txt_popup_modification_type;
	
	@FindBy(how = How.ID, using = "family_modification_popup_number_lbl")
    public WebElement Lbl_popup_modification_num;
	
	@FindBy(how = How.ID, using = "family_modification_popup_number_ctrl")
    public WebElement Txt_popup_modification_num;
	
	@FindBy(how = How.ID, using = "family_modification_popup_revision_number_lbl")
    public WebElement Lbl_popup_modification_revision_num;
	
	@FindBy(how = How.ID, using = "family_modification_popup_revision_number_ctrl")
    public WebElement Txt_popup_modification_revision_num;
	
	@FindBy(how = How.ID, using = "family_modification_popup_document_url_lbl")
    public WebElement Lbl_popup_modification_url;
	
	@FindBy(how = How.ID, using = "family_modification_popup_document_url_ctrl")
    public WebElement Txt_popup_modification_url;

	@FindBy(how = How.ID, using = "family_modification_popup_title_lbl")
    public WebElement Lbl_popup_modification_Designation;
	
	@FindBy(how = How.ID, using = "family_modification_popup_title_ctrl")
    public WebElement Txt_popup_modification_Designation;
	
	@FindBy(how = How.ID, using = "family_modification_popup_cancel_btn")
    public WebElement btn_modification_popup_cancel;
	
	@FindBy(how = How.ID, using = "family_modification_popup_validate_btn")
    public WebElement btn_modification_popup_validate;
//

	@FindBy(how = How.ID, using = "family_form_save_btn")
    public WebElement btn_pf_save;
	
	@FindBy(how = How.ID, using = "family_search_results_lbl")
    public WebElement Title_pf_results;
	
	@FindBy(how = How.ID, using = "family_search_refresh_btn")
    public WebElement btn_pf_refresh;
	
	@FindBy(how = How.ID, using = "family_form_edit_btn")
    public WebElement btn_pf_Edit;

	@FindBy(how = How.ID, using = "family_modification_popup_close_btn")
    public WebElement btn_pf_Close_popup;
	
	@FindBy(how = How.ID, using = "family_form_rating_lbl")
    public WebElement Heading_pf_rating;
	
	@FindBy(how = How.ID, using = "family_rating_popup_title_lbl")
    public WebElement Heading_pf_rating_popup;
	
	@FindBy(how = How.ID, using = "family_rating_popup_code_lbl")
    public WebElement lbl_pf_rating_popup_code;
	
	@FindBy(how = How.ID, using = "family_rating_popup_name_lbl")
    public WebElement lbl_pf_rating_popup_name;
	
	@FindBy(how = How.ID, using = "family_rating_popup_validate_btn")
    public WebElement btn_pf_validate_popup;
	
	@FindBy(how = How.ID, using = "family_rating_popup_code_ctrl")
    public WebElement txt_pf_rating_popup_code;
	
	@FindBy(how = How.ID, using = "family_rating_popup_name_ctrl")
    public WebElement txt_pf_rating_popup_name;
	
	@FindBy(how = How.ID, using = "family_rating_popup_close_btn")
    public WebElement btn_pf_rating_close_popup;

	

	Boolean value;
	
		/*************************************************************************************************/

		// Navigation on Product Family Page
		public void navigationOnProductFamilyPage() throws Exception {
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			try {
				WaitStatementsLib.iWaitForSeconds(driver, 15);
				WaitStatementsLib.iWait(5);
				Assert.assertTrue(isElementPresent("link_EngineeringData_XPATH"),"Administration tab not present");
				click("link_EngineeringData_XPATH");
				WaitStatementsLib.iWait(5);
				WaitStatementsLib.iWaitForSeconds(driver, 30);
				Assert.assertTrue(isElementPresent("icon_ProductConfiguration_XPATH"),"Customization tab not present");
				Assert.assertTrue(isElementPresent("link_ProductFamily_XPATH"),"User tab not present");
				WaitStatementsLib.iWaitForSeconds(driver, 30);
				click("link_ProductFamily_XPATH");
				
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}


		// Validate on Product Family Page
		public void ValidateProductFamilyPage() throws Exception {
			
			try {
				WaitStatementsLib.iWaitForSeconds(driver, 15);
				TestUtil.assertLabel(Lbl_family_family_name,"Family Name");
				TestUtil.assertLabel(Lbl_family_family_code,"Family Code");
				TestUtil.assertLabel(Lbl_family_family_function,"Family Function");
				TestUtil.assertLabel(Lbl_family_structure_type,"Structure Type");
				
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}

		// Search on Product Family Page
		public void ValidateSearchFunctionPage(String Search) throws Exception {
			WaitStatementsLib.iWaitForSeconds(driver, 15);
			try {
				driver.findElement(By.xpath(OR.getProperty("filt_Search_Pf_XPATH"))).clear();
				WaitStatementsLib.iWaitForSeconds(driver, 15);
				type("filt_Search_Pf_XPATH", Search);
				WaitStatementsLib.iWait(5);
				WaitStatementsLib.iWaitForSeconds(driver, 15);


				List <WebElement> seaarchF = driver.findElements(By.xpath("(.//*[@id='aw-app'] //*[@class='yac-table-body resizable'] //*[@class='yac-table-row']) [1]"));
				System.out.println(seaarchF.get(0).getText());
				System.out.println(Search);
				Assert.assertTrue(seaarchF.get(0).getText().contains(Search));
				
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	
		
		// Check Table
		public void ValidateModificationsTabletTitle(LinkedHashMap<String, ArrayList<String>> iconList) throws Exception {
			
			try {
					WaitStatementsLib.iWaitForSeconds(driver, 15);
					TestUtil.SearchAndCompair(1,"Modifications", ObjectUtil.getXPathHomeMenuLabel(),iconList);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		
		// Check rating Table
		public void ValidateratingTabletTitle(LinkedHashMap<String, ArrayList<String>> iconList) throws Exception {
			
			try {
					WaitStatementsLib.iWaitForSeconds(driver, 15);
					TestUtil.SearchAndCompair(1,"Ratings", ObjectUtil.SelectAllTitleFromTable("Ratings"),iconList);
					
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		
				// Check modfication popup
		public void ValidateModificationspopupField() throws Exception {
			
			try {
					WaitStatementsLib.iWaitForSeconds(driver, 15);
					TestUtil.assertLabel(Lbl_popup_modification_type,"Modification Type");
					TestUtil.assertLabel(Lbl_popup_modification_num,"Modification Number");
					TestUtil.assertLabel(Lbl_popup_modification_url,"Modification Document URL");
//					TestUtil.assertLabel(Lbl_popup_modification_Designation,"Designation");
					TestUtil.assertLabel(Lbl_popup_modification_revision_num,"Modification Revision Number");
					

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
				// Validate modification table values
		public void ValidateModificationsTableValues(String Type,String Number,String rNumber, String url,String description) throws Exception {
			
			try {
		WaitStatementsLib.iWaitForSeconds(driver, 30);					
		List<WebElement> rows1 = driver.findElements(By.xpath(ObjectUtil.SelectAllElementFromTable()));
		
		System.out.println(rows1.get(1).getText());
		Assert.assertEquals(rows1.get(1).getText(), Type);	
		System.out.println(rows1.get(2).getText());
		Assert.assertEquals(rows1.get(2).getText(), Number);		
		System.out.println(rows1.get(3).getText());
		Assert.assertEquals(rows1.get(3).getText(), rNumber);	
		System.out.println(rows1.get(4).getText());
		Assert.assertEquals(rows1.get(4).getText(), url);
		System.out.println(rows1.get(5).getText());
		Assert.assertEquals(rows1.get(5).getText(), description);

					

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}	
		
		// Validate Results table table values		
		public void ValidateResultstableTablecolumns(LinkedHashMap<String, ArrayList<String>> iconList) throws Exception {
			
			try {
		WaitStatementsLib.iWaitForSeconds(driver, 30);					

		TestUtil.SearchAndCompairNewTableTitle("app-administration-family-list","ResultTableTitle", iconList);
							

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}	
		
		// validate search table values
		public void ValidatesearchTableValues(String code,String name,String function) throws Exception {
			
			try {
		WaitStatementsLib.iWait(5);
		System.out.println("table data");
		List<WebElement> rows1 = driver.findElements(By.xpath("//*[contains(@class,'body')]//*[(@class='yac-table-row')]/div"));
		
		System.out.println(rows1.get(0).getText());
		Assert.assertEquals(rows1.get(0).getText(), code);	
		System.out.println(rows1.get(1).getText());
		Assert.assertEquals(rows1.get(1).getText(), name);		
		System.out.println(rows1.get(3).getText());
		Assert.assertEquals(rows1.get(3).getText(), function);	

					

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		
		public void EnterAllTheValuesUnderModificationsPopup(String Type,String Number,String rNumber,String url,String Designation) throws Exception {
			
			try {
		WaitStatementsLib.iWait(5);
		System.out.println("table data");
		Txt_popup_modification_type.clear();
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		type(Txt_popup_modification_type,Type);
		
		WaitStatementsLib.iWait(1);
		Txt_popup_modification_num.clear();
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		type(Txt_popup_modification_num,Number);
		
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		Txt_popup_modification_revision_num.clear();
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		type(Txt_popup_modification_revision_num,rNumber);
		
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		Txt_popup_modification_url.clear();
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		type(Txt_popup_modification_url,url);
		
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		Txt_popup_modification_Designation.clear();
		WaitStatementsLib.iWaitForSeconds(driver, 15);
		type(Txt_popup_modification_Designation,Designation);
		

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		
		// Values are editable 
		public void ValidatefieldsUneditable() throws Exception {
			
			try {
		WaitStatementsLib.iWait(5);
		TestUtil.isEditableWithAllAttri(Ctl_family_structure_type);
		TestUtil.isEditableWithAllAttri(Txt_family_family_name);
		TestUtil.isEditableWithAllAttri(Txt_family_family_code);
		TestUtil.isEditableWithAllAttri(Txt_family_family_function);
							

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	
		// Presence of Edit ,Open and Delete button
		public void ValidatePresenceOfButton() throws Exception {
			
			try {
		WaitStatementsLib.iWait(5);
		Assert.assertTrue(isElementPresent(ObjectUtil.getGenericXpathForBtn("Delete")),"Refresh button not present");
		Assert.assertTrue(isElementPresent(ObjectUtil.getGenericXpathForBtn("Edit")),"Refresh button not present");
		Assert.assertTrue(isElementPresent(ObjectUtil.getGenericXpathForBtn("Open")),"Refresh button not present");
							

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}		

		// Validated the popup in open mode
		public void ValidatepopupOpenMode() throws Exception {
			
			try {
				TestUtil.isEditableWithAllAttri(Txt_popup_modification_type);				
				TestUtil.isEditableWithAllAttri(Txt_popup_modification_num);
				TestUtil.isEditableWithAllAttri(Txt_popup_modification_revision_num);
				TestUtil.isEditableWithAllAttri(Txt_popup_modification_url);
				TestUtil.isEditableWithAllAttri(Txt_popup_modification_Designation);
						

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		
		
		//Validity for modification popup
		public Boolean validate_button_activation() {
			value = btn_modification_popup_validate.isSelected();
			return value;

		}
		
		//Validity for ratings popup		
		public Boolean validate_button_activationforRating() {
			value = btn_pf_validate_popup.isSelected();
			return value;

		}
		
		//Enter the code under ratings 		
		public void ValidateNonEditableRatings() throws IOException {
			TestUtil.isEditableWithAllAttri(txt_pf_rating_popup_code);
			TestUtil.isEditableWithAllAttri(txt_pf_rating_popup_name);

		}
		
		public void deletePropertyValuesData(String PropertyKey) throws IOException {

			List<WebElement> total_rows = driver.findElements(By.xpath(ObjectUtil.getResultListXpathUsingId("catalog_values_tbl")));
			int prev = total_rows.size();
			System.out.println("prev total_rows : " + prev);

			click(ObjectUtil.DeleteModalFooterButton("Yes"));

			WaitStatementsLib.iWait(2);

			getWeblement(ObjectUtil.getFilterXpath()).clear();
			WaitStatementsLib.iWait(5);
			type(ObjectUtil.getFilterXpath(), PropertyKey);
			
			WaitStatementsLib.iWait(2);
			
			total_rows = driver.findElements(By.xpath(ObjectUtil.getResultListXpathUsingId("catalog_values_tbl")));
			int after = total_rows.size();
			System.out.println("after total_rows after deletion : " + after);
			Assert.assertTrue(after == prev - 1, "Row in not deleted from 'Property Values' table");
		}
		

}
