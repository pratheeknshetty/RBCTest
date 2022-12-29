@SearchService
Feature: This is the feature to test the Search Service

  @testCountry
  Scenario Outline:Testing the GET Search service for any country passed in parameter
    Given  Search Service Endpoint is setup
    And  I add parameter <parameterName> as <paramValue>
    When I hit the Search Service Endpoint
    Then success response should be returned
    And response should have value <paramValue> in field <parameterName>
    Examples:
      | parameterName | paramValue |
      | country       | Nepal      |


  @testCountryAndName
  Scenario Outline:Testing the GET Search service for any country and the name parameter passed
    Given  Search Service Endpoint is setup
    And  I add parameter <parameterName1> as <paramValue1>
    And  I add parameter <parameterName2> as <paramValue2>
    When I hit the Search Service Endpoint
    Then success response should be returned
    And response should have value <paramValue1> in field <parameterName1>
    And response should contain value <paramValue2> in field <parameterName2>
    Examples:
      | parameterName1 | paramValue1 | parameterName2 | paramValue2 |
      | country        | Nepal       | name           | And         |