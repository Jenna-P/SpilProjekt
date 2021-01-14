package controller;

import Game.Note;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlayController implements Initializable {

    @FXML
    Text playMusicTitle, singer;
    @FXML
    Label period;
    @FXML
    Label s, d, f, space, j, k,l;
    @FXML
    public AnchorPane pane = new AnchorPane();

   /*    @FXML
    ImageView imageViewNote = new ImageView();
    @FXML
    ImageView imageViewNoteSpace = new ImageView();


    @FXML
    Image note = new Image("Image/sdf.png");
    @FXML
    Image noteSpace = new Image("Image/space.png");
*/
 //   ArrayList<Note> noteList = new ArrayList<Note>();
   @FXML
    Rectangle noteS, noteD, noteF;


    public void setMusicInfo(String title, String s, String p) {
         playMusicTitle.setText(title);
         singer.setText(s);
         period.setText(p);

    }

    @FXML
    public void keyPressed() {
        pane.getScene().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if(event.getCode() == KeyCode.S) {
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

   }
    public void keyReleased() {
        pane.getScene().addEventFilter(KeyEvent.KEY_RELEASED, event -> {
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

    }

/*
    public void setNote() {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        KeyValue kv = new KeyValue(noteS.yProperty(), 580);
        KeyFrame kf = new KeyFrame(Duration.millis(3000), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();


    }

*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}