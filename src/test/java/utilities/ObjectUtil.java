package utilities;

import java.io.IOException;

import base.BaseTest;
import base.WaitStatementsLib;

public class ObjectUtil extends BaseTest{

	public static String xpathToTabContainer="//aw-tab-container[@class='ng-star-inserted']";
	
	/**
	 * Gets Xpath of all the button. Just pass name of the button
	 * 
	 * @param buttonText
	 * @return
	 */
	public static String getButtonXpath(String buttonText) {
		return "//span[contains(.,'" + buttonText + "') and contains (@class,'button')]";
	}

	/**
	 * gets xpaths for pageHeading
	 * 
	 * @param heading
	 * @return
	 */
	
	public static String getXpathForPageHeading(String heading) {
		return "//aw-breadcrumb//a[contains(.,'"+heading+"')][last()]";
		
	}

	/**
	 * perform click on dropdown and then selects value
	 * 
	 * @param sectionHeading
	 * @param labelName
	 * @param valueToSelect
	 * @param generictext
	 */
/*	public static void SelectValueDromDropDown(String sectionHeading, String labelName, String valueToSelect,
			String generictext) {
		String xpathToDropDown = "//h4[contains(.,'" + sectionHeading + "')]/..//label[contains(.,'" + labelName
				+ "')]/..//div[contains(@class,'dropdown-trigger')]";
		String xpathToValue = "//li/span[contains(.,'" + valueToSelect + "')]";
		commonMethods common= new commonMethods();
		common.clickJS(By.xpath(xpathToDropDown), generictext);
		common.clickJS(By.xpath(xpathToValue), valueToSelect);

	}
	*/
	public static String getXpathLabel(String label) {
		return "//label[contains(text(),'"+label+"')]";
	}
	
	public static String getInputboxXpath(String label) {
		return "//label[contains(text(),'"+label+"')]/..//input";
	}
	
	public static String getXapthInputbox(String label) {
		return xpathToTabContainer + "//label[contains(text(),'"+label+"')]/..//input";
	}
	
	public static String getXapthInputCheckbox(String label) {
		return xpathToTabContainer + "//label[contains(text(),'"+label+"')]/..//p-checkbox";
	}
	
	public static String getXapthInputCheckboxVisible(String label) {
		return xpathToTabContainer + "//*[contains(text(),'"+label+"')]/..//..//td[3]//p-checkbox";
	}
	
	public static String getTextAreaXpath(String label) {
		return "//label[contains(text(),'"+label+"')]/..//textarea";
	}
	
	public static String getPopupHeaderXpath(String label) {
		return "//a-header/child::*[contains(.,'"+label+"')]";
	}
	
	public static String getResultListXpath(String label) {
		return xpathToTabContainer+"//h3[contains(text(),'"+label+"')]/../../..//tbody/tr";
	}
	
	public static String getResultCountFromTableHeader(String label) {
		return xpathToTabContainer+"//h3[contains(text(),'"+label+"')]";
	}
	
	public static String getLabelXpath(String label) {
		return xpathToTabContainer+"//label[contains(text(),'"+label+"')]";
	}
	
	public static String getSearchIconXpathOfLabel(String label) {
		return "//label[contains(text(),'"+label+"')]/..//i[contains(@class,'search')]";
	}
	
	public static String getButtonXpathOnPopup(String popup,String btn) {
		return "//aw-dialog-"+popup+"//button/span[contains(.,'"+btn+"')]";
	}
	
	public static String getInputboxXpathOnPopup(String label,String popup) {
		return "//aw-dialog-"+popup+"//label[contains(text(),'"+label+"')]/..//input";
	}
	
	public static String getButtonXpathTagBtn(String buttonText) {
		return "//button[contains(.,'" + buttonText + "')]";
	}
	
	public static String getButtonXpathButton(String buttonText) {
		return xpathToTabContainer+"//button[contains(.,'" + buttonText + "')]";
	}
	
