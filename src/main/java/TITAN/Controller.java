package TITAN;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ImageView Card1handplayer1;
    @FXML
    private SplitPane SplitPane1, SplitPane2;
    @FXML
    private AnchorPane AnchorPane1, AnchorPane2, AnchorPane3;
    @FXML
    private ImageView Card2handplayer1;
    @FXML
    private ImageView Card3handplayer1;
    @FXML
    private ImageView Card4handplayer1;
    @FXML
    private ImageView Card5handplayer1;
    @FXML
    private ImageView Card6handplayer1;
    @FXML
    private ImageView Card7handplayer1;
    @FXML
    private ImageView Card8handplayer1;
    @FXML
    private ImageView Card1handplayer2;
    @FXML
    private ImageView Card2handplayer2;
    @FXML
    private ImageView Card3handplayer2;
    @FXML
    private ImageView Card4handplayer2;
    @FXML
    private ImageView Card5handplayer2;
    @FXML
    private ImageView Card6handplayer2;
    @FXML
    private ImageView Card7handplayer2;
    @FXML
    private ImageView Card8handplayer2;
    @FXML
    private Button button;

    private Board board;
    private ArrayList<ImageView> ImagePlayer1;
    private ArrayList<ImageView> ImagePlayer2;


    public Controller() {
        board = new Board();
        this.Card1handplayer1 = new ImageView();
        this.Card1handplayer2 = new ImageView();
        this.Card2handplayer2 = new ImageView();
        this.Card3handplayer2 = new ImageView();
        this.Card4handplayer2 = new ImageView();
        this.Card5handplayer2 = new ImageView();
        this.Card6handplayer2 = new ImageView();
        this.Card7handplayer2 = new ImageView();
        this.Card8handplayer2 = new ImageView();
        this.Card2handplayer1 = new ImageView();
        this.Card3handplayer1 = new ImageView();
        this.Card4handplayer1 = new ImageView();
        this.Card5handplayer1 = new ImageView();
        this.Card6handplayer1 = new ImageView();
        this.Card7handplayer1 = new ImageView();
        this.Card8handplayer1 = new ImageView();



    }

    @FXML
    public void Change() {
        Image carte = new Image(getClass().getResource("/image/DosDeCarte.png").toString());
        Card1handplayer1.setImage(carte);
        Card2handplayer1.setImage(carte);
        Card3handplayer1.setImage(carte);
        Card4handplayer1.setImage(carte);
        Card5handplayer1.setImage(carte);
        Card1handplayer2.setImage(carte);
        Card2handplayer2.setImage(carte);
        Card3handplayer2.setImage(carte);
        Card4handplayer2.setImage(carte);
        Card4handplayer2.setImage(carte);
        Card5handplayer2.setImage(carte);
        Card6handplayer2.setImage(carte);
        Card6handplayer1.setImage(carte);
    }

    public void initialize(URL location, ResourceBundle resources) {
    }

}
