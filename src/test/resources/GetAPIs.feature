Feature: Job tracker API Functionality for GET methods

  Scenario: User requests for all applications
    When user hits endpoint "/api/v1/applications"
    Then Then user should receive all application

  Scenario: User gets a individual application by ID
    When user hits endpoint "/api/v1/applications" with id of "22"
    Then Then user should receive an individual application of "22"

  Scenario: User gets a individual application by ID that does not exist
    When user hits endpoint "/api/v1/applications" with id of "90"
    Then Then user should receive an response with an empty data array

  Scenario: User gets a individual application(s) company name
    When user hits endpoint "/api/v1/applications/query" with company name of "company_name test 2"
    Then Then user should receive all applications with the company name of "company_name test 2"

  Scenario: User gets a individual application(s) company name that does not exist
    When user hits endpoint "/api/v1/applications/query" with company name of "does not exist"
    Then Then user should receive an response with an empty data array

  Scenario: User gets request applications by ascending salary order
    When user hits endpoint "/api/v1/applications/dynamic/query" with and query "salary"
    Then Then user should receive an response with all applications ascending by salary
