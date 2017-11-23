# new feature
# Tags: optional
    
Feature: Elf managment effect
    
    Scenario: an elf is summoned
          When Alice play an elf
          Then Alice choose one card in the front of you and Alice copy the effect of this card

    Scenario: an elf is played but there only one card left in the deck
              Given There is only one card left in the left
              When Alice plays a Elfe
              Then the card go automaticly to the graveyard