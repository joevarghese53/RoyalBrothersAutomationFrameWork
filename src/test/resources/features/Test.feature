Feature: End to End test

  @api
  Scenario: verify user can perform crud operations
    Given user calls "/users" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from file "create-user.json" using pojo
    When user makes post request
    Then verify status code is 201

  @api
  Scenario: verify user cannot perform create operations with invalid data
    Given user calls "/users" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from file "invalid-user.json" using pojo
    When user makes post request
    Then verify status code is 201

  @api
  Scenario: verify user can perform update operations
    Given user calls "/users/13" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from file "update_user.json" using pojo
    When user makes put request
    Then verify status code is 200