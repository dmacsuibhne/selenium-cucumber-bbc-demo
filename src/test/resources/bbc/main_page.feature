Feature: Main Page Verification
  Verification scenarios of BBC main page

  Scenario Outline: Verify main page content
    Given I open a <browser> browser window at <screenSize> size
    When I navigate to the BBC main page
    And I allow cookies from bbc
    Then the correct day and date is displayed
    When I expand all of the top navigation bars
    Then I see all of the expected top navigation links
    Examples:
      | screenSize | browser |
      | desktop    | chrome  |
      | desktop    | firefox |
      | mobile     | chrome  |
      | mobile     | firefox |
