Feature: Admin login
  As an admin user
  I want to log in to my account
  So that I can access the admin dashboard

  Background:
    Given the admin is on the login page

  @valid
  Scenario Outline: Login with valid credentials
    When the admin enters username "<username>" and password "<password>"
    And clicks the Login button
    Then the system redirects the admin dashboard

    Examples:
      | username | password   |
      | admin    | Admin@1234 |

  @negative
  Scenario Outline: Login with invalid credentials
    When the admin enters username "<username>" and password "<password>"
    And clicks the Login button
    Then the system displays the login error message "Invalid credentials"

    Examples:
      | username | password   |
      | admin    | admin@     |
      | ad       | Admin@1234 |

  @negative
  Scenario Outline: Login with an empty username
    When the admin enters username "<username>" and password "<password>"
    And clicks the Login button
    Then the Login username field displays the error "Required"

    Examples:
      | username | password   |
      |          | Admin@1234 |

  @negative
  Scenario Outline: Login with an empty password
    When the admin enters username "<username>" and password "<password>"
    And clicks the Login button
    Then the Login password field displays the error "Required"

    Examples:
      | username | password |
      | admin    |          |

