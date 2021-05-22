Feature: AeroWeb Item Feature File

  @Item @Regression 
  Scenario: Item Module end to end Regression
    Given User navigated to login page
    When User enter Username and Password
    And Select given Workspace and Language
    And click on connect button
    Then verify user logged in successfully
    When click on "Engineering Data" Tab
    And select "Item" option
    Then verify user navigated to Item page
#    Creation of Product Family
    And click on Create button to create Item
    Then item verify the name of the page Item
    And item verify there is "Home" tab           
    And item verify there is "Main Information" heading
    And item verify below Main Information fields
#	   | Family Variant | Item Code | Item Family | Item Type | Function Code | Serialized part | Designation | FLoc Type | Item Number | Life Restriction Type |	
    And item verify mandatory Main Information fields
#	   | Family Variant | Item Code |
    And item enter below Main Information fields
#	   | Item Family | Item Type | Function Code | Serialized part | Designation | FLoc Type | Item Number | Life Restriction Type |
   	And click on Save button & Verify the message when mandatory fields not filled
    And item enter below mandatory Main Information fields
#	   | Family Variant | Item Code |
    And item click on is "Additional Information" tab	   
    And item verify below Main additional Information fields
#	   | Replaceable Unit Type | Disassembly Group | Level | Is head of group | Visible on Inspection| In MEL / CDL |
#    | Is Illustrated | Attaching Part | Configurable Item | Is class item | Fixed element | Comment | Refer for NHA | Refer to |
    And item click on is "Structure" tab	
    And item click on is "Measures" tab	
    And item click on is "Task, Damages and Locations" tab	
    And item click on is "Maintenance" tab	
    And item click on is "Attributes" tab
    And item click on is "Additional Information" tab	
    Then item Enter the details in all the fields
	  And click on Save button & Verify the message when a user save Item successfully	
    # Search of Product Family
    When click on Back button
    Then item verify user is navigated to "Item" search page
    And item verify title of search field as "Search"
    Then item click on Expand criteria to expend more option
    And item verify Presence of search fields 
#	    | Chapter | Section | Subject | Sheet | Marks | Designation | Item Family | Function Code |
#     | Item Number | Item Type | Floc Type | Associated Part | Only MEL / CDL Items |
    And item enter values in search fields 
#	    | Chapter | Section | Subject | Sheet | Marks | Designation | Item Family | Function Code |
#     | Item Number | Item Type | Floc Type | Associated Part | Only MEL / CDL Items |
    Then item click on search button
	  And item verify title of table as "Results"
    And item verify Presence of Results table columns 
#	    | Item Code | Family Variant | Item Family | Function Code | Item Number |
    Then pf verify Search results are available under Results table 
    And pf verify execution completed successfully	  