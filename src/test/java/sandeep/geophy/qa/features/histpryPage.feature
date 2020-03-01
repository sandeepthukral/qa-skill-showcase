Feature: History page features

## These features are suggested but not yet implemented due to shortage of time and
## the lack of ability to set the pre-conditions

#  Scenario: Pagination should disappear if no past reports are available
#    Given at least one historical search
#    And I am logged in to Evra
#    When I visit the history page
#    And I filter with random text
#    Then the pagination should not be visible
#    And the current page should be 1
#
#  Scenario: History should be empty for a new user
#    Given a new user
#    And the user is logged in to Evra
#    When the user visits the history page
#    Then the page should be displayed empty
#
#  Scenario: Previous button should appear when on the second page of results
#    Given I have more than 10 history records
#    And I am logged in to Evra
#    When I visit the history page
#    And I click on the second page in pagination
#    Then the Previous pagination button should be visible
#
#  Scenario: Next button should disappear when on the last page of results
#    Given I have more than 10 history records
#    And I am logged in to Evra
#    When I visit the history page
#    And I click on the last page in pagination
#    Then the Next pagination button should be visible