Feature: Verify user can perform CRUD operations

  @api
  Scenario: verify user can perform create operations
    Given user calls "/users" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from file "create-user.json" using pojo
    When user makes post request
    Then verify status code is 201
    And verify response has body same as request
    And verify response has schema same as "response-schema.json"


  @api
  Scenario: verify user can perform update operations
    Given user calls "/users" endpoint
    When user makes get request
    Then verify status code is 200
    And store the "id[0]" from response into "user.id"
    When user calls "/users/{id}" endpoint
    And sets path param for "id" as "user.id"
    And set header "Content-Type" to "application/json"
    And set request body from file "update-user.json" using pojo
    When user makes put request
    Then verify status code is 200
    And verify response has body same as request
    And verify response has schema same as "response-schema.json"

  @api
  Scenario: verify user can perform get operations
    Given user calls "/users/13" endpoint
    When user makes get request
    Then verify status code is 200
    And verify response has schema same as "response-schema.json"

  @api
  Scenario Outline:Verify if the custom field is added correctly
    Given user calls "/users" endpoint
    And set header "Content-Type" to "application/json"
    And user set request body from file "create-user.json" using pojo with "name" value "<username>"
    When user makes post request
    Then verify status code is 201
    And verify response body has a field "name" as "<username>"

    Examples:
      | username |
      | 123      |
      | 567      |

  @api
  Scenario: verify user can perform delete operation and verify it is deleted
    Given user calls "/users" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from file "create-user.json" using pojo
    When user makes post request
    And store the "id" from response into "user.id"
    Then verify status code is 201
    When user calls "/users/{id}" endpoint
    And sets path param for "id" as "user.id"
    And user makes delete request
    Then verify status code is 200
    When user calls "/users/{id}" endpoint
    And sets path param for "id" as "user.id"
    And user makes get request
    Then verify status code is 404

  @api
  Scenario: verify user cannot perform get operations using invalid id
    Given user calls "/users/abcd" endpoint
    And set header "Content-Type" to "application/json"
    When user makes get request
    Then verify status code is 404

  @api
  Scenario: verify user cannot perform Invalid HTTP Methods
    Given user calls "/users/1" endpoint
    And set header "Content-Type" to "application/json"
    And user set invalid request body from file "create-user.json"
    When user makes post request
    Then verify status code is 400

  @api
  Scenario: verify user cannot access invalid endpoints
    Given user calls "/userz" endpoint
    And set header "Content-Type" to "application/json"
    And user set invalid request body from file "create-user.json"
    When user makes post request
    Then verify status code is 400