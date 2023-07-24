Feature: Put Functionality

  Scenario:
    Given user hits endpoint "/api/v1/applications/" trying to update application with id of "77"
    Then application with id "77" should be updated