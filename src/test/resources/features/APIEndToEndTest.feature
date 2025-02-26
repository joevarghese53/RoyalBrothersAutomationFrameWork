Feature: Verify user can perform end to end operations

  @api
  Scenario: verify user can perform end to end operations
    Given user calls "/users" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from file "create-user.json" using pojo
    When user makes post request
    Then verify status code is 201
    And verify response has body same as request
    And verify response has schema same as "response-schema.json"
    And store the "id" from response into "user.id"
    When user calls "/users/{id}" endpoint
    And sets path param for "id" as "user.id"
    And user makes get request
    Then verify status code is 200
    And verify response body has a field "name" as "Joe Varghese"
    And verify response has schema same as "response-schema.json"
    When user calls "/users/{id}" endpoint
    And sets path param for "id" as "user.id"
    And set header "Content-Type" to "application/json"
    And set request body from file "update-user.json" using pojo
    And user makes put request
    Then verify status code is 200
    And verify response has body same as request
    And verify response has schema same as "response-schema.json"