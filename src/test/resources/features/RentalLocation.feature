Feature: Verify rental location selection feature

  Background:
    Given user opens website or application
    When user enters the location as "booking.city"
    Then verify user is on the home page

  Scenario Outline: User can change location successfully
    When user selects location button
    And user enters the location as "<booking.city>"
    Then verify location is updated correctly

    Examples:
      | booking.city |
      | Agra         |
      | Bangalore    |