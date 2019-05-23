Feature: Agile project sign in

  Scenario: Login as a authenticated user
    Given user is on home page
    When user navigates to agile page
    And user enters username "1303" and password "Guru99"
    And click login button
    Then welcome message is correct