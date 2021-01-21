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

import javax.imageio.plugins.tiff.TIFFImageReadParam;
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
                sRoute.setVisible(true);
                sRoute.setImage(noteRoute);
                System.out.println("ss");
            }
            if(event.getCode() == KeyCode.D) {
                dRoute.setVisible(true);
                dRoute.setImage(noteRoute);
                System.out.println("dd");
            }
            if(event.getCode() == KeyCode.F) {
                fRoute.setVisible(true);
                fRoute.setImage(noteRoute);
                System.out.println("ff");
            }
            if(event.getCode() == KeyCode.SPACE) {
                spaceRoute.setVisible(true);
                spaceRoute.setImage(sr);
                System.out.println("sp");
            }
            if(event.getCode() == KeyCode.J) {
                jRoute.setVisible(true);
                jRoute.setImage(noteRoute);
                System.out.println("jj");
            }
            if(event.getCode() == KeyCode.K) {
                kRoute.setVisible(true);
                kRoute.setImage(noteRoute);
                System.out.println("kk");
            }
            if(event.getCode() == KeyCode.L) {
                lRoute.setVisible(true);
                lRoute.setImage(noteRoute);
                System.out.println("ll");
            }
         
        });
        scene.setOnKeyReleased((KeyEvent event)->{
            if(event.getCode() == KeyCode.S) {
                sRoute.setVisible(false);
                System.out.println("s");
            }
            if(event.getCode() == KeyCode.D) {
                dRoute.setVisible(false);
                System.out.println("d");
            }
            if(event.getCode() == KeyCode.F) {
                fRoute.setVisible(false);
                System.out.println("f");
            }
            if(event.getCode() == KeyCode.SPACE) {
                spaceRoute.setVisible(false);
                System.out.println("space");
            }
            if(event.getCode() == KeyCode.J) {
                jRoute.setVisible(false);
                System.out.println("j");
            }
            if(event.getCode() == KeyCode.K) {
                kRoute.setVisible(false);
                System.out.println("k");
            }
            if(event.getCode() == KeyCode.L) {
                lRoute.setVisible(false);
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

    public void playGameMusic() {
        if (playMusicTitle.getText().equals("Energy")) {
            gameMusic = new Music("energy.mp3", false);
            gameMusic.start();
            showComplete(10);

        } else if (playMusicTitle.getText().equals("Smile")) {
            gameMusic = new Music("smile.mp3", false);
            gameMusic.start();
            showComplete(100);
        } else if (playMusicTitle.getText().equals("Spotlight")) {
            gameMusic = new Music("Spotlight.mp3", false);
            gameMusic.start();
            showComplete(20);
        }
    }
    public void showComplete(int time) {

        Timeline timer = new Timeline(new KeyFrame(Duration.seconds(time), (ActionEvent event) -> {
            gameMusic.close();
            pane.getScene().getWindow().hide();
            Stage comStage = new Stage();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../UI/complete.fxml"));
                comStage.setScene(new Scene(root));
                comStage.setResizable(false);
                comStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();

    }

}