	public static String getElementXpath(String name) {
		return xpathToTabContainer+"//*[contains(text(),'"+name+"')]";
	}
	
	public static String getGenericXpathForBtn(String name) {
		return "//*[contains(text(),'"+name+"')][contains(@class,'button')]";		
	}	
	
	public static String getElementXpathOnPopup(String name) {
		return "//a-modal//span[contains(.,'"+name+"')]";
	}
	
	public static String getDropdownXpathOnPopup(String name) {
		return "//a-modal//label[contains(text(),'"+name+"')]/parent::*//*[contains(@class,'chevron-down')]";
	}
	
	public static String getBtnXpathOnStatusPopup(String name) {
		return "//aw-object-status//button[contains(.,'"+name+"')]/span";
	}
	
	public static String getInputboxXpathOnPopup(String label) {
		return "//a-modal//label[contains(text(),'"+label+"')]/..//input";
	}
	
	public static String getTableCountXpath(String table) {
		return "//h3[contains(.,'"+table+"')]/../../..//span[contains(@class,'table-count')]";
	}
	
	public static String getTotalRowsXpath(String table) {
		return "//h3[contains(.,'"+table
				+"')]/../../..//div[contains(@class,'table-body')]//div[contains(@class,'table-row')]";
	}
	
	public static String selectedRowXpath(String table) {
		return "//h3[contains(.,'"+table
				+"')]/../../..//div[contains(@class,'table-body')]//div[contains(@class,'row selected')]";
	}
	
	public static String xpathToGetAllHeaders(String table) {
		return "//h3[contains(.,'"+table
				+"')]/../../..//div[contains(@class,'table-header')]//div[contains(@class,'cell-content')]";
	}
	
	public static String xpathToGetSelectedRowColumnValues(String table) {
		return "//h3[contains(.,'"+table
				+"')]/../../..//div[contains(@class,'table-body')]//div[contains(@class,'row selected')]//div[contains(@class,'content')]";
	}
	
	public static String getTotalRowsXpath(String table,int colIndex) {
		return "//h3[contains(.,'"+table
				+"')]/../../..//div[contains(@class,'table-body')]//div[contains(@class,'table-row')]/div["+
				colIndex+"]/div";
	}
	
	public static String searchIconXpathOnPopup() {
		return "//a-modal//i[contains(@class,'icon-search')]";
	}
	
	public static String searchIconXpathOnPage() {
		return "//a-modal//i[contains(@class,'icon-search')]";
	}

		
	public static String getDropdownXpathUnderSection(String section,String name) {
		return "//div[normalize-space()='"+section+"']//label[contains(text(),'"+name+"')]/parent::*//*[contains(@class,'chevron-down')]";
	}

	public static String getXpathOfButtonOnPopup(String popupName,String btnName){
		return "//a-modal//div[contains(text(),'"+popupName+"')]/../../..//span[contains(.,'"+btnName
						+"') and contains (@class,'button')]";
	}

// Admin_Monitoring
	
	
	public static String getXpathDropDownElement(String labelName) {
		return "//label[contains(.,'" + labelName + "')]/..//div[contains(@class,'dropdown-trigger')]";		
	}
	
	public static String getXpathDropDownElement1(String labelName) {
		return xpathToTabContainer +"//label[contains(.,'" + labelName + "')]/..//div[contains(@class,'dropdown-trigger')]";		
	}
	
	public static String getXpathMenuItem(String labelName) {
		return "//aw-main//button[contains(.,'" + labelName + "')]";		
	}
	
	public static String getXpathSubMenuItem(String labelName) {
		return "//aw-main//span[contains(.,'" + labelName + "')]";		
	}
	
	public static String getXpathPageHeading(String labelName) {
		return "//div[contains(.,'" + labelName + "')and contains (@class,'page-title')]";		
	}
	
	public static String getXpathDropDown(String labelName) {
		return xpathToTabContainer +"//label[contains(.,'"+labelName+"')]/..//p-dropdown[contains(@class,'aw-dropdown')]";		
	}
	
