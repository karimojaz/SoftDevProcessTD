package TITAN;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class
App extends Application {

    @Override public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("TITAN GAME");
        FXMLLoader loader = FXMLLoader.load(App.class.getResource("/fxml/Game.fxml"));
        Parent root = loader.load();
        Controller myCtrl = loader.getController();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}