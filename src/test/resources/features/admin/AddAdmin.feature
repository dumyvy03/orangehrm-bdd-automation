Feature: Add new admin user
  As an HR admin
  I want to add a new system user
  So that I can manage user accounts and access rights in the system

  Background:
    Given the admin has successfully logged in
    And navigates to the Admin page
    And clicks the Add button to open the Add User page

  @positive
  Scenario Outline:Add admin with valid data
    When the admin enters and selects user information
      | User Role        | <user_role> |
      | Employee Name    | <emp_name>  |
      | Status           | <status>    |
      | Username         | <username>  |
      | Password         | <password>  |
      | Confirm Password | <password>  |
    And clicks the Save button to add a new user
    Then the new user is displayed in the user list
    Examples:
      | user_role | emp_name    | status  | username | password  |
      | Admin     | Nguyen John | Enabled | john15   | Z!9B@Xx4m |

  @negative
  Scenario Outline: Add user with username shorter than 5 characters
    When the admin enters username "<username>"
    Then the username field shows error "Should be at least 5 characters"
    Examples:
      | username |
      | user     |

  @negative
  Scenario Outline: Add User with existing username
    When the admin enters username "<username>"
    Then the username field shows error "Already exists"
    Examples:
      | username |
      | admin    |

  @negative
  Scenario Outline: Add User with non-existent employee name
    When the admin enters employee name "<emp_name>" on Add User page
    Then the suggestions dropdown displays "No Records Found"
    Examples:
      | emp_name  |
      | David Ngo |

  @negative
  Scenario Outline: Add User with password missing numeric character
    When the admin enters password "<password>"
    Then the password field shows error "Your password must contain minimum 1 number"
    Examples:
      | password  |
      | Password! |


  @negative
  Scenario Outline: Add User with mismatched confirm password
    When the admin enters password "<password>" and confirm password "<confirm_password>"
    Then the confirm password field shows error "Passwords do not match"
    Examples:
      | password  | confirm_password |
      | Admin@123 | Admin@12         |