	public static String getXpathGlobalFilter(String popup) {
		return "//aw-dialog-"+ popup +"//label[contains(@class,'global-filter')]/..//input";
		
	}
	
	public static String getXpathSelectfirstRow(String popup, String value) {
		return "//aw-dialog-"+ popup +"//tr[contains(@class,'p-selectable-row')]/td/span[contains(.,'"+ value+"')]";		
	}
	
	public static String getXpathforTableButton(String value) {
		
		return "//aw-dialog-table//button/span[contains(.,'"+ value +"')]";		
	}
	
	public static String getXpathforBackButton() {		
		return "//button[contains(@class,'back mat-icon-button')]";		
	}
	
	public static String getXpathforSearchResults() {		
		return xpathToTabContainer+"//td[contains(@class,'p-resizable-column')]";		
	}
	
	public static String getXpathforSearchCheckbox() {		
		return xpathToTabContainer+"//tr[contains(@class,'p-selectable-row')]/..//mat-checkbox";		
	}
	
	//*********23-12-2020*************
	// Admin_Monitoring
		public static String getXpathOfButtonOncontainer(String name){
			return "//aw-main//div[(contains(@class,'submenu-entry'))]//span[contains(.,'"+name+"')]";
		}

		public static String getElementXpathOnPopupHeader(String name) {
			return "//a-modal//a-header//div[contains(.,'"+name+"')]";
		}

		public static String getElementXpathOntab(String name) {
			return xpathToTabContainer+"//div[@role='tablist'] //div[contains(text(),'"+name+"')]";
		}
		
		public static String SelectValueLog4jConf(String Log4jConfiguration, String action) {
			return xpathToTabContainer+"//label[contains(text(),'"+Log4jConfiguration+"')]//..//..//span[contains(text(),'"+action+"')]";

		}
		
		// Licensing
		public static String Licensing_alertIcon() {
			return ".//*[contains(@class,'alertIcon')]";

	}
		
		
		public static String SelectLabelLog4jConf() {
			return xpathToTabContainer+"//h4[contains(text(),' Log4j Configuration ')]//..//label";

		}
		
		public static String CheckLabelLog4jConf(int i) {
			return xpathToTabContainer+"h4[contains(text(),' Log4j Configuration ')]//..//div[i]//label";

		}
		
		// Workflow Management
		
			public static String getspanLabelXpath(String label) {
				return xpathToTabContainer+"//span[contains(.,'"+label+"')]";
			}
			
			public static String gettdLabelXpath(String label) {
				return xpathToTabContainer+"//td[contains(.,'"+label+"')]";
			}

			public static String getFilterXpath() {
				return xpathToTabContainer+"//input[contains(@placeholder,'Type to filter the table below')]";
			}
			
		public static void SelectValueDromDropDown(String labelName, String valueToSelect) throws IOException {
			System.out.println("2");
			String xpathToDropDown = "//label[contains(.,'" + labelName+ "')]/..//div[contains(@class,'dropdown-trigger')]";
			String xpathToValue = "//li/span[contains(.,'" + valueToSelect + "')]";

			click(xpathToDropDown);
			WaitStatementsLib.iWaitForSeconds(driver, 10);
			click(xpathToValue);
			
				}
		public static String getFilterWithHeadingXpath(String sectionHeading) {
			return "//h4[contains(.,'" + sectionHeading + "')]/..//input[contains(@placeholder,'Type to filter the table below')]";

		}		
			
