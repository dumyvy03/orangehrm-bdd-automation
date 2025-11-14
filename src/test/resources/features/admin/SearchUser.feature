Feature: Search User
  As an admin user
  I want to search users
  So that I can find specific accounts efficiently

  Background:
    Given the admin has successfully logged in
    And navigates to the User Management page

  @positive
  Scenario Outline: Search user by existing username
    When the admin enters username "<username>" on User Management page
    And clicks the Search button to find the user
    Then the username "<username>" is shown in the results list

    Examples:
      | username |
      | admin    |

  @negative
  Scenario Outline: Search user with non-existing username
    When the admin enters username "<username>" on User Management page
    And clicks the Search button to find the user
    Then the system shows "No Records Found"

    Examples:
      | username |
      | user     |

  @negative
  Scenario: Search user with empty username field
    When the admin clicks the Search button to find the user
    Then the system displays all existing users

