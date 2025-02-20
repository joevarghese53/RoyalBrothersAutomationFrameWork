Feature: Validating RB Store

  Background:
    Given user opens website or application
    And user enters the location as "booking.city"
    Then verify user is on the home page

  Scenario: Verify user can buy a product
    When user navigates to RB products page
    Then verify the RB products page is displayed
    When user selects the product "T-Shirts"
    Then verify the product "T-Shirts" store page is displayed
    When user click choose options of the first product
    Then verify if the product drawer is displayed
    When user clicks add to cart
    Then verify if the cart drawer is displayed
    And verify if the added product "first.prod.name" is displayed
    When user closes the cart drawer
    And user click choose options of the second product
    Then verify if the product drawer is displayed
    When user clicks add to cart
    Then verify if the cart drawer is displayed
    And verify if the added product "second.prod.name" is displayed
    When user click checkout button
    Then verify the checkout page is displayed
    And verify the name "first.prod.name" and the price "first.prod.price" of the product
    And verify the name "second.prod.name" and the price "second.prod.price" of the product
    And verify if the total price is correct

