Feature: Testing for delete project in Pivotal

  Background: create a Project
    Given I send a post request /projects with:
      | name   | 'Test Edit Project07889' |
      | public | true    |
    Then store Project1

  Scenario: Delete projects
    When I send a delete request delete one /projects/[Project1.id]
    Then I expect Status the projects code 204

  @deleteProjectWithStories
  Scenario: Edit Project
    When I send a put request /projects/[Project1.id] with:
      | description | 'totally new' |
    Then I expect Status the projects code 200
    And The description equals projects totally new


