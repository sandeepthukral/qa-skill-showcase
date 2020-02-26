Feature: Geophy Login screen

  Scenario: user can login with correct credentials
    Given an open browser with login page
    When I enter a corect username
    And I enter a correct password
    And I submit the form
    Then I should be logged in
