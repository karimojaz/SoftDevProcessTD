package TITAN;

import java.util.ArrayList;

public class Deck
{
    private ArrayList<Card> cards;

    public Deck(int size)
    {
        cards = new ArrayList<Card>();
        for (int i = 0; i < size; i++)
        {
            cards.add(new Gnome());
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card pop()
    {
        Card c = cards.get(0);
        cards.remove(0);
        return c;
    }

    public int getSize(){
        return cards.size();
    }

    public boolean isEmpty(){
        return  cards.isEmpty();
    }
}
