package TITAN;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;

    private Player owner;

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Hand(Player owner)
    {
        this.owner = owner;

        hand = new ArrayList<Card>();

        for(int i =0; i<5; i++)
            add(owner.getBoard().getDeck().pop());
    }

    public ArrayList<Card> getCardsInHand() {
        return hand;
    }

    public int getSize() {
        return hand.size();
    }

    public Card popAt(int index){
        Card popped = hand.get(index);
        hand.remove(index);
        return popped;
    }

    public void add(Card c){
        hand.add(c);
    }

    public Card chooseCard(int index)
    {
        Card choose = hand.get(index);
        return choose;
    }
}
