Feature: Signup

  @regression @smoke @signup
  Scenario: Sign up
    Given I am at talentTEK Home Page
    And I click on Create New Account button
    And I filled out the form with valid information
    And I clicked on agree checkbox
    When I click Create My Account button
    Then I will verify Thank you message


  @regression @smoke @signup
  Scenario: Sign up and then sign back in with studentId
    Given I am at talentTEK Home Page
    And I click on Create New Account button
    And I filled out the form with valid information
    And I clicked on agree checkbox
    And I click Create My Account button
    And I will store the dynamic studentId
    And I click on Login Link
    And I login with newly created studentId Info
    When I click on Log In button
    Then I will verify my profile info


