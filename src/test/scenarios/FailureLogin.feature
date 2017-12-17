Feature: SuccessLogin

  Scenario Outline: Cannot log in
    Given I click main signin button
    And I enter bad email "<emailAddress>" in form
    And I enter bad password "<password>" in form
    When I click Signin button
    Then I have authentication failure
    Examples:
      | emailAddress   | password |
      | test11@test.pl | xxxxx    |
      | test12@test.pl | yyyyy    |

