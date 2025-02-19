Feature: Verify rental location selection feature

  Background:
    Given user opens website or application
    And user enters the location as "booking.city"
    Then verify user is on the home page

  @web @android
  Scenario Outline: User can change location successfully
    When user selects location button
    And user enters the location as "<city>"
    Then verify location is updated correctly

    Examples:
      | city      |
      | Agra      |
      | Bangalore |