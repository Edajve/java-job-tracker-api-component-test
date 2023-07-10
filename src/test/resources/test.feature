Feature: Applications API Functionality

  Scenario: User requests for all applications
    When user hits endpoint "/api/v1/applications"
    Then Then user should should receive all application

  Scenario: User request a individual application
    When user hits endpoint "/api/v1/applications" with id of "1"
    Then Then user should should receive an individual application

  Scenario: User request a individual application that does not exist
    When user hits endpoint "/api/v1/applications" with id of "90"
    Then Then user should should receive an response with an empty data array