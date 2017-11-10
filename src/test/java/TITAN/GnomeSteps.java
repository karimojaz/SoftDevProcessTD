package TITAN;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.hamcrest.core.Is.is;

public class GnomeSteps {
    private Board playground;

    @Before public void setUp(){
        playground = new Board();
    }

    @When("^Alice play a Gnome$")
    public void alice_play_a_gnome() throws Throwable {
        playground.getActivePlayer().getHand().getCardsInHand().clear();
        playground.getActivePlayer().getHand().add(new Gnome());
        playground.getActivePlayer().playCard(0);
    }

    @Then("^Alice has one more gnome in her kingdom$")
    public void aliceHas1MoreGnome() {
        Assert.assertThat(playground.getActivePlayer().getKingdom().getGnomeNumber(), is(1));
    }

    @And("^Alice draws two cards from the deck$")
    public void AliceDrawsTwoCardsFromTheDeck() {
        Assert.assertThat(playground.getDeck().getSize(), is(30));
        Assert.assertThat(playground.getActivePlayer().getHand().getSize(), is(2));
    }

    @Given("^There is only one card left in the left$")
    public void There_is_only_one_card_left_in_the_left() throws Throwable {
        playground.getDeck().getCards().clear();
        playground.getDeck().getCards().add(new Gnome());
    }

    @Then("^Alice should draw only one card$")
    public void Alice_should_draw_only_one_card() throws Throwable {
        Assert.assertThat(playground.getActivePlayer().getHand().getSize(), is(1));
    }

    @And("^the deck should be empty$")
    public void the_deck_should_be_empty() throws Throwable {
        Assert.assertThat(playground.getDeck().isEmpty(), is(true));
    }

}
