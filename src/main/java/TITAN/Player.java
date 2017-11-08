package TITAN;

import java.util.ArrayList;

public class Player
{
    private Hand cards;
    private Board playGround;
    private Kingdom cardsPlayed;

    public Player(Board playGround) {
        this.playGround = playGround;
        this.cardsPlayed = new Kingdom(this);
        cards = new Hand(this);
    }

    public Hand getHand() {
        return cards;
    }

    public Board getBoard() {
        return playGround;
    }

    public Kingdom getKingdom() {
        return cardsPlayed;
    }

    public void playCard(int index){
        Card played = cards.popAt(index);
        played.activate(playGround);
        cardsPlayed.add(played);
    }

    public void draw(int number){
        for (int i = 0; i < number; i++) {
            cards.add(playGround.getDeck().pop());
        }
    }
}
