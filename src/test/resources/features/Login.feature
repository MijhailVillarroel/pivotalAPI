Feature: Testing for login Pivotal page

  Scenario: Login with valid credentials

    Given I want login to Pivotal page
    When I click on the SigIn button
    And It show the login form
    When I type walter_mercado_jala in the username input field
    And I click the next button
    When I type P@ssw0rd in the password input field
    And I click the login button
    Then It is expected that the display name equals WALTER_MERCADO_JALA