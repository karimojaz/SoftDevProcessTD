import TITAN.Board;
import TITAN.Player;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import static org.hamcrest.core.Is.is;

public class PlaygroundStepdefs {
    private Player alice;
    private Board playground;

    @Then("^Alice has (\\d+) cards in the hand$")
    public void aliceHasCardsInTheHand(Integer expectedCardNumber) {
        Assert.assertThat(alice.getHand().size(), is(expectedCardNumber));
    }

    @Given("^The playground is initialized$")
    public void thePlaygroundIsInitialized() throws Throwable {
        playground = new Board();
    }
}
