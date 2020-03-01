Feature: History page features

## These features are suggested but not yet implemented due to shortage of time and
## the lack of ability to set the pre-conditions

#  Scenario: Pagination should disappear if no past reports are available
#    Given at least one historical search
#    And I am logged in to Evra
#    When I visit the history page
#    And I filter with random text
#    Then the pagination should not be visible

#  Scenario: History should be empty for a new user
#    Given a new user
#    And the user is logged in to Evra
#    When the user visits the history page
#    Then the page should be displayed empty