Feature: Negative api scenarios

  @api
  Scenario: verify user cannot perform create operations using invalid data
    Given user calls "/users" endpoint
    And set header "Content-Type" to "application/json"
    And user set request body from file "create-user.json" setting "salary" value "10"
    When user makes post request
    Then verify status code is 201