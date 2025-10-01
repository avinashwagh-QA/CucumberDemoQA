Feature: Account Registration

@sanity
  Scenario: Successful Account registration
    Given The user navigates to registration page
    When User enters the details into below fields
      | firstName | Jhon      |
      | lastName  | Mathew    |
      | telephone | 7547547540 |
      | password  | Jhon@123  |
    And The user select privacy policy
    And The user clicks on the Continue button

    Then The user account should get created Successfully

@regression
  Scenario: Display error messages for empty fields
    Given The user navigates to registration page
    When no details are entered and the Continue button is clicked
    Then error message "First Name must be between 1 and 32 characters!" should be displayed
    And error message "Last Name must be between 1 and 32 characters!" should be displayed
    And error message "E-Mail Address does not appear to be valid!" should be displayed
    And error message "Telephone must be between 3 and 32 characters!" should be displayed
    And error message "Password must be between 4 and 20 characters!" should be displayed

    
