Feature: Verify user can perform CRUD operations

  @api
  Scenario: verify user cannot perform create operations with invalid data
    Given user calls "/users" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from file "create-user.json" using pojo
    When user makes post request
    Then verify status code is 201

  @api
  Scenario: verify user can perform update operations
    Given user calls "/users/13" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from file "update-user.json" using pojo
    When user makes put request
    Then verify status code is 200

  @api
  Scenario: verify user can perform get operations
    Given user calls "/users/13" endpoint
    And set header "Content-Type" to "application/json"
    When user makes get request
    Then verify status code is 200

  @api
  Scenario Outline:Verify if the name and salary created
    Given user calls "/users" endpoint
    And set header "Content-Type" to "application/json"
    And user set request body from file "create-user.json" using pojo with "salary" value "<username>"
    When user makes post request
    Then verify status code is 201
    And verify response body has a field "salary" as "<username>"

    Examples:
    |username|
    |123    |
    |567    |

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