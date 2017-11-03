package TITAN;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;

    public Hand() {
        //TODO draw n cards from the deck
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getSize(){
        return hand.size();
    }
}
