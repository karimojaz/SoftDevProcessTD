package TITAN;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML private ImageView Card1handplayer1;
    @FXML private SplitPane SplitPane1, SplitPane2;
    @FXML private AnchorPane AnchorPane1, AnchorPane2, AnchorPane3;
    @FXML private ImageView Card2handplayer1;
    @FXML private ImageView Card3handplayer1;
    @FXML private ImageView Card4handplayer1;
    @FXML private ImageView Card5handplayer1;
    @FXML private ImageView Card6handplayer1;
    @FXML private ImageView Card7handplayer1;
    @FXML private ImageView Card8handplayer1;
    @FXML private ImageView Card1handplayer2;
    @FXML private ImageView Card2handplayer2;
    @FXML private ImageView Card3handplayer2;
    @FXML private ImageView Card4handplayer2;
    @FXML private ImageView Card5handplayer2;
    @FXML private ImageView Card6handplayer2;
    @FXML private ImageView Card7handplayer2;
    @FXML private ImageView Card8handplayer2;


   public Controller()
   {
       Board board = new Board();
       this.Card1handplayer1 = new ImageView();
       this.Card1handplayer2 = new ImageView();
       Image carte = new Image(getClass().getResource("/image/DosDeCarte.png").toString());
       Card1handplayer1.setImage(carte);

   }

    public void initialize(URL location, ResourceBundle resources) {

    }
}
