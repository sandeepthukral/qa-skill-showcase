Feature: Reports page

  Scenario: user can download the report CSV file
    Given I am logged in to Evra
    And I have the sample report displayed
    When I click the CSV download link
    Then the file should be downloaded

  Scenario: user sees important sections on a report
    Given I am logged in to Evra
    When I have the sample report displayed
    Then all important sections of the report should be displayed

  Scenario: user can save a report
    Given I am logged in to Evra
    And I run evaluation with static data
    When I save the report
    Then the report should be saved

  Scenario: user should see the static header when they scroll down
    Given I am logged in to Evra
    And I have the sample report displayed
    When I scroll down
    Then the static header should be visible