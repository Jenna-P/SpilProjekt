package controller;

import Game.Main;
import Game.Music;
import Game.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ListController {

    @FXML
    Label musicTitle, artist, timePeriod;
    @FXML
    Text text;
    @FXML
    Button play;

    private Music selectedMusic;

    private int nowSelected = 9999;
    private int songsAdded = 0;

    ArrayList<Track> trackList = new ArrayList<Track>();


    public void playBtnHandle(ActionEvent event) {
        selectedMusic.close();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../UI/play.fxml"));
            PlayController controller = new PlayController(musicTitle.getText());
            loader.setController(controller);
            Parent root2 = loader.load();
            Scene scene = new Scene(root2);


            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            controller.setKeyEvent();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void selectTrack(int nowSelected) {
        if (songsAdded == 0) {
        trackList.add(new Track("Energy", "Bensound", "90's", "energyList.mp3"));
        trackList.add(new Track("Smile", "Joakim Karud", "00's", "smileList.mp3"));
        trackList.add(new Track("Spotlight", "Deflo & Liam Tylor", "10's", "SpotlightList.mp3"));
        songsAdded = 1;
        }

        if (selectedMusic != null)
            selectedMusic.close();
        musicTitle.setText(trackList.get(nowSelected).getTitle());
        artist.setText(trackList.get(nowSelected).getArtistName());
        timePeriod.setText(trackList.get(nowSelected).getTimePeriod());
        selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
        selectedMusic.start();
    }

    public void leftBtnHandle() {
        text.setText("");

        if (nowSelected == 9999) {
            //nowSelected = trackList.size() - 1;
            nowSelected = 0;
            selectTrack(nowSelected);
            System.out.println("Left Start");
        }
        else if (nowSelected == 0) {
            //nowSelected = trackList.size() - 1;
            selectTrack(nowSelected);
            nowSelected = 3;
            System.out.println("Left 1");
        } else {
            nowSelected--;
            selectTrack(nowSelected);
            System.out.println("Left 2");
        }
    }

    public void rightBtnHandle() {
        text.setText("");
        if (nowSelected == 9999) {
            //nowSelected = trackList.size() - 1;
            nowSelected = 0;
            selectTrack(nowSelected);
            System.out.println("Right Start");
        } else if (nowSelected == 3) {
            nowSelected = 0;
            selectTrack(nowSelected);
            System.out.println("Right 2");
        }
        else {
            nowSelected++;
            selectTrack(nowSelected);
            System.out.println("Right 3");
        }
    }

/*
    public void openCompletePage(ActionEvent event) {
        try {
            Parent completeRoot = FXMLLoader.load(getClass().getResource("../UI/complete.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(completeRoot));
            stage.show();

            Thread.sleep(1000);
            Parent cardRoot = FXMLLoader.load(getClass().getResource("../UI/card.fxml"));
            Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window1.setScene(new Scene(cardRoot));
            window1.show();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void showComplete(){
        Stage comStage = new Stage();
        VBox v = new VBox();
        ImageView iv = new ImageView();
        Image image = new Image("Image/complete.png");
        iv.setImage(image);
        v.setAlignment(Pos.CENTER);
        v.getChildren().add(iv);

        Scene scene = new Scene(v, 1280, 720);
        comStage.setScene(scene);
        comStage.showAndWait();

    }
*/

}
