Feature: korrigan management effect

  Scenario: a korrigan is summoned
    When Alice plays a korrigan
    Then Alice draws two random cards within the opponent hand


  #Scenario: a korrigan is played but there is only one card left in the opponent hand
  #Given there is only one card left in the opponent hand
  #When Alice plays a korrigan
  # Then the opponent hand should be empty