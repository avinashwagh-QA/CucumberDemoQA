Feature: Forgot Password

@sc1
 Scenario: User request for reset password link
	  Given the user navigates to QAfox login page
	  When The user clicks on Forgot password link 
	  And The user enter register email "Max.admin@yopmail.com"
	  And The user submit the request
	  Then Success message "An email with a confirmation link has been sent your email address." should be displayed 
  
  @sc2
  Scenario: User request for reset password without email
	  Given the user navigates to QAfox login page
	  When The user clicks on Forgot password link 
	  And The user submit the request
	  Then Alert message "Warning: The E-Mail Address was not found in our records, please try again!" should be displayed 