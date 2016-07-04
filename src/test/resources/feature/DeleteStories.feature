Feature: Testing for delete project in Pivotal

  Background: create a Project
    Given I send a post request /projects with:
      | name   | TestCreateProjects2790 |
      | public | true                   |
    And store Project1
    And I send a post request /projects/[Project1.id]/stories with:
      | name | 'totally a new project name' |
    Then store Story1

  @deleteProjectWithStories
  Scenario: Delete story
    When I send a delete request /projects/[Project1.id]/stories/[Story1.id]
    Then I expect Status the projects code 204

  @deleteProjectWithStories
  Scenario: update  story
    When I send a put request /projects/[Project1.id]/stories/[Story1.id] with:
      | name       | 'update name' |
      | story_type | bug           |
    Then I expect Status the projects code 200
    And The name equals projects update name
    And The story_type equals projects bug
