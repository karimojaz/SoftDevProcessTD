Feature: goblin management effect

  Scenario: a goblin is summoned
    When Alice play a goblin
    Then Alice has one more goblin in her kingdom
    And Alice switches her hand with the opponent