		public static String getcheckboxH3Xpath(String sectionHeading,String Name) {
			return xpathToTabContainer+"//h3[contains(text(),'"+sectionHeading+"')]/../../..//tbody/tr[contains(.,'"+Name+"')]//p-checkbox";

		}
			public static String getcheckboxVisibleXpath(String sectionHeading,String Name) {
			return xpathToTabContainer+"//h3[contains(text(),'"+sectionHeading+"')]//..//..//..//tbody/tr[contains(.,'"+Name+"')]//p-checkbox";	

			}
				public static String getcheckboxResdXpath(String sectionHeading,String Name) {
			return xpathToTabContainer+"//h3[contains(text(),'"+sectionHeading+"')]//..//..//..//tbody/tr[contains(.,'"+Name+"')]/td[4]//p-checkbox";	

			}
			public static String getcheckboxMandatoryXpath(String sectionHeading,String Name) {
			return xpathToTabContainer+"//h3[contains(text(),'"+sectionHeading+"')]//..//..//..//tbody/tr[contains(.,'"+Name+"')]/td[5]//p-checkbox";	

			}	
		public static String getcheckboxH4Xpath(String sectionHeading,String Name) {
			return xpathToTabContainer+"//h4[contains(text(),'"+sectionHeading+"')]//..//..//..//tbody/tr[contains(.,'"+Name+"')]//p-checkbox";

		}		
		
		// Workshop
		
			public static String getLabelH4Xpath(String sectionHeading,String Name) {
			return 
			"//h4[contains(text(),'"+sectionHeading+"')]/..//..//span[contains(text(),'"+Name+"')]";

		}	
			public static String getLabelH3Xpath(String sectionHeading,String Name) {
			return 
			"//h3[contains(text(),'"+sectionHeading+"')]/..//..//span[contains(text(),'"+Name+"')]";

		}
		    public static String getLabeldivlabelXpath(String sectionHeading,String Name) {
			return "//div[contains(text(),'"+sectionHeading+"')]/..//label[contains(.,'"+Name+"')]";

		}
		
			public static String getLabeldivXpath(String sectionHeading) {
			return "//div[contains(text(),'"+sectionHeading+"')]";

		}
		
			public static void SelectValueDromDropDownpopup(String labelName, String valueToSelect) throws IOException {
				String xpathToDropDown = "//a-modal//label[contains(.,'" + labelName
						+ "')]/..//div[contains(@class,'dropdown-trigger')]";
				String xpathToValue = "//li/span[contains(.,'" + valueToSelect + "')]";
				WaitStatementsLib.iWaitForSeconds(driver, 10);
				BaseTest.clickjs(xpathToDropDown);
				WaitStatementsLib.iWaitForSeconds(driver, 10);
				BaseTest.clickjs(xpathToValue);
				
					}
					
			
			public static void SelectValueDromDropDownHeading(String sectionHeading,String labelName, String valueToSelect) throws IOException {
				String xpathToDropDown = "//div[contains(text(),'"+sectionHeading+"')]/..//label[contains(.,'"+labelName+"')]/..//div[contains(@class,'dropdown-trigger')]";
				String xpathToValue = "//li/span[contains(.,'" + valueToSelect + "')]";
				WaitStatementsLib.iWaitForSeconds(driver, 10);
				BaseTest.clickjs(xpathToDropDown);
				WaitStatementsLib.iWaitForSeconds(driver, 10);
				BaseTest.clickjs(xpathToValue);
				
					}
			public static String getResultListh4Xpath(String label) {
				return xpathToTabContainer+"//h4[contains(text(),'"+label+"')]/../..//tbody/tr";

		}
			public static String getSameButtonXpath(String sectionHeading, String Name) {
				return "//h4[contains(text(),'"+sectionHeading+"')]/../..//span[contains(.,'"+Name+"') and contains (@class,'button')]";

		}
			
	// Delete
			public static String DeleteModalTitle() {
				return ".//aw-confirm-dialog//*[contains(@class,'header')]/a-header";

		}
			
