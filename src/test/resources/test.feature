Feature: Login

  Background:
    Given Health check is passing healthy

  Scenario: User requests for all applications
    When user hits endpoint "/api/v1/applications"
    Then Then user should
