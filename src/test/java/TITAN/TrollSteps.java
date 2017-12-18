package TITAN;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.hamcrest.core.Is.is;

public class TrollSteps {

    private Board playground;
    @Before
    public void setUp(){
        playground = new Board();
    }

    @When("^Alice plays a troll$")
    public void alice_plays_a_troll() throws Throwable {
        playground.getActivePlayer().getHand().getCardsInHand().clear();
        playground.getActivePlayer().getHand().add(new Troll());
        playground.getActivePlayer().playCard(0);
    }
    @Then("^Alice swaps the cards in front of her with the opponent$")
    public void alice_swaps_the_cards_in_front_of_her_with_the_opponent() {
        Assert.assertThat(playground.getInactivePlayer().getKingdom().getRaceNumber(new Troll()), is(1));
        Assert.assertThat(playground.getActivePlayer().getKingdom().getRaceNumber(new Troll()), is(0));
    }

}
