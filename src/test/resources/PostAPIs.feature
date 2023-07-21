Feature: Job tracker API Functionality for POST methods

  Scenario: User posts a new application
    Given user signs up using this information
      | site           | date         | date_applied_to | company_name      | position          | fulltime_Contract | salary | company_website | contact_info       | call_back_date | tech_stack | round_1 | round_2 | round_3 | final | notes
      | random website | today's_date | 60677           | fake_company_name | Software_Engineer | true              | 000    | fake_website    | random_information | today's_date   | MERN       | N/A     | N/A     | N/A     | N/A   | N/A
    Then Then user should should receive new application