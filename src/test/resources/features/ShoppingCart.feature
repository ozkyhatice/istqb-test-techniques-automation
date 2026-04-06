Feature: Shopping Cart Functionality

  Scenario: Searching for a product and adding it to the cart
    Given The user is on the e-commerce home page
    When The user types "ayakkabı" into the search box and searches
    And The user adds the first listed product to the cart
    Then "1" items should be seen in the cart icon
    And The user should proceed to the checkout step