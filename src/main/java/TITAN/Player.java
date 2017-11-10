package TITAN;

import java.util.ArrayList;
import java.util.Random;

public class Player
{
    private Hand cards;
    private Board playGround;
    private Kingdom cardsPlayed;

    public Player(Board playGround) {
        this.playGround = playGround;
        this.cardsPlayed = new Kingdom(this);
        this.cards = new Hand(this);
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

    private void setKingdom(Kingdom cardsPlayed) {
        this.cardsPlayed = cardsPlayed;
    }

    private void setHand(Hand cards) {
        this.cards = cards;
    }

    public void playCard(int index){
        Card played = cards.popAt(index);
        played.activate(playGround);
        cardsPlayed.add(played);
    }

    public void draw(int number){
        for (int i = 0; i < number; i++) {
            if (playGround.getDeck().getSize()>0) {
                cards.add(playGround.getDeck().pop());
            }
        }
    }

    public void steal(Player opponent){
        Random rand = new Random();
        if (opponent.getHand().getSize()>0) {
            int randomInt = rand.nextInt(opponent.getHand().getSize());
            cards.add(opponent.getHand().popAt(randomInt));
        }
        if (opponent.getHand().getSize()>0) {
            int randomInt = rand.nextInt(opponent.getHand().getSize());
            cards.add(opponent.getHand().popAt(randomInt));
        }
    }

    public void steal(Player opponent, int index){
        cards.add(opponent.getKingdom().popAt(index));
    }

    public void swapKingdom(Player opponent){
        Kingdom k = this.cardsPlayed;
        this.setKingdom(opponent.getKingdom());
        opponent.setKingdom(k);
        this.cardsPlayed.setOwner(this);
        opponent.getKingdom().setOwner(opponent);
    }

    public void swapHand(Player opponent){
        Hand h = this.cards;
        this.setHand(opponent.getHand());
        opponent.setHand(h);
        this.cards.setOwner(this);
        opponent.getHand().setOwner(opponent);
    }
}
