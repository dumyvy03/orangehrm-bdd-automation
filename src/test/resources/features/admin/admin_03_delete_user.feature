Feature: Delete User
  As an admin user
  I want to delete existing system users
  So that I can manage accounts that are inactive or no longer needed

  Background:
    Given the admin has successfully logged in
    And navigates to the User Management page

  @positive
  Scenario Outline: Delete a single user successfully
    When the admin searches for the user "<username>"
    And clicks the Delete button to remove user
    And confirms the deletion
    Then the user table displays "No Records Found"

    Examples:
      | username |
      | tomlee   |

  @positive
  Scenario Outline: Delete multiple users successfully
    When the admin selects multiple users from the user list
      | Username1 | <username1> |
      | Username2 | <username2> |
    And clicks the Delete button to remove the selected user
    And confirms the deletion
    Then the system removes all selected users from the user list
      | Username1 | <username1> |
      | Username2 | <username2> |

    Examples:
      | username1  | username2   |
      | emmaturner | lucasmiller |

  @negative
  Scenario Outline: Cancel user deletion
    When the admin searches for the user "<username>"
    And clicks the Delete button to remove user
    And cancels the deletion
    Then the user "<username>" still appears in the user list
    Examples:
      | username  |
      | masonreed |

