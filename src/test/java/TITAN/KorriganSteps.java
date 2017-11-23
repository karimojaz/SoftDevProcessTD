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
        playground.getActivePlayer().playCard(0);
    }
    /*@Given("there is only one card left in the opponent hand$")
     public void there_is_only_one_card_left_in_the_opponent_hand() throws Throwable
    {
        Assert.assertThat(playground.getInactivePlayer().getHand().getSize(),is(1));
    }*/

    @Then("^Alice draws two random cards within the opponent hand$")
    public void alice_draws_two_random_cards_within_the_opponent_hand() throws Throwable{
        Assert.assertThat(playground.getInactivePlayer().getHand().getSize(),is (3));
        Assert.assertThat(playground.getActivePlayer().getKingdom().getKorriganNumber(), is(1));
    }

    //@Then("Alice should draw only one card$")
    //public void alice_should_draw_only_one_card() {
        //Assert.assertThat(playground.getActivePlayer().getHand().getSize(), is(3));
    //}

    /*@Then("the opponent hand should be empty$")
    public void the_opponent_hand_should_be_empty()throws Throwable
    {
        Assert.assertThat(playground.getInactivePlayer().getHand().getSize(), is(0));
    }*/


}
