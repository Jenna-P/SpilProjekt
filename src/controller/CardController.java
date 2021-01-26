package controller;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class CardController {
    @FXML
    Button collectBtn;
    @FXML
    ImageView iv = new ImageView();
    @FXML
    Image card70 = new Image("Image/card7.png");

    public void handleCollect() {

        System.out.println("Button");
    }

    public void popUpCard() {
        if (PlayController.period.getText().equals("70's")) {
            iv.setImage(card70);
            FadeTransition fade = new FadeTransition(Duration.seconds(1), iv);
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.play();
        }
        else if(PlayController.period.getText().equals("80's")) {
            iv.setImage(new Image("Image/card8.png"));
            FadeTransition fade = new FadeTransition(Duration.seconds(1), iv);
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.play();
        }
        else if(PlayController.period.getText().equals("90's")) {
            iv.setImage(new Image("Image/card9.png"));
            FadeTransition fade = new FadeTransition(Duration.seconds(1), iv);
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.play();
        }
    }
}
