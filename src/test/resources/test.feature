Feature: Login

  Background:
    Given Health check is passing healthy

  Scenario: User requests for all applications
    When user logs in with "correct credentials"
    Then user should be logged into their account
