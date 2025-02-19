Feature: Verify filter and sort functionality

  Background:
    Given user opens website or application
    And user enters the location as "booking.city"
    Then verify user is on the home page

  @android
  Scenario Outline: Filter functionality android
    When user enters pickUp and dropOff date and time as "pickUp.date", "pickUp.time","dropOff.date","dropOff.time"
    And clicks the search button
    Then verify the user is on the rental bikes page
    When user clicks on filter and sort button
    And user applies filter "<filter>" with option "<option>"
    Then verify filter "<filter>" is applied with "<option>"

    Examples:
      | filter   | option                  |
      | Category | Commuter                |
      | Location | Central Railway station |
      | Model    | Aprilia                 |

  @android
  Scenario Outline: Sort Functionality android
    When user enters pickUp and dropOff date and time as "pickUp.date", "pickUp.time","dropOff.date","dropOff.time"
    And clicks the search button
    Then verify the user is on the rental bikes page
    When user clicks on filter and sort button
    And user applies sorting with "<option>"
    Then verify items are sorted according to "<option>"

    Examples:
      | option      |
      | High to Low |
      | Low to High |

  @web
  Scenario Outline: Filter functionality web
    When user enters pickUp and dropOff date and time as "pickUp.date", "pickUp.time","dropOff.date","dropOff.time"
    And clicks the search button
    Then verify the user is on the rental bikes page
    When user applies filter "<filter>" with option "<option>"
    Then verify filter "<filter>" is applied with "<option>"

    Examples:
      | filter   | option                  |
      | Model    | Aprilia                 |
      | Location | Central Railway station |


  @web
  Scenario Outline: Sort Functionality web
    When user enters pickUp and dropOff date and time as "pickUp.date", "pickUp.time","dropOff.date","dropOff.time"
    And clicks the search button
    Then verify the user is on the rental bikes page
    When user applies sorting with "<option>"
    Then verify items are sorted according to "<option>"

    Examples:
      | option      |
      | High to Low |
      | Low to High |