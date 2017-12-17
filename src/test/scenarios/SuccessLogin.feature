Feature: SuccessLogin

  Scenario Outline: Successfully log in
    Given I click main sign in button
    And I enter email "<emailAddress>" in form
    And I enter password "<password>" in form
    When I click Sign in button
    Then I have logged in
    Examples:
      | emailAddress   | password |
      | test11@test.pl | 12346    |
      | test12@test.pl | 99999    |

