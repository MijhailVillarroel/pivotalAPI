Feature: Testing for create Stores

  Background: create a Project
    Given I has be create a one /projects whit:
      | name   | 'testing create stores880987889589' |
      | public | true                       |
    Then store Project1

  @deleteProject
  Scenario: Create story
    Given I send a post request /projects/[project.id]/stories with:
      | name | 'totally a new project name' |
    Then I expect Status the projects code 200
    And The description equals projects totally a new project name

