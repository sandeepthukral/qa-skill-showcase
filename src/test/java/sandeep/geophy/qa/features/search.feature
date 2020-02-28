Feature: Search page and results

  Scenario: user should be able to get results for static data
    Given I am logged in to Evra
    And I am on the Evra search page
    When I enter all required fields with static data
    And I enter an occupancy of 80 percent
    And I run valuation
    Then I should see the report page
    And the valuation should be the static value
    And the cap rate should be the default value

  Scenario: user cannot run valuation if address is not selected in dropdown
    Given I am logged in to Evra
    And I am on the Evra search page
    When I enter all required fields with static data without validating address
    Then the Run Valuation button should be disabled
