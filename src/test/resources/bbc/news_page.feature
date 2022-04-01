Feature: News Page Verification
  Verification scenarios of BBC news page

  Scenario Outline: Navigate to the “News” section and verify url is correct.
    Given I open a <browser> browser window at <screenSize> size
    And I navigate to the BBC main page
    And I allow cookies from bbc
    When I click the 'News' nav button
    Then URL of the current page matches the News page URL
    Examples:
      | screenSize | browser |
      | desktop    | chrome  |
      | desktop    | firefox |
      | mobile     | chrome  |
      | mobile     | firefox |


