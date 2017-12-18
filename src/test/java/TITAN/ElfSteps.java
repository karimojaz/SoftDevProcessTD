package TITAN;

import cucumber.api.java.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import sun.security.util.PendingException;

import static org.hamcrest.core.Is.is;


public class ElfSteps {

    private Board playground;

    @Before public void setup() {playground = new Board();}


    @Given("^There is zero card in the opponent kingdom$")
    public void There_is_zero_card_in_the_opponent_kingdom() throws Throwable {
        playground.getInactivePlayer().getKingdom().clearKingdom();
        playground.getDeck().getCards().add(new Elf());
        throw  new PendingException();
    }


    @When("^Alice plays an elf$")
        public void alice_plays_an_elf() throws  Throwable {
            playground.getActivePlayer().getHand().getCardsInHand().clear();
            playground.getActivePlayer().getHand().add(new Elf());
            playground.getActivePlayer().playCard(0);
        }

    @Then("^Alice choose one card in the front of you and Alice copy the effect of this card$")
        public void AliceChooseacard()
        {
            Assert.assertThat(playground.getActivePlayer().getKingdom().getSize(), is(1));
        }


    @Then("^the card is not activated$")
        public void Card_is_not_activated() throws Throwable {
        Assert.assertThat(playground.getInactivePlayer().getKingdom().getSize(), is(0));
    }


    @Then("^the card goes automatically to the kingdom$")
    public void Card_goes_to_the_kingdom() throws  Throwable {
        Assert.assertThat(playground.getActivePlayer().getHand().getSize(), is(1));

    }



}
