Feature: Add new employee
  As an HR admin user
  I want to add a new employee
  So that I can manage staff records in the system

  Background:
    Given the admin has successfully logged in
    And  navigates to the Add New Employee page

  @valid
  Scenario Outline: Add employee with valid data
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    And clicks the Save button to add a new employee
    Then the Personal Details page displays the employee’s details

    Examples:
      | firstname | lastname | avatar   |
      | John      | Doe      | mori.jpg |

  @empty_firstname
  Scenario Outline: Add employee with empty firstname
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    And clicks the Save button to add a new employee
    Then the system should display the field error message "Required"

    Examples:
      | firstname | lastname | avatar   |
      |           | Doe      | mori.jpg |

  @invalid_firstname
  Scenario Outline: Add employee with firstname containing special characters
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    And clicks the Save button to add a new employee
    Then the system should display the field error message "First Name must contain only letters"

    Examples:
      | firstname | lastname | avatar   |
      | John@#5   | Doe      | mori.jpg |

  @exceed_30_chars_firstname
  Scenario Outline: Add employee with firstname exceeding 30 characters
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    And clicks the Save button to add a new employee
    Then the system should display the field error message "Should not exceed 30 characters"

    Examples:
      | firstname                         | lastname | avatar   |
      | JonathanEdwardMontgomeryAlexander | Doe      | mori.jpg |

  @empty_lastname
  Scenario Outline: Add employee with empty firstname
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    And clicks the Save button to add a new employee
    Then the system should display the field error message "Required"

    Examples:
      | firstname | lastname | avatar   |
      | John      |          | mori.jpg |

  @invalid_lastname
  Scenario Outline: Add employee with lastname containing special characters
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    And clicks the Save button to add a new employee
    Then the system should display the field error message "Last Name must contain only letters"

    Examples:
      | firstname | lastname | avatar   |
      | John      | Doe%$%76 | mori.jpg |

  @exceed_30_chars_lastname
  Scenario Outline: Add employee with lastname exceeding 30 characters
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    And clicks the Save button to add a new employee
    Then the system should display the field error message "Should not exceed 30 characters"

    Examples:
      | firstname | lastname                             | avatar   |
      | John      | MontgomeryWilliamsonAndersonSmithson | mori.jpg |

  @exceed_avatar_size
  Scenario Outline: Add employee with avatar exceeding the allowed size
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    And clicks the Save button to add a new employee
    Then the system should display the field error message "Attachment Size Exceeded"

    Examples:
      | firstname | lastname | avatar       |
      | John      | Doe      | doraemon.png |

  @invalid_avatar_format
  Scenario Outline: Add employee with invalid avatar format
    When the admin enters the employee name "<firstname>" "<lastname>" and uploads the avatar "<avatar>"
    And clicks the Save button to add a new employee
    Then the system should display the field error message "File type not allowed"

    Examples:
      | firstname | lastname | avatar       |
      | John      | Doe      | kaitokid.tif |