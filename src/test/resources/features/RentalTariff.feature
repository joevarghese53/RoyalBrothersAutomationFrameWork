Feature: Verify tariff displayed

  Background:
    Given user opens website or application
    And user enters the location as "booking.city"
    Then verify user is on the home page

  @android @web
  Scenario: Verify tariff displayed is correct
    When user navigates to tariffs page
    Then verify user is on tariffs page
    And store the tariff displayed
    When user clicks book now on tariff page
    And user enters pickUp and dropOff date and time as "pickUp.date", "pickUp.time","dropOff.date","dropOff.time"
    And clicks on check availability
    Then verify the user is on the rental bikes page
    And verify price is displayed according to tariff
