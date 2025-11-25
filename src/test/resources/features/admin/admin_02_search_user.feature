Feature: Search User
  As an admin user
  I want to search users
  So that I can quickly locate specific accounts

  Background:
    Given the admin has successfully logged in
    And navigates to the User Management page

  @positive
  Scenario Outline: Search for a user by an existing username
    When the admin enters username "<username>" on the User Management page
    And clicks the Search button to find the user
    Then the username "<username>" appears in the results list

    Examples:
      | username |
      | admin    |

  @negative
  Scenario Outline: Search for a user with a non-existing username
    When the admin enters username "<username>" on the User Management page
    And clicks the Search button to find the user
    Then the search results display "No Records Found"

    Examples:
      | username |
      | user     |

  @negative
  Scenario: Search for a user with an empty username field
    When the admin clicks the Search button to find the user
    Then the system displays all existing users

