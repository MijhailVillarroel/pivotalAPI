Feature: Testing for delete project in Pivotal

  Background: create a Project
    Given I has be create a one /projects whit:
      | name   | 'testing Delete and Edit'|
      | public | true               |

  Scenario: Delete projects
    When I send a delete request delete one /projects
    Then I expect Status the projects code 204

  @deleteProject
  Scenario: Edit Project
    When I send a put request /projects with:
      | description | 'totally new' |
    Then I expect Status the projects code 200
    And The description equals projects totally new


