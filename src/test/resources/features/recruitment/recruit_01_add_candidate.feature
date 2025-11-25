Feature: Add new candidate
  As an HR admin user
  I want to add a new candidate
  So that I can manage recruitment applications

  Background:
    Given the admin has successfully logged in
    And navigates to the Candidate page
    And clicks the Add button to open the Add Candidate page

  @positive
  Scenario Outline: Add a candidate with valid data
    And the admin enters the candidate's information:
      | First Name     | <firstname>      |
      | Last Name      | <lastname>       |
      | Email          | <email>          |
      | Contact Number | <contact_number> |
      | Resume         | <resume>         |
      | Vacancy        | <vacancy>        |
      | Keywords       | <keywords>       |
      | Notes          | <notes>          |
    And clicks the Save button to create the new candidate
    Then the Candidate Profile page displays the candidate’s details
    Examples:
      | firstname | lastname | email                 | contact_number | resume | vacancy           | keywords   | notes            |
      | Henry     | Nguyen   | henry.nguyen@test.com | 0912345678     | CV.pdf | Software Engineer | PHP, MySQL | Strong candidate |

  @negative
  Scenario Outline: Add a candidate with an invalid email format
    When the admin enters the email "<email>"
    Then the Add Candidate email field displays the error "Expected format: admin@example.com"
    Examples:
      | email     |
      | john.doe@ |

  @negative
  Scenario Outline: Add a candidate with an unsupported resume file type
    When the admin uploads the resume file "<resume>"
    Then the Add Candidate resume field displays the error "File type not allowed"
    Examples:
      | resume   |
      | mori.jpg |

  @negative
  Scenario Outline: Add a candidate with a resume file exceeding 1MB
    When the admin uploads the resume file "<resume>"
    Then the Add Candidate resume field displays the error "Attachment Size Exceeded"
    Examples:
      | resume   |
      | test.pdf |

  @negative
  Scenario Outline: Add a candidate with an invalid contact number format
    When the admin enters the contact number "<contact_number>"
    Then the Add Candidate contact number field displays the error "Allows numbers and only + - / ( )"
    Examples:
      | contact_number |
      | 123-abc-999    |