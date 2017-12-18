package TITAN;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;



public class Controller implements Initializable
{
    private Board board;
    @FXML private ImageView p1hand_c1, p1hand_c2, p1hand_c3, p1hand_c4, p1hand_c5, p1hand_c6, p1hand_c7, p1hand_c8, p1hand_c9, p1hand_c10, p2hand_c1, p2hand_c2, p2hand_c3, p2hand_c4, p2hand_c5, p2hand_c6, p2hand_c7, p2hand_c8, p2hand_c9, p2hand_c10;
    private ArrayList<ImageView> P1HAND, P2HAND;
    private Image dry, elf, gno, gob, korr, troll;

    public Controller()
    {
        board = new Board();
        dry = new Image(new File("resources/image/Dryad.png").toURI().toString());
        elf = new Image(new File("resources/image/Elf.png").toURI().toString());
        gno = new Image(new File("resources/image/Gnome.png").toURI().toString());
        gob = new Image(new File("resources/image/Goblin.png").toURI().toString());
        korr = new Image(new File("resources/image/Korrigan.png").toURI().toString());
        troll = new Image(new File("resources/image/Troll.png").toURI().toString());
    }

    @FXML public void initialize(URL location, ResourceBundle resources)
    {
        P1HAND = new ArrayList<>(Arrays.asList(p1hand_c1, p1hand_c2, p1hand_c3, p1hand_c4, p1hand_c5, p1hand_c6, p1hand_c7, p1hand_c8, p1hand_c9, p1hand_c10));
        P2HAND = new ArrayList<>(Arrays.asList(p2hand_c1, p2hand_c2, p2hand_c3, p2hand_c4, p2hand_c5, p2hand_c6, p2hand_c7, p2hand_c8, p2hand_c9, p2hand_c10));

        populateHands();
    }

    private void populateHands()
    {
        for(int i =0; i<P1HAND.size(); i++)
        {
            if(i < board.getP1().getHand().getCardsInHand().size())
                P1HAND.get(i).setImage(getAppropriateImg(board.getP1().getHand().getCardsInHand().get(i)));
            else
                P1HAND.get(i).setImage(null);
        }

        for(int i =0; i<P2HAND.size(); i++)
        {
            if(i < board.getP2().getHand().getCardsInHand().size())
                P2HAND.get(i).setImage(getAppropriateImg(board.getP2().getHand().getCardsInHand().get(i)));
            else
                P2HAND.get(i).setImage(null);
        }
    }

    private Image getAppropriateImg(Card c)
    {
        if(c instanceof Dryad)
            return dry;
        else if(c instanceof Elf)
            return elf;
        else if(c instanceof Gnome)
            return gno;
        else if(c instanceof Goblin)
            return gob;
        else if(c instanceof Korrigan)
            return korr;
        else if(c instanceof Troll)
            return troll;
        else
            return null;
    }
}