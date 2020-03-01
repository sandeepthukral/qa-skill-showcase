Feature: Geophy Login screen

  Scenario: user can login with correct credentials
    Given an open browser with login page
    When I enter a correct username
    And I enter a correct password
    And I submit the form
    Then I should be logged in

  Scenario: password reset form is displayed when forgot password link is clicked
    Given an open browser with login page
    When the Forgot Password link is clicked
    Then the password reset page should be displayed
    And it should have an email address field

  Scenario: signup form is displayed when signup link is clicked
    Given an open browser with login page
    When the Signup link is clicked
    Then the signup page should be displayed

  Scenario: user can logout using the logout link
    Given I am logged in to Evra
    When I click the logout link
    Then I should be at the login page

  ## The following scenarios are commented because wither they may not be good candidates for automation
  ## or they can be automated with more time and effort
#  Scenario: appropriate error is displayed when username field is empty
#    Given an open browser with login page
#    When I enter a username
#    And I submit the form
#    Then I should see the password is missing error message
#
#  Scenario: appropriate error is displayed when password field is empty
#    Given an open browser with login page
#    When I enter a password
#    And I submit the form
#    Then I should see the username is missing error message

