Feature: Geophy Login screen

  Scenario: user can login with correct credentials
    Given an open browser with login page
    When I enter a corect username
    And I enter a correct password
    And I submit the form
    Then I should be logged in

  Scenario: password recovery form is displayed when forgot password link is clicked
    Given an open browser with login page
    When the Forgot Password link is clicked
    Then the password reset page should be displayed
    And it should have an email address field
