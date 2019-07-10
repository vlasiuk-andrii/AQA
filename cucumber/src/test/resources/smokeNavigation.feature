Feature: Navigation to few pages is working

  Scenario: User can navigate to homePage
    When user navigate to homePage
    Then title of homePage is correct
    And login form is present

  Scenario: User can navigate to newToursPage
    Given user is on homePage
    When user click on newToursButton
    Then title of newToursPage is correct
    And main fragment is present

  Scenario: User can navigate to tablePage
    Given user is on homePage
    When user click on tableDemoLink
    Then title of tablePage is correct
    And table is present