Feature: Search employee
  As an HR admin user
  I want to search employee
  So that I can quickly find the correct records

  Background:
    Given the admin has successfully logged in
    And navigates to the Employee List page

  @positive
  Scenario Outline: Search for an employee by an existing name
    When the admin enters the employee name "<emp_name>" on the Employee List page
    And clicks the Search button to find the employee
    Then the results list displays the employee with the name "<emp_name>"
    Examples:
      | emp_name |
      | Vy Du    |

  @positive
  Scenario Outline: Search for an employee regardless of letter case
    When the admin enters the employee name "<emp_name>" on the Employee List page
    And clicks the Search button to find the employee
    Then the results list displays the employee with the name "<emp_name>"
    Examples:
      | emp_name |
      | vY DU    |

  @negative
  Scenario Outline: Search for an employee using special characters
    When the admin enters the employee name "<emp_name>" on the Employee List page
    And clicks the Search button to find the employee
    Then the system displays "No Records Found" for the employee search
    Examples:
      | emp_name   |
      | Hang#Smith |

  @negative
  Scenario Outline: Search for an employee that does not exist in the system
    When the admin enters the employee name "<emp_name>" on the Employee List page
    And clicks the Search button to find the employee
    Then the system displays "No Records Found" for the employee search
    Examples:
      | emp_name |
      | Anh Tran |



