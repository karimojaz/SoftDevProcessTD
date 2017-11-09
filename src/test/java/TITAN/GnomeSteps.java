package TITAN;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import static org.hamcrest.core.Is.is;

public class GnomeSteps {
    private Board playground;

    @Given("^Alice play a Gnome$")
    public void alice_play_a_gnome() throws Throwable {
        playground = new Board();
        playground.getActivePlayer().getHand().add(new Gnome());
        playground.getActivePlayer().playCard(playground.getActivePlayer().getHand().getSize()-1);
    }

    @Then("^Alice has one more gnome in her kingdom$")
    public void aliceHas1MoreGnome() {
        Assert.assertThat(playground.getActivePlayer().getKingdom().getGnomeNumber(), is(1));
    }

    @And("^Alice draws two cards from the deck$")
    public void AliceDrawsTwoCardsFromTheDeck() {
        Assert.assertThat(playground.getDeck().getSize(), is(30));
        Assert.assertThat(playground.getActivePlayer().getHand().getSize(), is(6));
    }

}
