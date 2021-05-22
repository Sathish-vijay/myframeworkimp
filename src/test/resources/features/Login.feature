Feature: AeroWeb login Feature File

  @Login @GUI
  Scenario: Login page verification
    Given User navigated to login page
    When User enter Username and Password
    And Select given Workspace and Language
    And click on connect button
    Then verify user logged in successfully