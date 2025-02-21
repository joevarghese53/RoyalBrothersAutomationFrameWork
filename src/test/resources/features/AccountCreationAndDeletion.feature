Feature: Validate account creation and deletion functionality

  Background:
    Given user opens website or application
    And user enters the location as "booking.city"
    Then verify user is on the home page

  @android
  Scenario: User can delete account successfully
    When user navigates to menu page
    And user clicks on "Login" button
    Then verify user is on login page
    When user enters the mobile number "phone.number" and clicks get otp
    Then verify the otp page is displayed
    When user enters the otp and clicks submit
    Then verify user is on the home page
    When user navigates to menu page
    Then verify username is displayed in profile section
    When user clicks on view profile button
    Then verify the profile page is displayed
    When user clicks on delete account
    Then verify account deleted message is displayed

  @android
  Scenario: User can create account successfully in android
    When user navigates to menu page
    And user clicks on "Sign up" button
    Then verify user is on login page
    When user enters the mobile number "phone.number" and clicks get otp
    Then verify the otp page is displayed
    When user enters the otp and clicks submit
    Then verify user is on create account page
    When user enters name "profile.username" and email "email.address" and clicks submit
    And user enters the location as "booking.city"
    Then verify user is on the home page
    When user navigates to menu page
    Then verify username is displayed in profile section

  @web
  Scenario: User can create account successfully in web
    When user clicks on "Sign up" button
    Then verify user is on login page
    When user enters details "profile.username" , "email.address" , "profile.password" and "phone.number" and clicks Sign Up
    Then verify the account verification page is displayed
    When user enters the otp and clicks submit
    And user enters the location as "booking.city"
    Then verify user is on the home page
    And verify username is displayed in profile section