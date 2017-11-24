package TITAN;

public class Dryad extends Card {

    private int index;

    public void activate(Board board){
        board.getActivePlayer().steal(board.getInactivePlayer(), index);
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String ToString(){
        return "Dryad";
    }
}
