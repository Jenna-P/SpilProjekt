package controller;

import Game.Music;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import Game.Main;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javazoom.jl.player.Player;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Button startBtn, exitBtn;

    @FXML
    ImageView imageViewStartBtn = new ImageView();
    @FXML
    ImageView imageViewExitBtn = new ImageView();


    @FXML
    Image startBtnImg = new Image("Image/StartBtn.png");
    @FXML
    Image exitBtnImg = new Image("Image/exitBtn.png");

   // Media intro;
    //MediaPlayer mediaPlayer ;

    Music introMusic = new Music("circles.mp3", true);



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Users/jennapetersen/IdeaProjects/SpilProjekt/src/Audio/finish.wav
        //String path = new File("/Users/jennapetersen/IdeaProjects/SpilProjekt/src/Audio/finish.wav").getAbsolutePath();
        //intro = new Media("//Users//jennapetersen//IdeaProjects//SpilProjekt//src//Audio//finish.wav");
        //Media intro = new Media(path);
        //mediaPlayer = new MediaPlayer(intro);
        //mediaPlayer.setAutoPlay(true);
        //File f = new File("src/Audio/finish.wav");
        //Media m = new Media(f.toURI().toString());
        //MediaPlayer mp = new MediaPlayer(m);
        //MediaView mv = new MediaView(mp);
        imageViewStartBtn.setImage(startBtnImg);
        imageViewExitBtn.setImage(exitBtnImg);
        introMusic.start();


    }
    public void startBtnHandle(ActionEvent event) {
        introMusic.close();
        Main main = new Main();
        main.openListPage(event);
    }

    public void exitBtnHandle(ActionEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
        introMusic.close();

    }
}
