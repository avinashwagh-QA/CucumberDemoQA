Feature: Add product to shopping cart

  Scenario: Verify adding product to cart
    Given I navigate to the home page
    When I search for the product with name "MacBook"
    And Click on search button
    Then I should see the search result page
    And I should see the product "MacBook" in the search result
    When I select the product "MacBook" from the search result
    And I set the quantity as to "2"
    And Add the product to cart
    Then I should see the success message confirming the product was add to cart


