package TITAN;

import java.util.Scanner;

public class Elf extends Card {

    private Card effect;

    public void activate(Board board){
        if ( board.getActivePlayer().getKingdom().getSize() > 1) {
            System.out.print("Pick a card from your kingdom: ");
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            this.setEffect(board.getActivePlayer().getKingdom().getCardsInKingdom().get(index));
            if (effect != null) {
                effect.activate(board);
            }
        }
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