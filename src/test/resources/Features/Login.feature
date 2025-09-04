Feature: Purchase Item

  Scenario Outline: As a user i want to purchase an item
    Given I am in the login page
    When I enter a valid username "<username>" and a valid password "<password>"
    And I click on the login button
    Then I am logged in successfully

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |