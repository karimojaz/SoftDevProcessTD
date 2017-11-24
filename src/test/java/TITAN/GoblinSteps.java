package TITAN;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.hamcrest.core.Is.is;

public class GoblinSteps {

    private Board playground;
    @Before
    public void setUp(){
        playground = new Board();
    }

    @When("^Alice plays a goblin$")
    public void alice_plays_a_goblin() throws Throwable {
        playground.getActivePlayer().getHand().getCardsInHand().clear();
        playground.getActivePlayer().getHand().add(new Goblin());
        playground.getActivePlayer().playCard(0);
    }
    @Then("^Alice has one more goblin in her kingdom$")
    public void alice_has_one_more_goblin() {
        Assert.assertThat(playground.getActivePlayer().getKingdom().getRaceNumber(new Goblin()), is(1));
    }

    @And("^Alice switches her hand with the opponent$")
    public void alice_switches_her_hand_with_the_opponent() {
        Assert.assertThat(playground.getActivePlayer().getHand().getSize(), is(5));
        Assert.assertThat(playground.getInactivePlayer().getHand().getSize(), is(0));
    }
}
