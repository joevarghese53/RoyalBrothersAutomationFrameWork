Feature: Verify an End To End scenario

  Background:
    Given user opens website or application
    When user enters the location as "location"
    Then verify user is on the home page

  Scenario: Verify if user can book a bike
    When user enters pickUp and dropOff date and time as "pickUp.date", "pickUp.time","dropOff.date","dropOff.time"
    And clicks the search button
    Then verify the user is on the rental bike page
    When user clicks the pickup location of the first available bike
    And selects the first available location
    And click book now
    Then verify get otp login page is displayed
    When user does login with phone number "phone.number"
    Then Verify the summary page is displayed