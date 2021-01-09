package controller;

import Game.Music;
import Game.Track;
import javafx.event.ActionEvent;
import Game.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ListController {

    @FXML
    Label musicTitle, artist, timePeriod;
    @FXML
    Text text;


    private Music selectedMusic;
    private int nowSelected = 9999;
    private int songsAdded = 0;

    ArrayList<Track> trackList = new ArrayList<Track>();


    public void playBtnHandle(ActionEvent event) {
        Main main = new Main();
        main.openPlayPage(event);
    }


    public void selectTrack(int nowSelected) {
        if (songsAdded == 0) {
        trackList.add(new Track("Energy", "Bensound", "90's", "energy.mp3", "energy.mp3"));
        trackList.add(new Track("Funkyelement", "Bensound", "00's", "funkyelement.mp3", "funkyelement.mp3"));
        trackList.add(new Track("Spotlight", "Deflo & Liam Tylor", "10's", "Spotlight.mp3","Spotlight.mp3"));
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




}
