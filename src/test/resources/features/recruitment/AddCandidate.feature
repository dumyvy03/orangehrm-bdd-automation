Feature: Add new candidate
  As an HR admin user
  I want to add a new candidate
  So that I can manage recruitment applications

  Background:
    Given the admin has successfully logged in
    And navigates to the Candidate page
    And clicks the Add button to open the Add Candidate page

  @positive
  Scenario Outline: Add candidate with valid data
    And the admin enters candidate information
      | First Name     | <firstname>      |
      | Last Name      | <lastname>       |
      | Email          | <email>          |
      | Contact Number | <contact_number> |
      | Resume         | <resume>         |
      | Vacancy        | <vacancy>        |
      | Keywords       | <keywords>       |
      | Notes          | <notes>          |
    And clicks the Save button to add a new candidate
    Then the Candidate Profile page displays the candidate’s details
    Examples:
      | firstname | lastname | email                 | contact_number | resume | vacancy           | keywords   | notes            |
      | Henry     | Nguyen   | henry.nguyen@test.com | 0912345678     | CV.pdf | Software Engineer | PHP, MySQL | Strong candidate |

  @negative
  Scenario Outline: Add candidate with invalid email format
    When the admin enters email "<email>"
    Then the email field shows error "Expected format: admin@example.com"
    Examples:
      | email     |
      | john.doe@ |

  @negative
  Scenario Outline: Add candidate with unsupported CV file type
    When the admin uploads resume file "<resume>"
    Then the resume field shows error "File type not allowed"
    Examples:
      | resume   |
      | mori.jpg |

  @negative
  Scenario Outline: Add candidate with CV size exceeding 1MB
    When the admin uploads resume file "<resume>"
    Then the resume field shows error "Attachment Size Exceeded"
    Examples:
      | resume   |
      | test.pdf |

  @negative
  Scenario Outline: Add candidate with invalid Contact Number format
    When the admin enters contact number "<contact_number>"
    Then the contact number field shows error "Allows numbers and only + - / ( )"
    Examples:
      | contact_number |
      | 123-abc-999    |