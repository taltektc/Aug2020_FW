Feature: Login

  @regression @smoke @login @test
  Scenario: Login with valid email and password
    Given I am at talentTEK Home Page
    And I enter valid email address
    And I enter valid password
    When I click on Log In button
    Then I will verify I successfully logged into my existing account

  @regression @login
  Scenario: Login with invalid email and valid password
    Given I am at talentTEK Home Page
    And I enter invalid email address
    And I enter valid password
    When I click on Log In button
    Then I will verify I didn't successfully logged into existing account