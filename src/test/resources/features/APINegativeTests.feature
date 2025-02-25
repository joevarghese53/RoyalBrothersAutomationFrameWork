Feature: Negative api scenarios

  @api
  Scenario: verify user cannot perform create operations using invalid data
    Given user calls "/users" endpoint
    And set header "Content-Type" to "application/json"
    And user set request body from file "create-user.json" setting "salary" value "4324324"
    When user makes post request
    Then verify status code is not 201

  @api
  Scenario: verify user cannot perform ger operations using invalid id
    Given user calls "/users/abcd" endpoint
    And set header "Content-Type" to "application/json"
    When user makes get request
    Then verify status code is 404