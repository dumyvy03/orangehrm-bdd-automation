Feature: Edit employee
  As an HR admin user
  I want to edit an existing employee
  So that I can update their details when needed

  Background:
    Given the admin has successfully logged in
    And navigates to the Employee List page

  @positive
  Scenario Outline: Edit an employee with valid data
    When the admin searches for the employee by ID "<emp_id>"
    And clicks the Search button to find the employee for editing
    And clicks the Edit button in the search results
    And the admin updates the following personal details:
      | Avatar                  | <avatar>                |
      | First Name              | <firstname>             |
      | Last Name               | <lastname>              |
      | Driver's License Number | <driver_license_number> |
      | License Expiry Date     | <license_expiry_date>   |
      | Nationality             | <nationality>           |
      | Marital Status          | <marital_status>        |
      | Date of Birth           | <date_of_birth>         |
      | Gender                  | <gender>                |
    And clicks the Save button to update
    Then the system saves the updated information successfully

    Examples:
      | emp_id | avatar   | firstname | lastname | driver_license_number | license_expiry_date | nationality | marital_status | date_of_birth | gender |
      | 0090   | mori.png | Hang      | Smith    | D2345678              | 2026-11-30          | Vietnamese  | Single         | 1995-10-19    | Female |

  @negative
  Scenario Outline: Edit an employee with an empty first name
    When the admin searches for the employee by ID "<emp_id>"
    And clicks the Search button to find the employee for editing
    And clicks the Edit button in the search results
    And the admin updates the first name with "<firstname>"
    Then the Personal Details first name field displays the error "Required"
    Examples:
      | emp_id | firstname |
      | 0101   |           |

  @negative
  Scenario Outline: Edit an employee with an invalid License Expiry Date format
    When the admin searches for the employee by ID "<emp_id>"
    And clicks the Search button to find the employee for editing
    And clicks the Edit button in the search results
    And the admin updates the license expiry date with "<license_expiry_date>"
    And clicks the Save button to update
    Then the Personal Details license expiry date field displays the error "Should be a valid date in yyyy-mm-dd format only."

    Examples:
      | emp_id | license_expiry_date |
      | 0001   | 2026/05/20          |