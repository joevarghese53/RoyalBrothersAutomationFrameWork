Feature: Verify an End To End scenario

  Background:
    Given user opens website or application
    And user enters the location as "booking.city"
    Then verify user is on the home page

  @web @android
  Scenario: Verify if user can book a bike
    When user enters pickUp and dropOff date and time as "pickUp.date", "pickUp.time","dropOff.date","dropOff.time"
    And clicks the search button
    Then verify the user is on the rental bikes page
    When user clicks the pickup location of the first available bike
    And selects the first available location
    And click book now
    Then verify user is on login page
    When user enters the mobile number "phone.number" and clicks get otp
    Then verify the otp page is displayed
    When user enters the otp and clicks submit
    Then verify the summary page is displayed
    And verify the details displayed