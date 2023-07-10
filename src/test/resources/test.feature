Feature: Applications API Functionality

  Scenario: User requests for all applications
    When user hits endpoint "/api/v1/applications"
    Then Then user should should receive all application

  Scenario: User request a individual application
    When user hits endpoint "/api/v1/applications" with id of "1"
    Then Then user should should receive an individual application

