Feature: dryad management effect

  Scenario: a dryad is summoned
    When Alice plays a Dryad
    Then Alice has one more dryad in her kingdom
    And Alice stoles a card in front of your opponent and add it in front of you