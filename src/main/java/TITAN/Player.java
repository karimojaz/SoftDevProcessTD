package TITAN;

import java.util.Random;

/**
 * Define each player
 *  the player has a set of cards, a kingdom and a board
 */

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

    /*
     * the player choose a card in his hand and play it, the hand is reduced
     */
    public void playCard(int index){
        Card played = cards.popAt(index);
        cardsPlayed.add(played);
        //played.activate(playGround);
    }

    /*
     * the player pick a card in the deck
     */
    public void draw(int number){
        for (int i = 0; i < number; i++) {
            if (playGround.getDeck().getSize()>0) {
                cards.add(playGround.getDeck().pop());
            }
        }
    }

    /*
     * the current player steals randomly a card in his  opponent hand
     */
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

    /*
     * the current player  steals a chosen card in his opponent hand
     */

    public void steal(Player opponent, int index){
        if (index != -1) {
            cardsPlayed.add(opponent.getKingdom().popAt(index));
        }
    }

    /*
     * the current player and the opponnent  kingdoms are swapped
     */
    public void swapKingdom(Player opponent){
        Kingdom k = this.cardsPlayed;
        this.setKingdom(opponent.getKingdom());
        opponent.setKingdom(k);
        this.cardsPlayed.setOwner(this);
        opponent.getKingdom().setOwner(opponent);
    }

    /*
     * the current player and the opponnent hand  are swapped
     */

    public void swapHand(Player opponent){
        Hand h = this.cards;
        this.setHand(opponent.getHand());
        opponent.setHand(h);
        this.cards.setOwner(this);
        opponent.getHand().setOwner(opponent);
    }
}
