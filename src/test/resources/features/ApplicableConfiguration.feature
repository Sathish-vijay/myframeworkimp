Feature: AeroWeb ApplicableConfiguration Feature File

  @TC02_ApplicableConfiguration @Regression 
  Scenario: ApplicableConfiguration Module end to end Regression
    Given User navigated to login page
    When User enter Username and Password
    And Select given Workspace and Language
    And click on connect button
    Then verify user logged in successfully
    When click on "Engineering Data" Tab
    And select "Applicable Configuration" option
    Then ac verify user navigated to "Applicable Configuration" page
# Create 
	Then click on Create button to create Applicable Configuration
    And ac verify there is "Home" tab
    And ac verify there is Main Information heading
	Then ac verify the fileds present under Main Information
#	| Family code | Family function  | Variant code | Variant name | Structure type | Variant revision date | Variant revision number |
	Then ac verify the mandatory fileds present under Main Information
#	| Family code | Variant code | Variant name |
	Then ac enter values in fileds present under Main Information
#	| Family code | Variant code | Variant name | Variant revision date | Variant revision number |
    And ac verify there is Item Structure heading
    Then ac navigate to "Airworthiness Documents" tab	
	And ac verify there is "Airworthiness Documents (0)" heading
	And ac verify the Airworthiness Documents table columns
#   | Number |Revision Number |Designation |Document |Type |Approval Date |
	Then click on Add button present under Airworthiness Documents
	Then ac verify the fileds present under Document Matching
#	| Document | Number  | Revision Number | Approval Date |
	Then ac verify the mandatory fileds present under Document Matching
#	| Document | Number  | Revision Number |
	Then ac enter values in fileds present under Document Matching
#	| Document | Number  | Revision Number | Approval Date |
    Then ac navigate to "Documents" tab	
	And ac verify there is "Documents Matching (0)" heading under Documents
	And ac verify the Documents Matching table columns
#   | Evol. N | Evol.Rev.N |Family Code | Structure Type |Mod.Type |Mod. N |Mod. Rev.N |Airwoth Doc N | Airworth. Doc.Rev.N
    Then ac click on "Evolution Interdependences" tab	
	And ac verify there is " Evolutions Interdependences (0) " heading under Evolution Interdependences
	And ac verify the Evolutions Interdependences table columns
#   | Family Code | Variant Code | Evol.N | Evol Rev.N | Interdependence | Evol. N | Evol. Rev. N. |
    Then ac click on "Disassembly Groups" tab	
	And ac verify there is Disassembly Groups & Removal Orders heading under Disassembly Groups
	And ac verify there is table "Disassembly Groups List (0)" and "Removal Orders List (0)" heading under Disassembly Groups	
	And ac verify the Disassembly Groups table columns
#   |  Family Code | Variant Code | Disassembly group |
	And ac verify the Removal Orders table columns
#   |  Disassembly group before | Disassembly group after |
	Then ac click on Add button present under Disassembly Groups
	And ac verify the Popup Disassembly Group Management	
	And ac Enter1 the values in field Disassembly Group 
	And ac click on validate button under Disassembly Group 
	Then ac click on Add button present under Disassembly Groups
	And ac Enter2 the values in field Disassembly Group 
	And ac click on validate button under Disassembly Group 
	Then ac click on Add button present under Disassembly Groups
	And ac Enter3 the values in field Disassembly Group 
	And ac click on validate button under Disassembly Group
	Then ac Select a row under Disassembly Group
	And ac click on Open button under Disassembly Group 
	And ac verify Popup Disassembly Group Management in read only Mode
	And ac click on close under Disassembly Group
	And ac click on display Status button under Disassembly Group 
	And ac verify Popup Status and select status for Disassembly Group
	And ac click on close status for Disassembly Group
	Then ac click on Delete button present under Disassembly Groups
	And ac click on Yes button under Confirm deletion popup
	And ac verify the Removal Orders table columns
#   |  Code | Title | Description | Hourly rate |
	Then ac click on Add button present under Removal Order
	And ac verify the Popup Removal Order Management	
	And ac Enter the values in fields Disassembly group before and after
	And ac click on validate button under Removal Order
	Then ac Select a row under Removal Order
	And ac click on Open button under Removal Order
	And ac verify Popup Removal Order in read only Mode
	And ac click on close under Removal Order
	And ac click on display Status button under Removal Order
	And ac verify Popup Status and select status for Removal Order
	And ac click on close status for Removal Order
	Then ac click on Delete button present under Disassembly Groups
	
	
	Then ac click on "Additional Information" tab	
	And ac verify there is OEM Partners & Associated Qualification heading under Additional Information
	And ac verify there is table "OEM Partners List (0)" and "Associated Qualification List (0)" heading under Additional Information	
	And ac verify the Disassembly Groups table columns
#   |   OEM Partner |  Item Min Range | Item Max Range |
	
    Then ac click on "Attributes" tab	
    And ac verify there is Attributes heading under Attributes
    Then ac click on "Attributes" tab	
    And click on Save button & Verify the message when a user Saved Applicable Configuration Successfully


