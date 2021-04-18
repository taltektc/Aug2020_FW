Feature: Login with Parameters

  @Parameters
  Scenario: Sign up and then sign back in with studentId using Gherkin Datatable
    Given I am at talentTEK Home Page
    And I click on Create New Account button
    And I filled out the form using the following data table
      | Ashif  | Uzzaman | auzzaman@auzzaman.com | Test1234 | Test1234 | Feb | 7 | 1987 | Male |
    And I clicked on agree checkbox
    And I click Create My Account button
    And I will store the dynamic studentId
    And I click on Login Link
    And I login with newly created studentId Info
    When I click on Log In button
    Then I will verify my profile info


  @Parameters
  Scenario Outline: Sign up and then sign back in with studentId using scenario Outline
    Given I am at talentTEK Home Page
    And I click on Create New Account button
    And I filled out the form using the following <fName> <lName> <Email> <Password> <ConfirmPassword> <Month> <Day> <Year> <Gender>
    And I clicked on agree checkbox
    And I click Create My Account button
    And I will store the dynamic studentId
    And I click on Login Link
    And I login with newly created studentId Info
    When I click on Log In button
    Then I will verify my profile info

    Examples:
      |fName|lName|Email|Password|ConfirmPassword|Month|Day|Year|Gender|
      | Ashif  | Uzzaman | auzzaman@auzzaman.com | Test1234 | Test1234 | Feb | 7 | 1987 | Male |
      | Ashif1  | Uzzaman1 | auzzaman@auzzaman.com1 | Test12341 | Test12341 | Feb | 7 | 1987 | Female |

  @Parameters
  Scenario: As a user I can enter values in Gerkin syntax to use in the StepDef
    Given I am at talentTEK Home Page
    And I enter valid "test@test.com" Email
    And I enter valid password "Test123"
    When I click on Log In button
    Then I will verify I successfully logged into my existing account


