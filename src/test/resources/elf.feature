# new feature
# Tags: optional

Feature: Elf managment effect

  Scenario: an elf is summoned
    When Alice plays an elf
    And the opponent hand is not empty
    Then Alice choose one card in the front of you and Alice copy the effect of this card

      #Scenario: an elf is summoned
        #When Alice plays an elf
        #And the opponent hand is empty
        #Then the card is not activated