Feature: Shopping on the adidas page and adding items to cart and remove then purchase the other

  Scenario: Adding laptop to the cart
    Given user is the home page
    When clicks the laptop
    When user selects Sony laptop
    And user add to the cart

  Scenario: Adding dell laptop to the cart
    Given user is the home page
    When clicks the laptop
    When user selects Dell laptop
    And user add to the cart

    Scenario: USer should be able delete an item
      Given user is on the card page
      When user click on delete Dell and should delete

  Scenario: User puts all of their info
    Given User puts his info
    When Clicks purchase he should see sale id