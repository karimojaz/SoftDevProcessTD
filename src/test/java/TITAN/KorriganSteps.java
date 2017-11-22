package TITAN;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.hamcrest.core.Is.is;

public class KorriganSteps {

    private Board playground;
    @Before
    public void setUp(){
        playground = new Board();
    }

    @When("^Alice plays a korrigan$")
    public void alice_plays_a_korrigan() throws Throwable {
        playground.getActivePlayer().getHand().getCardsInHand().clear();
        playground.getActivePlayer().getHand().add(new Korrigan());
        playground.getActivePlayer().playCard(0);
    }
    @Then("^Alice draws two random cards within the opponent hand$")
    public void alice_draws_two_random_cards_within_the_opponent_hand() {
        //Assert.assertThat(playground.getInactivePlayer().getHand().getSize(),is ());
        Assert.assertThat(playground.getActivePlayer().getKingdom().getKorriganNumber(), is(1));
    }
}
