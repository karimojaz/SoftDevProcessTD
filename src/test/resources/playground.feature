Feature: #playground management

  Scenario: # playground initialization
    Given The playground is initialized
    Then Alice has 5 cards in the hand
    And Alice has 0 people in its kingdom
    Then Bob has 5 cards in the hand
    And Bob has 0 people in its kingdom
