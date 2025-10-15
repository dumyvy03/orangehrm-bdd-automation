Feature: Admin login
  As an admin user
  I want to log in to my account
  So that I can access the admin dashboard

  Background:
    Given the admin is on the login page

  @valid
  Scenario Outline: Login with valid data
    When the admin enters username "<username>" and password "<password>"
    And clicks the Login button
    Then the system should redirect to the admin dashboard

    Examples:
      | username | password   |
      | admin    | Admin@1234 |

  @invalid
  Scenario Outline: Login with invalid data
    When the admin enters username "<username>" and password "<password>"
    And clicks the Login button
    Then the system should display the login error message "Invalid credentials"

    Examples:
      | username | password   |
      | admin    | admin@     |
      | ad       | Admin@1234 |

  @empty_fields
  Scenario Outline: Login with empty fields
    When the admin enters username "<username>" and password "<password>"
    And clicks the Login button
    Then the system should display the field error message "Required"

    Examples:
      | username | password   |
      | admin    |            |
      |          | Admin@1234 |