			public static String DeleteModalContent() {
				return ".//aw-confirm-dialog//*[contains(@class,'content')]/a-content";

		}
			public static String DeleteModalFooterButton(String Name) {
				return ".//aw-confirm-dialog//*[contains(@class,'footer')]//*[contains(text(),'"+Name+"')]";

		}
	//Warehouse
			public static String getLabelH3DivXpath(String sectionHeading,String Name) {
			return 
			"//h3[contains(text(),'"+sectionHeading+"')]/..//..//..//div[contains(text(),'"+Name+"')]";

		}
			public static String getLabelH3layerXpath(String sectionHeading,String Name) {
			return 
			"//h3[contains(text(),'"+sectionHeading+"')]/..//..//..//span[contains(text(),'"+Name+"')]";
			}
			
			public static String getElementlabelXpathOnPopup(String name) {
				return "//a-modal//label[contains(.,'"+name+"')]";
			}
			public static String getElementStorageXpath(String name) {
				return "//app-administration-storage-bin-list//*[contains(text(),'"+name+"')]";
			}
			
			//Attribute
			public static String getElementattdropdown() {
				return "//aw-attributes-search//span[contains(@class,'chevron-down')]";
			}
			public static String SelectElementattDDvalue(String value) {
				return "//li/span[contains(.,'" + value + "')]";
			}
			public static String getElementattAlert() {
				return "//div[contains(@role,'alert')]";
			}
			public static String getElementattgenDropdown(String labelName) {
				return "//label[contains(.,'" + labelName+ "')]/..//div[contains(@class,'dropdown-trigger')]";
			}
			public static String getElementattDDvalue() {
				return "//aw-attributes-search//span[contains(@class,'chevron-down')]//..//..//span";
			}
			public static String getElementattImportFile() {
				return "//input[contains(@accept,'defined')]";
			}
			
			
			//***Login***
			public static String getXPathAerowebbLogo() {
				return "//button[contains(@class,'logo-wrapper')]";
			}
			
			public static String getXPathHomeMenuLabel() {
				return "//div[contains(@class,'menu-entry-wrapper ng-star-inserted')]//div";			
			}
			
			public static String getXPathHomeMenuLabelSpan() {
				return "//div[contains(@class,'menu-entry-wrapper ng-star-inserted')]//div/span";			
			}
	////Ids
			public static String getElementXpathOntabIds(String name,String ids) {
				return xpathToTabContainer+"//..//*[@id='"+ids+"']//*[@role='tablist']//*[contains(text(),'"+name+"')]";
			}
	
			public static String getResultListXpathUsingId(String ids) {
				return xpathToTabContainer+"//*[@id='"+ids+"']/../../..//tbody/tr";
				
			}
			
			public static String getSelectButtonXpathUsingId(String ids,String name) {
				return xpathToTabContainer+"//*[@id='"+ids+"']//*[contains(text(),'"+name+"')]";
				
			}
			public static String getResultElementXpathUsingId(String ids) {
				return xpathToTabContainer+"//*[@id='"+ids+"']/../../..//tbody/tr/td";
				
			}
			public static String getResultElementdetailsXpathUsingId(String ids) {
				return xpathToTabContainer+"//*[@id='"+ids+"']/..//tbody/tr/td";
				
			}
			
			
			public static String goBackToPreviousPage() {
				return "//button[contains(@aria-label,'Back to previous page')]";
			}

			public static String SearchInTable(String ListContainer) {
				return xpathToTabContainer+"//"+ListContainer+"//input[contains(@placeholder,'Search in table')]";
			}
			
			public static String SearchInTableWithId(String Id) {
				return xpathToTabContainer+"//*[@id='"+Id+"']//input[contains(@placeholder,'Search in table')]";
			}	

			public static String SearchTabelHeaderNew(String ListContainer) {
				return "//"+ListContainer+"//*[contains(@class,'table-header')]";
			}	
	
			public static String SearchTabelBodyNew(String ListContainer) {
				return "//"+ListContainer+"//*[contains(@class,'table-body')]";
			}
			
			public static String SearchTabelNewVisibleRow(String Id) {
				return xpathToTabContainer+"//*[@id='"+Id+"']//*[contains(@class,'body')]//*[(@class='yac-table-row')]";
			}

			
			public static String SearchTabelButtonNew(String ListContainer, String name) {
				return "//"+ListContainer+"//*[contains(@class,'actions')]//*[contains(text(),'"+name+"')]";
			}
		
