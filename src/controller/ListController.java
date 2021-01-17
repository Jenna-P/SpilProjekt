package controller;

import Game.Music;
import Game.Track;
import javafx.event.ActionEvent;
import Game.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
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
    private Music gameMusic;
    private int nowSelected = 9999;
    private int songsAdded = 0;


    ArrayList<Track> trackList = new ArrayList<Track>();



    public void playBtnHandle(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../UI/play.fxml"));
            Parent root2 = loader.load();
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(new Scene(root2));
            window.show();

            PlayController controller = loader.getController();
            controller.setMusicInfo(musicTitle.getText(), artist.getText(), timePeriod.getText());
            //controller.keyPressed();
            //controller.keyReleased();
            //controller.setNote();

        } catch (IOException e) {
            e.printStackTrace();
        }

        onMusic();


      /*  try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../UI/play.fxml"));
            Parent root2 = loader.load();

            PlayController controller = loader.getController();
            controller.setMusicInfo(musicTitle.getText(), artist.getText(), timePeriod.getText());
            play.getScene().setRoot(root2);
            controller.keyPressed();
            controller.keyReleased();
            //controller.setNote();

        } catch (IOException e) {
            e.printStackTrace();
        }


*/
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

    public void onMusic() {
        if (musicTitle.getText().equals("Energy")) {
            selectedMusic.close();
            gameMusic = new Music("energy.mp3", false);
            gameMusic.start();


        } else if (musicTitle.getText().equals("Smile")) {
            selectedMusic.close();
            gameMusic = new Music("smile.mp3", false);
            gameMusic.start();
        } else if (musicTitle.getText().equals("Spotlight")) {
            selectedMusic.close();
            gameMusic = new Music("Spotlight.mp3", false);
            gameMusic.start();

        }

    }






}
