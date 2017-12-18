package TITAN;

import java.util.Scanner;

/***
 *  the card ELf  copy and use the power of one of the card in front of the current player
 */
public class Elf extends Card {

    private Card effect;

    /*
     * Activate the Elf functions ( he can copy the power of the chosen card )
     */

    public boolean activate(Board board){
        if ( board.getActivePlayer().getKingdom().getSize() > 0) {
            System.out.print("Pick a card from your kingdom: ");
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            this.setEffect(board.getActivePlayer().getKingdom().getCardsInKingdom().get(index));
            if (effect != null) {
                effect.activate(board);
            }
        }
        return true;
    }

    public void setEffect(Card effect) {
        if (effect.getClass() != this.getClass()) {
            this.effect = effect;
        }
    }

    public Card getEffect() {
        return effect;
    }

    public String toString(){
        return "Elf";
    }


}