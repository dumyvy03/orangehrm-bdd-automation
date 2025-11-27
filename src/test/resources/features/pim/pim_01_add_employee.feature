Feature: Add new employee
  As an HR admin user
  I want to add a new employee
  So that I can manage staff records in the system

  Background:
    Given the admin has successfully logged in
    And navigates to the Employee List page
    And clicks Add Employee page

  @positive
  Scenario Outline: Add an employee with valid data
    When the admin enters the employee name with first name "<firstname>" and last name "<lastname>"
    And uploads the avatar "<avatar>"
    And clicks the Save button to create the new employee
    Then the Personal Details page displays the employee’s information

    Examples:
      | firstname | lastname | avatar   |
      | John      | Doe      | mori.jpg |

  @negative
  Scenario Outline: Add an employee with an empty first name
    When the admin enters the employee name with first name "<firstname>" and last name "<lastname>"
    And clicks the Save button to create the new employee
    Then the Add Employee first name field displays the error "Required"

    Examples:
      | firstname | lastname |
      |           | Doe      |

  @negative
  Scenario Outline: Add an employee with a first name containing special characters
    When the admin enters the employee name with first name "<firstname>" and last name "<lastname>"
    And clicks the Save button to create the new employee
    Then the Add Employee first name field displays the error "First Name must contain only letters"

    Examples:
      | firstname | lastname |
      | John@#5   | Doe      |

  @negative
  Scenario Outline: Add an employee with a first name exceeding 30 characters
    When the admin enters the employee name with first name "<firstname>" and last name "<lastname>"
    Then the Add Employee first name field displays the error "Should not exceed 30 characters"

    Examples:
      | firstname                         | lastname |
      | JonathanEdwardMontgomeryAlexander | Doe      |

  @negative
  Scenario Outline: Add employee with an empty last name
    When the admin enters the employee name with first name "<firstname>" and last name "<lastname>"
    And clicks the Save button to create the new employee
    Then the Add Employee last name field displays the error "Required"

    Examples:
      | firstname | lastname |
      | John      |          |

  @negative
  Scenario Outline: Add an employee with a last name containing special characters
    When the admin enters the employee name with first name "<firstname>" and last name "<lastname>"
    And clicks the Save button to create the new employee
    Then the Add Employee last name field displays the error "Last Name must contain only letters"

    Examples:
      | firstname | lastname |
      | John      | Doe%$%76 |

  @negative
  Scenario Outline: Add an employee with a last name exceeding 30 characters
    When the admin enters the employee name with first name "<firstname>" and last name "<lastname>"
    Then the Add Employee last name field displays the error "Should not exceed 30 characters"

    Examples:
      | firstname | lastname                             |
      | John      | MontgomeryWilliamsonAndersonSmithson |

  @negative
  Scenario Outline: Add an employee with an avatar exceeding the allowed size
    When the admin uploads the avatar "<avatar>"
    Then the Add Employee avatar field displays the error "Attachment Size Exceeded"

    Examples:
      | avatar       |
      | doraemon.png |

  @negative
  Scenario Outline: Add an employee with an invalid avatar format
    When the admin uploads the avatar "<avatar>"
    Then the Add Employee avatar field displays the error "File type not allowed"

    Examples:
      | avatar       |
      | kaitokid.tif |