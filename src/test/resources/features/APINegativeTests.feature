Feature: Negative api scenarios

  @api
  Scenario: verify user cannot perform create operations using invalid data
    Given user calls "/users" endpoint
    And set header "Content-Type" to "application/json"
    And user set invalid request body from file "invalid-user.json"
    When user makes post request
    Then verify status code is not 201

  @api
  Scenario: verify user cannot perform create operations without body
    Given user calls "/users" endpoint
    And set header "Content-Type" to "application/json"
    When user makes post request
    Then verify status code is not 201

  @api
  Scenario: verify user cannot perform create operations using invalid header
    Given user calls "/users" endpoint
    And set header "Content-Type" to "test/xml"
    And user set invalid request body from file "create-user.json"
    When user makes post request
    Then verify status code is not 201


