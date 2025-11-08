Feature: Add new employee
  As an HR admin user
  I want to add a new employee
  So that I can manage staff records in the system

  Background:
    Given the admin has successfully logged in
    And  navigates to the Add New Employee page

  @positive
  Scenario Outline: Add employee with valid data
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    And clicks the Save button to add a new employee
    Then the Personal Details page displays the employee’s details

    Examples:
      | firstname | lastname | avatar   |
      | John      | Doe      | mori.jpg |

  @negative
  Scenario Outline: Add employee with empty first name
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    And clicks the Save button to add a new employee
    Then the first name field shows error "Required"

    Examples:
      | firstname | lastname | avatar   |
      |           | Doe      | mori.jpg |

  @negative
  Scenario Outline: Add employee with first name containing special characters
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    And clicks the Save button to add a new employee
    Then the first name field shows error "First Name must contain only letters"

    Examples:
      | firstname | lastname | avatar   |
      | John@#5   | Doe      | mori.jpg |

  @negative
  Scenario Outline: Add employee with first name exceeding 30 characters
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    Then the first name field shows error "Should not exceed 30 characters"

    Examples:
      | firstname                         | lastname | avatar   |
      | JonathanEdwardMontgomeryAlexander | Doe      | mori.jpg |

  @negative
  Scenario Outline: Add employee with empty last name
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    And clicks the Save button to add a new employee
    Then the last name field shows error "Required"

    Examples:
      | firstname | lastname | avatar   |
      | John      |          | mori.jpg |

  @negative
  Scenario Outline: Add employee with last name containing special characters
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    And clicks the Save button to add a new employee
    Then the last name field shows error "Last Name must contain only letters"

    Examples:
      | firstname | lastname | avatar   |
      | John      | Doe%$%76 | mori.jpg |

  @negative
  Scenario Outline: Add employee with last name exceeding 30 characters
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    Then the last name field shows error "Should not exceed 30 characters"

    Examples:
      | firstname | lastname                             | avatar   |
      | John      | MontgomeryWilliamsonAndersonSmithson | mori.jpg |

  @negative
  Scenario Outline: Add employee with avatar exceeding the allowed size
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    Then the avatar field shows error "Attachment Size Exceeded"

    Examples:
      | firstname | lastname | avatar       |
      | John      | Doe      | doraemon.png |

  @negative
  Scenario Outline: Add employee with invalid avatar format
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    Then the avatar field shows error "File type not allowed"

    Examples:
      | firstname | lastname | avatar       |
      | John      | Doe      | kaitokid.tif |