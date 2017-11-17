package TITAN;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    /*public static void main(String[] args) {

        System.out.println("Hello World!");

    }*/

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage=primaryStage;
        stage.setTitle("TITAN GAME");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/TitanGame.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}