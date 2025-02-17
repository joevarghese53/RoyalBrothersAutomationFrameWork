Feature: Verify filter and sort functionality

  Background:
    Given user opens website or application
    And user enters the location as "booking.city"
    Then verify user is on the home page

  @web @android
  Scenario Outline: Filter functionality
    When user enters pickUp and dropOff date and time as "pickUp.date", "pickUp.time","dropOff.date","dropOff.time"
    And clicks the search button
    Then verify the user is on the rental bikes page
    When user clicks on filter and sort button
    And applies filter "<filter>" with option "<option>"
    Then verify filter "<filter>" is applied with "<option>"

    Examples:
      | filter   | option                  |
      | Category | Commuter                |
      | Location | Central Railway station |
      | Model    | Aprilia                 |