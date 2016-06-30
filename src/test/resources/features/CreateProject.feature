Feature: Testing for login Pivotal page

  Scenario: Create a new Project

    Given I want login to Pivotal page
    When I click on the SigIn button
    And It show the login form
    When I type walter_mercado_jala in the username input field
    And I click the next button
    When I type P@ssw0rd in the password input field
    And I click the login button
    When I click on the create project button on the Dashboard Page
    And Form to create a project is displayed
    When I type "My_new_project25" in the projects name input field
    And I click on the list accounts
    When I select an account of the list
    When I check on Public Check box option
    And I click on create project button
    Then It is expected that the display name projects is equal to name create