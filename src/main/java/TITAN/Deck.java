package TITAN;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private ArrayList<Card> cards;

    public Deck(int size)
    {
        cards = new ArrayList<Card>();

        for (int i = 0; i < size/6; i++)
        {
            cards.add(new Gnome());
            cards.add(new Goblin());
            cards.add(new Troll());
            cards.add(new Elf());
            cards.add(new Dryad());
            cards.add(new Korrigan());
        }

        Collections.shuffle(cards);
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
