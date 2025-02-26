Feature: Verify user can perform CRUD operations

  @api
  Scenario: verify user can perform update operations
    Given user calls "/users/13" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from file "update_user.json" using pojo
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
    And user set request body from file "create-user.json" using pojo with "name" value "<username>"
    When user makes post request
    Then verify status code is 201
    And verify response body has a field "name" as "<username>"

    Examples:
    |username|
    |qwer    |
    |asdf    |