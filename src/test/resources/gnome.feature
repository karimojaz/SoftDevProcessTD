Feature: #gnome effect management

  Scenario: #a gnome is summoned
    Given Alice play a Gnome
    Then Alice has one more gnome in her kingdom
    And Alice draws two cards from the deck

  Scenario: a gnome is played but there only one card left in the deck
    Given There is only one card left in the left
    When Alice play a Gnome
    Then Alice should draw only one card
    And the deck should be empty

  Scenario: a gnome is played but there no card left in the deck
    Given The deck is empty
    When Alice play a Gnome
    Then Alice shouldn't draw card
    And the deck should be empty