			public static String XpathOnSelectButtonIds(String name,String ids) {
				return xpathToTabContainer+"//*[@id='"+ids+"']//*[contains(text(),'"+name+"')]";
			}
			// Profile
			public static String PermissionLevel(String name) {
				return xpathToTabContainer+"//*[@id='profiles_form_buildingBlock_tab']//*[@aria-hidden='false']//*[@class='row ng-star-inserted'][1]//*[@aria-label='"+name+"']";
			}
			public static String ClickTableElement(String name) {
				return xpathToTabContainer+"//app-administration-profiles-list//*[@class='yac-table-row']//*[contains(text(),'"+name+"')]";
			}
			
			// Attribute
			public static String SelectValueFromTable(String Value) {
				return xpathToTabContainer+"//td[contains(text(),'"+Value+"')]";
			}

			public static String SelectTitleFromTable(String Value) {
				return xpathToTabContainer+"//*[contains(text(),'"+Value+"')]/../../..//thead/tr";
			}	
			public static String SelectAllTitleFromTable(String Value) {
				return xpathToTabContainer+"//h3[contains(text(),'"+Value+"')]/../../..//thead/tr/th";
			}
			public static String SelectAllRowTable(String ListContainer) {
				return xpathToTabContainer+"//"+ListContainer+"//*[contains(@class,'table-body')]//*[(@class='yac-table-row')]/div";
			}
			
			public static String SelectValueFromTable(int RowNum,int ColNum ) {
				return xpathToTabContainer+"//table/tbody/tr["+RowNum+"]/td["+ColNum+"]";
			}

			public static String ClickAttributeToOpen(String Name) {
				return xpathToTabContainer+"//a[contains(text(),'"+Name+"')]";
			}
			public static String ClickTableElemetntToDelete(String Name) {
				return xpathToTabContainer+"//a[contains(text(),'"+Name+"')]/parent::div";
			}
			
			public static String ClickTableElemetntToDelete(String Name,String ids) {
				return xpathToTabContainer+"//*[@id='"+ids+"']//a[contains(text(),'"+Name+"')]/parent::div";
			}
			public static String ClickTableElemetntToDeleteOld(String Name,String ids) {
				return xpathToTabContainer+"//*[@id='"+ids+"']//*[contains(@class,'tbody')]//*[contains(text(),'"+Name+"')]";
			}
			
			public static String SelectResultfromOldTable(String ListContainer) {
				return xpathToTabContainer+"//"+ListContainer+"//*[contains(@class,'body')]/tr";
			}
	
			public static String SelectResultfromNewTable(String ListContainer) {
				return xpathToTabContainer+"//"+ListContainer+"//*[contains(@class,'table-body')]//*[(@class='yac-table-row')]/div";
			}
			
			public static String SelectResultfromNewTableWithId(String ids) {
				return xpathToTabContainer+"//*[@id='"+ids+"']//*[contains(@class,'table-body')]//*[(@class='yac-table-row')]/div";
			}

			public static String SelectSelectiveTitleFromTable(String Value, int i) {
				return xpathToTabContainer+"//h3[contains(text(),'"+Value+"')]/../../..//thead/tr/th["+i+"]";
				
			}
			
			public static String SelectFirstRowFromTable() {
				return xpathToTabContainer+"//*[contains(@class,'tbody')]/tr[1]";
				
			}
			
			public static String SelectTitleRowFromTable() {
				return xpathToTabContainer+"//*[contains(@class,'thead')]/tr/th";
				
			}
			
			public static String SelectTitleRowFromTableWithId(String id) {
				return xpathToTabContainer+"//*[@id='"+id+"']//*[contains(@class,'thead')]/tr/th";
				
			}
			public static String AfterSaveErrorMsg() {
				return "//*[contains(text(),'Please fill all required fields')]";
				
			}
			public static String SelectAllElementFromTable() {
				return xpathToTabContainer+"//*[contains(@class,'tbody')]/tr/td";
				
			}
			
