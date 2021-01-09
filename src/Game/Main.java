package Game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;

public class Main extends Application {

   // Music introMusic = new Music("introMusic.mp3", true);


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/GameMain.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public void openListPage(ActionEvent event) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("../fxml/MusicList.fxml"));
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(new Scene(root1));
            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void openPlayPage(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../fxml/play.fxml"));
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(new Scene(root2));
            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        launch();

    }
}