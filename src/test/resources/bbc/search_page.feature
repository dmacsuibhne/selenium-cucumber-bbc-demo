Feature: Main Search Verification
  Verification scenarios of BBC search page

  Scenario Outline: In the top navigation, perform a search for “Houghton Mifflin Harcourt” and verify the search results.
    Given I open a <browser> browser window at <screenSize> size
    And I navigate to the BBC main page
    And I allow cookies from bbc
    When I click the main page search button
    And I search for "Houghton Mifflin Harcourt"
    Then one of the search results mentions "Houghton Mifflin"
    Examples:
      | screenSize | browser |
      | desktop    | chrome  |
      | desktop    | firefox |
      | mobile     | chrome  |
      | mobile     | firefox |
