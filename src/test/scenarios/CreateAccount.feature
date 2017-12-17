Feature: RegisterAccount

  Scenario Outline: Register an account
    Given I click sign in button
    And I enter "<emailAddress>" in form
    And I click Create an account button
    And I enter the rest of required fields "<firstName>" "<lastName>" "<password>" "<address>" "<city>" "<state>" "<zipCode>" "<country>" "<mobilePhone>"
    When I click Register button
    Then I am in my account page
    Examples:
      | emailAddress       | firstName | lastName | password | address | city | state    | zipCode | country       | mobilePhone |
      | test12356790@test.pl | Piotr     | Galik    | 99999    | blotna  | LA   | Nebraska | 00000   | United States | 123456789   |

