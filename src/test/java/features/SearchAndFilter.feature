Feature: Tests for airbnb

  Scenario: Test 1: Verify that the results match the search criteria

    Given user is on airbnb homepage
    When user searches for criteria
    Then applied filters are correct in the results page
    And displayed properties match the applied filters


  Scenario: Test 2: Verify that the results and details page match the extra filters
    Given user is on airbnb homepage
    When user searches for criteria
    And user applies advanced filters
    Then details of first properly match the applied advanced filters

  Scenario: Test 3: Verify that a property is displayed on the map correctly
    Given user is on airbnb homepage
    When user searches for criteria
    Then user hovers over the first property and and the color of the pin changes
