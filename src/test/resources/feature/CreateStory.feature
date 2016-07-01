Feature: Testing for create Stores

#  Background: create a Project
#    Given I has be create a one /projects whit:
#      | name   | 'testing create stores88098' |
#      | public | true                       |

#  @deleteProject
  Scenario: Create story
    Given I send a post request /stories with:
      | name | "totally a new project name" |
    Then I expect Status the projects code 200
    And The description equals projects testing2