			public static String SelectAllElementFromTable(String label) {
				return xpathToTabContainer+"//*[contains(text(),'"+label+"')]/parent::*//td";
				
			}
			
			public static String SelectMessage(String message) {
				return ".//div[contains(text(),'"+message+"')]";
				
			}
			public static String getXpathLabelwithContainer(String ListContainer, String label) {
				return xpathToTabContainer+"//"+ListContainer+"//label[contains(text(),'"+label+"')]";
				
			}
			public static String getXpathInputwithContainer(String ListContainer, String label) {
				return xpathToTabContainer+"//"+ListContainer+"//label[contains(text(),'"+label+"')]/..//input";
				
			}
			
			public static String getXpathDDwithContainer(String ListContainer, String label) {
				return xpathToTabContainer+"//"+ListContainer+"//label[contains(text(),'"+label+"')]/..//p-dropdown";
				
			}
			public static String getXpathChkwithContainer(String ListContainer, String label) {
				return xpathToTabContainer+"//"+ListContainer+"//label[contains(text(),'"+label+"')]/..//p-checkbox";
				
			}
			public static String getXpathButtonWithDdWithIds(String ids, String name) {
				return xpathToTabContainer+"//*[@id='"+ids+"']//*[contains(@class,'chevron-down')]";
				
			}
			
			public static String XpathOnSelectButtonRole(String name) {
				return "//*[contains(@role,'menuitem')]//*[contains(text(),'"+name+"')]";
			}
			
			public static String XpathOnSelectTreeStructure(String ids,int i,int j) {
				return xpathToTabContainer+"//*[@id='"+ids+"']//*[@class='p-treetable-tbody']/tr["+i+"]/td["+j+"]//span";
			}

			public static String XpathOnSelectTreeStructureButton(String ids,int i) {
				return xpathToTabContainer+"//*[@id='"+ids+"']//*[@class='p-treetable-tbody']/tr["+i+"]//button";
			}
			
			public static String getFilterXpathWithId(String ids) {
				return xpathToTabContainer+"//*[@id='"+ids+"']//input[contains(@placeholder,'Type to filter the table below')]";
			}

			public static String getButtonXpathWithId(String buttonText, String ids) {
				return "//*[@id='"+ids+"']//span[contains(.,'" + buttonText + "') and contains (@class,'button')]";
			} 
			
			public static String getXapthInputDropdownId(String label,String ids) {
				return xpathToTabContainer+"//*[@id='"+ids+"']//label[contains(text(),'"+label+"')]/..//p-dropdown";
			}

			public static String getXapthInputCheckboxId(String label,String ids) {
				return xpathToTabContainer+"//*[@id='"+ids+"']//label[contains(text(),'"+label+"')]/..//p-checkbox";
			}
			
			public static String getXapthInputCheckboxId1(String label,String ids) {
				return xpathToTabContainer+"//*[@id='"+ids+"']//*[contains(text(),'"+label+"')]/..//p-checkbox";
			}

			
			public static String getXapthLabelId(String label,String ids) {
				return xpathToTabContainer+"//*[@id='"+ids+"']//*[contains(text(),'"+label+"')]";
			}
			
			public static String getXapthdateSelect(int date) {
				return "//table[contains(@class,'datepicker-calendar')]//span[text()='"+ date +"']";
			}
			
			public static String getXapthselectTabWithId(String ids,String label) {
				return "//*[@id='"+ids+"']//*[contains(text(),'"+label+"')]";
			}
			
			public static String getUserdropdown(int date) {
				return "//*[contains(@class,'with-dropdown active')]";
			}
			
			public static String getXapthselectTabWithoutId(String label) {
				return "//*[contains(text(),'"+label+"')]";
			}
}
