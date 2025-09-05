Feature: Purchase Item

  Scenario Outline: As a user i want to purchase an item
    Given I am in the login page
    When I enter a valid username "<username>" and a valid password "<password>"
    And I click on the login button
    Then I am logged in successfully
    When I add an item to the cart
    And I click on the cart button
    Then I verify that the item is in the cart
    When I click on the checkout button
    Then The your information page is displayed

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |