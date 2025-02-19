Feature: Chat Bot

  Background:
    Given user opens website or application
    And user enters the location as "booking.city"
    Then verify user is on the home page

  Scenario: Verify if chatbot is responding to user in android
    When user navigates to menu page
    And clicks help & support button
    Then verify user is on help & support page
    When user clicks on chat with us option
    Then verify the chat window is open
    When user sends the message
    Then verify if the message has been sent
    And verify if the chat bot responded to the message

  Scenario: Verify if chatbot is responding to user in web
    When user clicks the chatbot option
    Then verify the chat window is open
    When user sends the message
    Then verify if the message has been sent
    And verify if the chat bot responded to the message