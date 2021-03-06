package TITAN;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
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
        playground.getActivePlayer().playCard(0, null);
    }

    @Then("^Alice draws two random cards within the opponent hand$")
    public void alice_draws_two_random_cards_within_the_opponent_hand() throws Throwable{
        Assert.assertThat(playground.getInactivePlayer().getHand().getSize(),is (3));
        Assert.assertThat(playground.getActivePlayer().getKingdom().getRaceNumber(new Korrigan()), is(1));
        Assert.assertThat(playground.getActivePlayer().getHand().getSize(),is(6));
    }

    @Given("^there is only one card left in the opponent hand$")
     public void there_is_only_one_card_left_in_the_opponent_hand() throws Throwable
    {
        Assert.assertThat(playground.getInactivePlayer().getHand().getSize(),is(1));
    }


    @Then("^the opponent hand should be empty$")
    public void the_opponent_hand_should_be_empty()throws Throwable
    {
        Assert.assertThat(playground.getInactivePlayer().getHand().getSize(), is(0));
    }

    @Given("^the opponent hand is empty$")
    public void the_opponent_hand_is_empty() throws Throwable
    {
        Assert.assertThat(playground.getInactivePlayer().getHand().getSize(), is(0));
    }

    @Then("^Alice still have the same amount of cards in her hand$")
    public void Alice_still_have_the_same_amount_of_cards_in_her_hand() throws Throwable
    {
        Assert.assertThat(playground.getActivePlayer().getHand().getSize(),is(5));
    }


}
