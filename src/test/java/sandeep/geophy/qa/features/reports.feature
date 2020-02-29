Feature: Reports page

  Scenario: user can download the report CSV file
    Given I am logged in to Evra
    And I have the sample report displayed
    When I click the CSV download link
    Then the file should be downloaded