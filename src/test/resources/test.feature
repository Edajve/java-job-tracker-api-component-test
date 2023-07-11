Feature: Applications API Functionality

  Scenario: User requests for all applications
    When user hits endpoint "/api/v1/applications"
    Then Then user should should receive all application

  Scenario: User request a individual application by ID
    When user hits endpoint "/api/v1/applications" with id of "3"
    Then Then user should should receive an individual application of "3"

  Scenario: User request a individual application by ID that does not exist
    When user hits endpoint "/api/v1/applications" with id of "90"
    Then Then user should should receive an response with an empty data array

  Scenario: User request a individual application(s) company name
    When user hits endpoint "/api/v1/applications" with company name of of "company_name test 2"
    Then Then user should receive all applications with the company name of "company_name test 2"

  Scenario: User request a individual application(s) company name that does not exist
    When user hits endpoint "/api/v1/applications" with company name of of "does not exist"
    Then Then user should should receive an response with an empty data array