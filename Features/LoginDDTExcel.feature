Feature: Login Data with Excel

	Scenario Outline: Login Data Driven Excel
		Given the user navigates to QAfox login page
		Then the user should be redirected to my Account page by passing email and password with excel row "<row_index>"
		
		Examples:
			| row_index|
			|                  1|
			|                  2|
			|                  3|
			|                  4|
			|                  5|