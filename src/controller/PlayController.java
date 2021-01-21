package controller;

import Game.Beat;
import Game.Game;
import Game.Music;
import Game.Note;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;

import java.util.ResourceBundle;

public class PlayController implements Initializable {

    @FXML
    Text playMusicTitle, singer;
    @FXML
    Label period;
    @FXML
    Label s, d, f, space, j, k, l;
    @FXML
    public AnchorPane pane = new AnchorPane();

    public Music gameMusic;
    String title;
    String sText;
    String pLabel;

    public PlayController(String title, String sText, String pLabel) {
        this.title = title;
        this.sText = sText;
        this.pLabel = pLabel;
    }
    public PlayController() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
/*
    public void setMusicInfo(String title, String s, String p) {
        playMusicTitle.setText(title);
        singer.setText(s);
        period.setText(p);

    }

*/
    public void setKeyEvent() {
        Scene scene = pane.getScene();
        scene.setOnKeyPressed((KeyEvent event)->{
            if(event.getCode() == KeyCode.S){
                System.out.println("ss");
            }
            if(event.getCode() == KeyCode.D) {
                System.out.println("dd");
            }
            if(event.getCode() == KeyCode.F) {
                System.out.println("ff");
            }
            if(event.getCode() == KeyCode.SPACE) {
                System.out.println("sp");
            }
            if(event.getCode() == KeyCode.J) {
                System.out.println("jj");
            }
            if(event.getCode() == KeyCode.K) {
                System.out.println("kk");
            }
            if(event.getCode() == KeyCode.L) {
                System.out.println("ll");
            }
        });
        scene.setOnKeyReleased((KeyEvent event)->{
            if(event.getCode() == KeyCode.S) {
                System.out.println("s");
            }
            if(event.getCode() == KeyCode.D) {
                System.out.println("d");
            }
            if(event.getCode() == KeyCode.F) {
                System.out.println("f");
            }
            if(event.getCode() == KeyCode.SPACE) {
                System.out.println("space");
            }
            if(event.getCode() == KeyCode.J) {
                System.out.println("j");
            }
            if(event.getCode() == KeyCode.K) {
                System.out.println("k");
            }
            if(event.getCode() == KeyCode.L) {
                System.out.println("l");
            }
        });
       playMusicTitle.setText(this.title);
       singer.setText(this.sText);
       period.setText(this.pLabel);
       playGameMusic();
       Game game = new Game(title,gameMusic, pane);
       game.start();
    }


/*    public void judge() {
        pane.getScene().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if(event.getCode() == KeyCode.S && noteS.getLayoutY() >= 560 && noteS.getLayoutY() < 600) {
                System.out.println("good");
            }
            if(event.getCode() == KeyCode.D) {
                System.out.println("dd");
            }
            if(event.getCode() == KeyCode.F) {
                System.out.println("ff");
            }
            if(event.getCode() == KeyCode.SPACE) {
                System.out.println("sp");
            }
            if(event.getCode() == KeyCode.J) {
                System.out.println("jj");
            }
            if(event.getCode() == KeyCode.K) {
                System.out.println("kk");
            }
            if(event.getCode() == KeyCode.L) {
                System.out.println("ll");
            }
        });

    }

*/

    public void playGameMusic() {
        if (playMusicTitle.getText().equals("Energy")) {
            gameMusic = new Music("energy.mp3", false);
            gameMusic.start();

        } else if (playMusicTitle.getText().equals("Smile")) {
            gameMusic = new Music("smile.mp3", false);
            gameMusic.start();
        } else if (playMusicTitle.getText().equals("Spotlight")) {
            gameMusic = new Music("Spotlight.mp3", false);
            gameMusic.start();
        }
    }



}