Feature: Add new candidate
  As an HR admin user
  I want to add a new candidate
  So that I can manage recruitment applications

  Background:
    Given the admin has successfully logged in
    And navigates to the Candidate page

  @positive
  Scenario Outline: Add candidate with valid data
    When the admin clicks the Add button to open the Add Candidate form
    And enters candidate information
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
    When the admin clicks the Add button to open the Add Candidate form
    When the admin enters first name "<firstname>" last name "<lastname>" and email "<email>"
    Then the email field shows error "Expected format: admin@example.com"
    Examples:
      | firstname | lastname | email     |
      | John      | Doe      | john.doe@ |

  @negative
  Scenario Outline: Add candidate with unsupported CV file type
    When the admin clicks the Add button to open the Add Candidate form
    When the admin enters first name "<firstname>" last name "<lastname>" and email "<email>"
    And uploads resume file "<resume>"
    Then the resume field shows error "File type not allowed"
    Examples:
      | firstname | lastname | email              | resume   |
      | John      | Doe      | john.doe@gmail.com | mori.jpg |

  @negative
  Scenario Outline: Add candidate with CV size exceeding 1MB
    When the admin clicks the Add button to open the Add Candidate form
    When the admin enters first name "<firstname>" last name "<lastname>" and email "<email>"
    And uploads resume file "<resume>"
    Then the resume field shows error "Attachment Size Exceeded"
    Examples:
      | firstname | lastname | email              | resume   |
      | John      | Doe      | john.doe@gmail.com | test.pdf |

  @negative
  Scenario Outline: Add candidate with invalid Contact Number format
    When the admin clicks the Add button to open the Add Candidate form
    When the admin enters basic candidate details
      | First Name     | <firstname>      |
      | Last Name      | <lastname>       |
      | Email          | <email>          |
      | Contact Number | <contact_number> |
    Then the contact number field shows error "Allows numbers and only + - / ( )"
    Examples:
      | firstname | lastname | email              | contact_number |
      | John      | Doe      | john.doe@gmail.com | 123-abc-999    |