Feature: Testing for login Pivotal page

#  Scenario: Create a new Project
#    Given I have set a connection project to pivotal_tracker API service
#    When I send a GET request the projects to /projects
#    Then I expect Status the projects code 200
#
#  Scenario: Delete request with params
#    Given I have set a connection project to pivotal_tracker API service
#    And I have have  least one project create in /projects/
#    When I a Delete the project  in request the projects to /projects/
#    Then I expect Status the projects code 204
#
#  Scenario Outline: : Validate values project
#    Given I have set a connection project to pivotal_tracker API service
#    When I send a POST request to /projects with name project <nameProject>
#    Then I expect Status the projects code 200
#    And I expect validate the values of the projects return by request
#    Examples:
#      | nameProject    |
#      | Project_Home24 |
#      | Project_Home25 |
#      | Project_Home26 |

  Scenario: Create pro
    Given I send a post request /projects with:
      | name   | testing257989 |
      | public | true    |
    Then I expect Status the projects code 200

