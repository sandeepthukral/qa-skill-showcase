Feature: New user sign-up

  Scenario: A new user can sign up to the applciation
    Given I am on the user signup page
    And I signup with random required values
    Then I should be redirected to the signup success page
    And I should see the continue button