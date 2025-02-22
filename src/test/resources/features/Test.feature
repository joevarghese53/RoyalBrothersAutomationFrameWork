Feature: End to End test

  @api
  Scenario: verify user can perform crud operations
    Given user calls "/users" endpoint
    And set header "Content-Type" to "application/json"
    And set header "Authorization" to "Bearer @token"
    And set request body from file "create-user.json" using pojo
    When user makes post request
    Then verify status code is 201