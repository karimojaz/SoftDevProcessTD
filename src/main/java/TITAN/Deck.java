package TITAN;

import java.util.ArrayList;

public class Deck
{
    private ArrayList<Card> cards;

    public Deck(int size)
    {
        cards = new ArrayList<Card>(size);
    }

    public ArrayList<Card> getCards() {
        return cards;
    } 
}
