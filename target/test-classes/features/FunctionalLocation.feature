Feature: AeroWeb FunctionalLocation Feature File

  @FunctionalLocation @Regression 
  Scenario: FunctionalLocation Module end to end Regression
    Given User navigated to login page
    When User enter Username and Password
    And Select given Workspace and Language
    And click on connect button
    Then verify user logged in successfully
#    When click on Engineering Data Tab
#    And select "Functional Location" option
#    Then verify user navigated to Functional Location page
# #    Creation of Product Family
#    And click on Create button to create Functional Location
#    Then fl verify the name of the page Functional Location
#    And fl verify there is "Home" tab           
#    And fl verify there is "Main Information" heading under Home
#    And fl verify below Main Information fields
##	   | FL Code | FL Description | FL Function | Nominal Quantity | Required Quantity | Is In MEL |
#    And fl verify there is "Items (0)" heading under Items
#    And fl verify below Items table column fields
##	   |  Family-Variant | Item Code |
#    And fl verify there is "Structure (0)" heading under Structure
#    And fl verify below Structure table column fields
##      | FL Code | FL Description | FL Function | Nominal Quantity | Required Quantity | Is In MEL |
#    And fl Enter value in below Main Information fields
##	   | FL Code | FL Description | FL Function | Nominal Quantity | Required Quantity | Is In MEL |
#    Then fl Click on Add button under Items
#    And click on search button under Search Item popup
#    And fl select value from Results table   
#    Then fl click on "Documentation" tab 
#    And fl verify there is "Documentation" heading under Documentation
#    And fl verify the below Documentation fields
##	   | Name | Description |  
#    Then fl click on upload button and select document
#    And fl Add Description for document
#    And fl click on Save button
#    Then fl verify message Family saved successfully
#    Then fl click on "Home" tab 
#    And fl verify below information displayed on are non editable
##      | FL Code | FL Description | FL Function | Nominal Quantity | Required Quantity |
#    And fl click on Edit button
#    And fl update value in below Main Information fields
##	   | FL Code | FL Description | FL Function | Nominal Quantity | Required Quantity | Is In MEL |
#    Then fl select a row Items
#    And fl verify buttons displayed under Items
#    Then fl click on open button under Items
#    And fl verify popup Family-Variant Management in open mode
#    And fl click on close button to close popup Family-Variant
#    Then fl click on Edit button under Items
#    And click on search button under Search Item popup again
#    And fl select value from Results table again
#    Then fl select a row Items again
#    And fl click on Delete button under Items    
#    Then fl Click on Add button under Items
#    And click on search button under Search Item popup for new item
#    And fl select value from Results table for new item
##    Then fl select a row from Structure    
##    And fl verify buttons displayed under Structure    
#    Then fl click on "Documentation" tab 
#    And fl verify display of delete and Download button
#    Then fl click on download button to download the document
#    Then fl click on delete button to delete the document 
#    And fl click on Save button
#    Then fl verify message Family saved successfully 
#    # Search of Product Family   
    When click on Engineering Data Tab
    And select "Functional Location" option
    And fl verify the below Search fields under search page
#      | Family-Variant | FL Code | FL Function | FL Description | Model | Only MEL | 
    And fl Enter value in below Search fields
#	   | Family-Variant | FL Code | FL Function | FL Description | Model | Only MEL |
    And fl click on Search button
    And fl verify below Result table column fields
#      | FL Code | FL Description | FL Function | Is In MEL |  Nominal Quantity | Required Quantity | Order number |
    And fl verify search value present under Result table
    Then fl Click On FL Code present under Result table
    And fl verify below information displayed on are non editable
#      | FL Code | FL Description | FL Function | Nominal Quantity | Required Quantity |
    When click on Back button
    Then fl select a row under result
    And fl click on delete button
    Then fl verify message Family deleted successfully     
