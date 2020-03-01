Feature: Password Reset functionality

  Scenario: Password reset for a user that does not exist
    Given I am on the password reset page
    And I request password reset for a random email
    Then I should be redirected to the login page
    And I should see the password reset success message