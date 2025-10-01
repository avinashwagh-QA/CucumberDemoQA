Feature: Login with valid credential 

 @sanity @regression
  Scenario: Successful login with valid credential
    Given the user navigates to QAfox login page
    When The user enter Email as "max.admin@yopmail.com" and Password as "Max@123"
    And the user clicks on the login button
    Then the user should be redirected to the Myaccount page
 
    
    
    #@regression
   # Scenario Outline: Log in with Data Driven 
    #	Given the user navigates to QAfox login page
    #	When  The user enter Email as "<username>" and Password as "<password>"
    #	And the user clicks on the login button
    #	Then the user should be redirected to the Myaccount page
    	
    	#Examples:
			#| username                             | password |
			#| max.admin@yopmail,com | test123 |
			#| max.admin@yopmail.com | Max@123 |


