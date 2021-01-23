package controller;

import Game.Music;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
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
import java.io.IOException;
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


    Music introMusic = new Music("circles.mp3", true);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageViewStartBtn.setImage(startBtnImg);
        imageViewExitBtn.setImage(exitBtnImg);
        introMusic.start();


    }
    public void startBtnHandle(ActionEvent event) {
        introMusic.close();
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("../UI/MusicList.fxml"));
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(new Scene(root1));
            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void exitBtnHandle(ActionEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
        introMusic.close();

    }
}
