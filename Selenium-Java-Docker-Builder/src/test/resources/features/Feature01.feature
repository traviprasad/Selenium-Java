Feature: Demo

  Background:
    Given I am on the HomePage

  @signIn
  Scenario: Simple sign in scenario
    When I click on SignIn button
    Then I should be on the Authentication page
    And I enter UserName as "tester@tet.com"
    And I enter Password as "test1234"
    When I click on LogIn button
    Then I should be on the MyAccount page
    And I click on SignOut button