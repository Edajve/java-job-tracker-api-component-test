Feature: Applications API Functionality

  Scenario: User requests for all applications
    When user hits endpoint "/api/v1/applications"
    Then Then user should should receive all application
