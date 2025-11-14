Feature: Search employee
  As an HR admin user
  I want to search employee
  So that I can quickly find the right records

  Background:
    Given the admin has successfully logged in
    And navigates to the Employee List page

  @positive
  Scenario Outline: Search employee by existing name
    When the admin enters employee name "<emp_name>" on Employee List page
    And clicks the Search button to find the employee
    Then the results list shows employee with name "<emp_name>"
    Examples:
      | emp_name   |
      | Hang Smith |

  @positive
  Scenario Outline: Search employee without case sensitivity
    When the admin enters employee name "<emp_name>" on Employee List page
    And clicks the Search button to find the employee
    Then the results list shows employee with name "<emp_name>"
    Examples:
      | emp_name   |
      | haNG sMItH |

  @negative
  Scenario Outline: Search employee with special characters
    When the admin enters employee name "<emp_name>" on Employee List page
    And clicks the Search button to find the employee
    Then the system shows "No Records Found"
    Examples:
      | emp_name   |
      | Hang#Smith |

  @negative
  Scenario Outline: Search employee not existing in the system
    When the admin enters employee name "<emp_name>" on Employee List page
    And clicks the Search button to find the employee
    Then the system shows "No Records Found"
    Examples:
      | emp_name |
      | Anh Tran |



