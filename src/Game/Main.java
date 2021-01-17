package Game;


import controller.ListController;

import controller.PlayController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

   // Music introMusic = new Music("introMusic.mp3", true);


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("../UI/GameMain.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /*
        public void openListPage(ActionEvent event) {
            try {
                Parent root1 = FXMLLoader.load(getClass().getResource("../UI/MusicList.fxml"));
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(new Scene(root1));
                window.show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void openPlayPage(ActionEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../UI/play.fxml"));
                AnchorPane pane = loader.load();

                    Stage gamePlay = new Stage();
                    Scene scene = new Scene(pane);
                    gamePlay.setScene(scene);

                     PlayController controller = loader.getController();
                     controller.setMusicInfo(musicTitle.getText(), artist.getText(), timePeriod.getText());


                     gamePlay.show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    */
    public static void main(String[] args) {

        launch();

    }
}