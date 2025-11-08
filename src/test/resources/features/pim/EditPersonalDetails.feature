Feature: Edit employee
  As an HR admin user
  I want to edit an existing employee
  So that I can update their details when needed

  Background:
    Given the admin has successfully logged in
    And navigates to the Employee List page

  @positive
  Scenario Outline: Edit employee with valid data
    When the admin searches by employee id "<emp_id>"
    And the admin clicks the Search button
    And clicks Edit button in search results
    And the admin updates personal details
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
      | 0018   | mori.png | Hang      | Smith    | D2345678              | 2026-11-30          | Vietnamese  | Single         | 1995-10-19    | Female |

  @negative
  Scenario Outline: Edit employee with empty first name
    When the admin searches by employee id "<emp_id>"
    And the admin clicks the Search button
    And clicks Edit button in search results
    And the admin updates first name empty "<firstname>"
    Then the first name field shows error "Required"
    Examples:
      | emp_id | firstname |
      | 0017   |           |

  @negative
  Scenario Outline: Edit employee with invalid License Expiry Date format
    When the admin searches by employee id "<emp_id>"
    And the admin clicks the Search button
    And clicks Edit button in search results
    And the admin updates license expiry date "<license_expiry_date>"
    Then the license expiry date field shows error "Should be a valid date in yyyy-mm-dd format"

    Examples:
      | emp_id | license_expiry_date |
      | 0020   | 2026/05/20          |

  @negative
  Scenario Outline: Edit employee with invalid Date of Birth format
    When the admin searches by employee id "<emp_id>"
    And the admin clicks the Search button
    And clicks Edit button in search results
    And the admin updates date of birth "<date_of_birth>"
    Then the date of birth field shows error "Should be a valid date in yyyy-mm-dd format"

    Examples:
      | emp_id | date_of_birth |
      | 0017   | 1998-02-30    |