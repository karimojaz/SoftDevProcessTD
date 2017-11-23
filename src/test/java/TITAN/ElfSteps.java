package TITAN;

import cucumber.api.java.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ElfSteps {

    private Board playground;

    @Before public void setup() {playground = new Board();}

    @When("^Alice play an elf$")
        public void alice_plays_an_elf() throws  Throwable {
            playground.getActivePlayer().getHand().getCardsInHand().clear();
            playground.getActivePlayer().getHand().add(new Elf());
            playground.getActivePlayer().playCard(0);
        }

    @Then("^Alice choose one card in the front of you$ and copy the effect if this")
        public void AliceChooseacard()
        {
            Card choose  = playground.getActivePlayer().getHand().chooseCard(1);
            playground.getActivePlayer().getHand().add(choose);
            playground.getActivePlayer().getHand().popAt(0);
        }

    @Given("^There is only one card left in the left$")
    public void There_is_only_one_card_left_in_the_left() throws Throwable {
        playground.getDeck().getCards().clear();
    }

}
