Feature: gnome management effect

  Scenario: a gnome is summoned
    When Alice plays a Gnome
    Then Alice has one more gnome in her kingdom
    And Alice draws two cards from the deck

  Scenario: a gnome is played but there only one card left in the deck
    Given There is only one card left in the deck
    When Alice plays a Gnome
    Then Alice should draw only one card
    And the deck should be empty

  Scenario: a gnome is played but there is no card left in the deck
    Given The deck is empty
    When Alice plays a Gnome
    Then Alice shouldn't draw card
    And the deck should be empty