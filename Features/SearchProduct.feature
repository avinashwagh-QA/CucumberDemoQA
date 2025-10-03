Feature: Search Product


 Scenario: Search for an existing product
 	Given I navigate to the home page
 	When I search for the product with name "iMac"
 	And Click on searh button 
 	Then I should see the search result page
 	And I should see the product "iMac" in the search result  
 	
 	
Scenario: Search for a non-existing product
  Given I navigate to the home page
  When I search for the product with name "XYZ123"
  And Click on searh button 
  Then I should see the search result page
  And I should see a message "There is no product that matches the search criteria."