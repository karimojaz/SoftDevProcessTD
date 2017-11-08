Feature: #gnome effect management

  Scenario: #a gnome is summoned
    Given Alice play a Gnome
    Then Alice has one more gnome in her kingdom
    And Alice draws two cards from the deck
