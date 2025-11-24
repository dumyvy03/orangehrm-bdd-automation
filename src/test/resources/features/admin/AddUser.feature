Feature: Add new user
  As an HR admin
  I want to add a new system user
  So that I can manage user accounts and access rights efficiently

  Background:
    Given the admin has successfully logged in
    And navigates to the User Management page
    And clicks the Add button to open the Add User page

  @positive
  Scenario Outline: Add an admin user with valid data
    When the admin enters and selects the following user details:
      | User Role        | <user_role> |
      | Employee Name    | <emp_name>  |
      | Status           | <status>    |
      | Username         | <username>  |
      | Password         | <password>  |
      | Confirm Password | <password>  |
    And clicks the Save button to create the new user
    Then the newly created user is displayed in the user list

    Examples:
      | user_role | emp_name    | status  | username | password  |
      | Admin     | Nguyen John | Enabled | john15   | Z!9B@Xx4m |

  @negative
  Scenario Outline: Add user with a username shorter than 5 characters
    When the admin enters username "<username>" on the Add User page
    Then the Add User username field displays the error "Should be at least 5 characters"
    Examples:
      | username |
      | user     |

  @negative
  Scenario Outline: Add user with an already existing username
    When the admin enters username "<username>" on the Add User page
    Then the Add User username field displays the error "Already exists"
    Examples:
      | username |
      | admin    |

  @negative
  Scenario Outline: Add user with a non-existent employee name
    When the admin enters employee name "<emp_name>" on the Add User page
    Then the suggestions dropdown displays "No Records Found"
    Examples:
      | emp_name  |
      | David Ngo |

  @negative
  Scenario Outline: Add user with a password missing a numeric character
    When the admin enters password "<password>" on the Add User page
    Then the Add User password field displays the error "Your password must contain minimum 1 number"
    Examples:
      | password  |
      | Password! |


  @negative
  Scenario Outline: Add user with mismatched confirm password
    When the admin enters password "<password>" and confirm password "<confirm_password>"
    Then the Add User confirm password field displays the error "Passwords do not match"

    Examples:
      | password  | confirm_password |
      | Z!9B@Xx4m | Z!9B@Xx4         |