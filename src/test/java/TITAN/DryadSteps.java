package TITAN;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.hamcrest.core.Is.is;

public class DryadSteps {

    private Board playground;
    @Before
    public void setUp(){
        playground = new Board();
    }

    @When("^Alice plays a Dryad")
    public void alice_plays_a_dryad() throws Throwable {
        playground.getActivePlayer().getHand().getCardsInHand().clear();
        playground.getActivePlayer().getHand().add(new Dryad());
        playground.getActivePlayer().playCard(0, null);
    }
    @Then("^Alice has one more dryad in her kingdom$")
    public void alice_has_one_more_dryad() {
        Assert.assertThat(playground.getActivePlayer().getKingdom().getRaceNumber(new Dryad()), is(1));
    }

    @And("^Alice stoles a card in front of your opponent and add it in front of you$")
    public void alice_stoles_a_card_in_front_of_your_opponent_and_add_it_in_front_of_you() {
        Assert.assertThat(playground.getInactivePlayer().getKingdom().getSize(),is(0));
        Assert.assertThat(playground.getActivePlayer().getKingdom().getSize(),is(2));
    }

}
