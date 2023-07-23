Feature: Job tracker API Functionality for POST methods

  Scenario: User posts a new application
    Given user posts an application to endpoint "/api/v1/applications"
      | site         | date         | date_applied_to | company_name | position      | fulltime_contract | salary | company_website     | contact_info          | call_back_date | tech_stack | round_1  | round_2          | round_3                      | final    | notes
      | www.test.com | today's_date | 60677           | Test Company | Test Position | true              | 000    | www.fakewebsite.com | Falicia: 888-888-8888 | today's_date   | MERN       | Did Good | Passed This Also | Might Get To the final round | PASSED!! | Wants experience in API Testing
    Then Then user should should receive new application