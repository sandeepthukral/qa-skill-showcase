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
    And the confidence indicator should be green

  Scenario: user cannot run valuation if address is not selected in dropdown
    Given I am logged in to Evra
    And I am on the Evra search page
    When I enter all required fields with static data without validating address
    Then the Run Valuation button should be disabled

  Scenario: user should be able to click on the first report in recent searches list
    Given I am logged in to Evra
    And I am on the Evra search page
    When I click on the first report in recent searches list
    Then the report is displayed

  Scenario: user should be able to save a report
    Given I am logged in to Evra
    And I run valuation with static data
    When I am on the Evra search page
    And I save the first report in recent searches list
    Then the first report in the recent searches should be saved

  Scenario: user can view sample report
    Given I am logged in to Evra
    And I am on the Evra search page
    When I click on the sample report
    Then the sample report should be displayed in a new tab


## Commented because implementing registering a new user will take a long time
#  Scenario: recent searches section should not be displayed for a new user
#    Given a new user is registered
#    When the new user logs in to Evra
#    Then the recent searches section should not be displayed
