package controller;

import Game.Game;
import Game.Music;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;

import java.util.ResourceBundle;

public class PlayController implements Initializable {

    @FXML
   Text playMusicTitle;
    @FXML
    Text singer;
    @FXML
    public static Label period = new Label();
    @FXML
    Label s, d, f, space, j, k, l;
    @FXML
    public AnchorPane pane = new AnchorPane();
    @FXML
    ImageView sRoute;
    @FXML
    ImageView dRoute;
    @FXML
    ImageView fRoute;
    @FXML
    ImageView spaceRoute;
    @FXML
    ImageView jRoute;
    @FXML
    ImageView kRoute;
    @FXML
    ImageView lRoute;
    @FXML
    Image noteRoute = new Image("Image/noteRoute.png");
    @FXML
    Image sr = new Image("Image/spaceRoute.png");
    @FXML
    ImageView ivJudge;

    public Music gameMusic;
    String title;
    String sText;
    String pLabel;
    Stage comStage = new Stage();
    public static Game game;

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
                sRoute.setVisible(true);
                sRoute.setImage(noteRoute);
                game.judge("S");

            }
            if(event.getCode() == KeyCode.D) {
                dRoute.setVisible(true);
                dRoute.setImage(noteRoute);
               game.judge("D");
            }
            if(event.getCode() == KeyCode.F) {
                fRoute.setVisible(true);
                fRoute.setImage(noteRoute);
                game.judge("F");
            }
            if(event.getCode() == KeyCode.SPACE) {
                spaceRoute.setVisible(true);
                spaceRoute.setImage(sr);
                game.judge("Space");

            }
            if(event.getCode() == KeyCode.J) {
                jRoute.setVisible(true);
                jRoute.setImage(noteRoute);
                game.judge("J");
            }
            if(event.getCode() == KeyCode.K) {
                kRoute.setVisible(true);
                kRoute.setImage(noteRoute);
                game.judge("K");
            }
            if(event.getCode() == KeyCode.L) {
                lRoute.setVisible(true);
                lRoute.setImage(noteRoute);
                game.judge("L");
            }

        });
        scene.setOnKeyReleased((KeyEvent event)->{
            if(event.getCode() == KeyCode.S) {
                sRoute.setVisible(false);

            }
            if(event.getCode() == KeyCode.D) {
                dRoute.setVisible(false);

            }
            if(event.getCode() == KeyCode.F) {
                fRoute.setVisible(false);

            }
            if(event.getCode() == KeyCode.SPACE) {
                spaceRoute.setVisible(false);

            }
            if(event.getCode() == KeyCode.J) {
                jRoute.setVisible(false);

            }
            if(event.getCode() == KeyCode.K) {
                kRoute.setVisible(false);

            }
            if(event.getCode() == KeyCode.L) {
                lRoute.setVisible(false);

            }

        });
       playMusicTitle.setText(this.title);
       singer.setText(this.sText);
       period.setText(this.pLabel);
       playGameMusic();
       this.game = new Game(title,gameMusic, pane, ivJudge);
       game.start();

    }

    public void playGameMusic() {
        if (playMusicTitle.getText().equals("Energy")) {
            gameMusic = new Music("energy.mp3", false);
            gameMusic.start();
            showComplete(10); //time should change to song durations
            showCard(11);
        } else if (playMusicTitle.getText().equals("Smile")) {
            gameMusic = new Music("smile.mp3", false);
            gameMusic.start();
            showComplete(100);
        } else if (playMusicTitle.getText().equals("Spotlight")) {
            gameMusic = new Music("Spotlight.mp3", false);
            gameMusic.start();
            showComplete(214);
            showCard(215);
        } else if (playMusicTitle.getText().equals("Disco")) {
            gameMusic = new Music("test70.mp3", false);
            gameMusic.start();
            showComplete(38);
            showCard(39);
        }
    }
    public void showComplete(int time) {
        Timeline timer = new Timeline(new KeyFrame(Duration.seconds(time), (ActionEvent event) -> {
            gameMusic.close();
            pane.getScene().getWindow().hide();

            try {
                Parent root = FXMLLoader.load(getClass().getResource("../UI/complete.fxml"));
                comStage.setScene(new Scene(root));
                comStage.setResizable(false);
                comStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }));
        timer.setCycleCount(1);
        timer.play();


    }

    public void showCard(int cardTime) {

            Timeline timer = new Timeline(new KeyFrame(Duration.seconds(cardTime), (ActionEvent event) -> {
                comStage.close();
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../UI/card.fxml"));
                    Parent cardRoot = loader.load();
                    comStage.setScene(new Scene(cardRoot));

                    CardController cardCon = loader.getController();
                    cardCon.popUpCard();
                    comStage.setResizable(false);
                    comStage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }));
            timer.setCycleCount(1);
            timer.play();

        }

    }