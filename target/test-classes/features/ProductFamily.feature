Feature: AeroWeb ProductFamily Feature File

  @ProductFamily @Regression 
  Scenario: ProductFamily Module end to end Regression
    Given User navigated to login page
    When User enter Username and Password
    And Select given Workspace and Language
    And click on connect button
    Then verify user logged in successfully
    When click on "Engineering Data" Tab
    And select "Product Family" option
    Then verify user navigated to Product Family page
    # Creation of Product Family
    And click on Create button
    Then pf verify the name of the page Product Family
    And  pf verify there is "Home" tab
    And  pf verify there is Main Information heading
    And  pf verify below Main Information fields
#	     | Family Code | Family Name | Structure Type | Family Function |
    And  pf verify uneditable mode of Structure Type control
    And  pf verify Presence of Modifications heading
    And  pf verify Presence of Modifications Table field
#	     | Modification Type | Modification Number | Modification Revision Number | Modification Document URL |	Designation | 
    When pf User enter Family Code and Family Name
    And pf Select given Family Function
    And pf Click on Add button under Modifications
    Then pf verify popup Modification Management heading
    And pf verify popup field under Modification Management
#	     | Modification Type | Modification Number | Modification Revision Number | Modification Document URL |	Designation |	
    When pf User enter Modification Document URL and Designation
    And pf verify Validate button is non-clickable under Modification Management
    When pf User enter below Modification Type and Modification Number and Modification Revision Number
    And pf click on Validate button under Modification Management
    Then pf verify Search results are available under Modifications table 
    And pf click on Save button
    Then verify pf message Family saved successfully
    # Search of Product Family
    When click on Back button
	Then click on pf refresh button
    Then pf verify user is navigated to "Product Family" search page
	And pf verify title of table as "Results"
    And pf verify Presence of Results table columns 
#	     | Family code | Family name | Structure type | Family function |
    When pf enter the value in searchText
    Then pf verify Search results are available under Results table 
    And pf verify execution completed successfully

    # Edit of Product Family
    And click on Family Code link
    Then pf verify the name of the page Product Family
    And pf verify there is "Home" tab
    And pf verify there is "Ratings" tab
    And verify below information displayed on home tab screen are non editable
#      |Family Code|Family Name|Structure Type|Family Function|
    And  verify Presence of Refresh button
    And  verify Presence of Edit button 
    Then click on Edit button
    And verify below information displayed on home tab screen are non editable
#      |Family Code|Structure Type|Family Function| 
    And pf Click on Add button under Modifications
    When pf User enter all the fields under Modifications popup
    And pf click on Validate button under Modification Management
    Then pf select row for Modification Management
    And pf verify Presence of Edit ,Open and Delete button
    Then pf click on Open button under Modifications
    And pf verify below information displayed on popup are non editable
#      | Modification Document URL | Designation | Modification Type | Modification Number | Modification Revision Number | 
    Then pf click on Close button
    Then pf click on Edit button under Modifications
    Then pf User Update all the fields under Modifications
#	     | Modification Type | Modification Number | Modification Revision Number | Modification Document URL |	Designation | 
    And pf click on Validate button under Modification Management
    And pf click on Delete button under Modifications
    Then pf verify deleted results is not available under Modifications table 
    When pf enter below value in Family Name
#      | PfName1Edit | 
    And pf click on Ratings tab 
    And pf verify Presence of heading "Ratings (0)"
    And pf verify Presence of Ratings table column  
#	| Rating Code | Rating Name |
    When pf clicked on Add button under Rating
    Then pf verify popup "Rating Management" is displayed for rating
    And pf verify Presence of Rating Code field
    And pf verify Presence Rating Name field 
    When pf User enter below Rating Name
#       | RName1 |
    And pf verify Ratings Validate button is non-clickable
    When User enter below Rating Code
#       | RCode11 |
    Then click on Ratings Validate button 
#    Then verify Search results are available under Ratings table 
    Then pf select row for Rating
    And pf verify Presence of Edit ,Open and Delete button
    Then pf click on Open button under Rating
    And pf verify below information displayed on Rating popup are non editable
#	| Rating Code | Rating Name |
    Then pf click on Close button for Rating
    Then pf click on Edit button under Rating
    And verify Rating Code is non editable
    When User enter new Rating Name
    Then click on Ratings Validate button 
	Then pf select row for Rating
#    Then verify Search results are available under Ratings table 
    Then pf click on Delete button under Rating
    And pf click on Save button
    Then verify pf message Family saved successfully
#    # Search of Product Family   
    When click on Back button
	Then click on pf refresh button
    Then pf verify user is navigated to "Product Family" search page
    When pf enter the value in searchText
    Then pf verify Search results are available under Results table after Edit
    Then select product family from result table  
    And verify Presence of Delete button product family
#    # Delete of Product Family
    And click on Delete button product family
    Then verify deleted results is not available under Ratings table      
    And pf verify execution completed successfully


    