package TITAN;

import cucumber.api.java.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import sun.security.util.PendingException;

import static org.hamcrest.core.Is.is;


public class ElfSteps {

    private Board playground;

    @Before public void setup() {playground = new Board();}

    @When("^Alice plays an elf$")
    public void alice_plays_an_elf() throws  Throwable {
        playground.getActivePlayer().getHand().getCardsInHand().clear();
        playground.getActivePlayer().getHand().add(new Elf());
        playground.getActivePlayer().playCard(0, null);
    }

    @And("^the opponent hand is not empty$")
    public void notempty() throws Throwable{
        playground.getInactivePlayer().getHand().getCardsInHand().clear();
        playground.getInactivePlayer().getHand().add(new Troll());
    }

    @Then("^Alice choose one card in the front of you and Alice copy the effect of this card$")
    public void playgame() throws Throwable{
        notempty();
        alice_plays_an_elf();
        playground.getActivePlayer().getHand().add(playground.getActivePlayer().getHand().getCardsInHand().get(0));
        int pl = playground.getActivePlayer().getHand().getSize();
        System.out.println(pl);
    }

}