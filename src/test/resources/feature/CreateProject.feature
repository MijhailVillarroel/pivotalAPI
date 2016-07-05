Feature: Testing for login Pivotal page

  @deleteProject
  Scenario: Create project
    Given I send a post request /projects with:
      | name   | TestCreateProjects238 |
      | public | true    |
    Then I expect Status the projects code 200
    And The name equals projects TestCreateProjects238
    And The kind equals projects project
#    And The public equals projects true

