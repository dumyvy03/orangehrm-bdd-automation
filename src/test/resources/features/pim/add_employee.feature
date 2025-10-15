Feature: Add new employee
  As an HR admin user
  I want to add a new employee
  So that I can manage staff records in the system

  Background:
    Given the admin has successfully logged in
    And  navigates to the Add New Employee page

  @valid
  Scenario Outline: Add employee with valid data
    When the admin enters the employee name "<firstname>" "<middlename>" "<lastname>" and uploads the avatar "<avatar>"
    And clicks the Save button on the Add Employee page
    Then the Personal Details page displays the employee’s details

    Examples:
      | firstname | middlename | lastname | avatar      |
      | John      | Andrew     | Doe      | avatar1.jpg |

  @empty_firstname
  Scenario Outline: Add employee with empty firstname
    When the admin enters the employee name "<firstname>" "<middlename>" "<lastname>" and uploads the avatar "<avatar>"
    And clicks the Save button on the Add Employee page
    Then the system should display the field error message "Required"

    Examples:
      | firstname | middlename | lastname | avatar      |
      |           | Andrew     | Doe      | avatar1.jpg |

  @invalid_firstname
  Scenario Outline: Add employee with special characters in firstname
    When the admin enters the employee name "<firstname>" "<middlename>" "<lastname>" and uploads the avatar "<avatar>"
    And clicks the Save button on the Add Employee page
    Then the system should display the field error message "Firstname must contain only letters"

    Examples:
      | firstname | middlename | lastname | avatar      |
      | John@#5   | Andrew     | Doe      | avatar1.jpg |