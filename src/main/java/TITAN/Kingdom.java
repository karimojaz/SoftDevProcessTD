package TITAN;

import java.util.ArrayList;

public class Kingdom
{
    private ArrayList<Card> cardsInKingdom;
    private Player owner;

    public Kingdom(Player owner)
    {
        this.owner = owner;
        cardsInKingdom = new ArrayList<Card>();
    }

    public Player getOwner() { return owner; }

    public ArrayList<Card> getCardsInKingdom() {
        return cardsInKingdom;
    }
}
