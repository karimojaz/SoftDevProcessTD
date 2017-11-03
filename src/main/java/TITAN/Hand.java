package TITAN;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;
    private Player owner;

    public Hand(Player owner)
    {
        this.owner = owner;

        hand = new ArrayList<Card>();

        for(int i =0; i<5; i++)
            hand.add(owner.getPlayGround().cards.pop());
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getSize() {
        return hand.size();
    }
}
