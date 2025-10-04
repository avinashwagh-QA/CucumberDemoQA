Feature: Add product to shopping cart

  Scenario: Verify adding product to cart
    Given I navigate to the home page
    When I search for the product with name "iMac"
    And Click on search button
    Then I should see the product "iMac" in the search result
    When I select the product "iMac" from the seatch result
    And I set the quantity as to "2"
    And Add the product to cart
    Then I sholud see the sucess message confirming the product was add to cart