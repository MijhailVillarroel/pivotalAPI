Feature: Testing for create Stores

  Background: create a Project
    Given I send a post request /projects with:
      | name   | TestCreateProject |
      | public | true              |
    Then store Project1

  @deleteProjectWithStories
  Scenario: Create story
    Given I send a post request /projects/[Project1.id]/stories with:
      | name | 'totally a new project name' |
    Then I expect Status the projects code 200
    And The name equals projects totally a new project name

