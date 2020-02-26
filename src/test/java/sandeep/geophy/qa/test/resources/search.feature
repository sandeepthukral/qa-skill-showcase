Feature: Search page and results

  Scenario: user should be able to get results for static data

    Given I am logged in to Evra
    And I am on the Evra search page
    When I enter all required fields with static data
    And I enter an occupancy of 80 percent
    And I click the run validation
    Then I should see the report page
    And the valuation should be the static value
    And the cap rate should be the default value
