package controller;

import Game.Note;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
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
    Label s, d, f, space, j, k, l;
    @FXML
    public AnchorPane pane = new AnchorPane();


    public final int NOTE_SPEED = 5;
    public final int SLEEP_TIME = 50;


    //ArrayList<Note> noteList = new ArrayList<Note>();
    @FXML
    Rectangle noteS, noteD, noteF;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        noteS.setVisible(false);
        noteD.setVisible(false);
        dropNotes();
        dropNotesD();


    }


    public void setMusicInfo(String title, String s, String p) {
        playMusicTitle.setText(title);
        singer.setText(s);
        period.setText(p);

    }

    public void dropNotes() {
    Thread t1 = new Thread(new Runnable() {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);

                while (true) {
                    Platform.runLater(() -> {
                        noteS.setVisible(true);
                        noteS.setLayoutY(noteS.getLayoutY() + NOTE_SPEED);

                    });

                    Thread.sleep(SLEEP_TIME);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    });
    t1.setDaemon(true);
    t1.start();
}

    public void dropNotesD() {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(2000);

                    while (true) {
                        Platform.runLater(() -> {
                            noteD.setVisible(true);
                            noteD.setLayoutY(noteD.getLayoutY() + NOTE_SPEED);

                        });

                        Thread.sleep(SLEEP_TIME);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        t1.setDaemon(true);
        t1.start();
    }



    @FXML
    public void keyPressed() {
        pane.getScene().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
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
        noteS.setVisible(true);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        KeyValue kv = new KeyValue(noteS.yProperty(), 700);
        KeyFrame kf = new KeyFrame(Duration.millis(3000), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();

    }
*/

    public void judge() {
        pane.getScene().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if(event.getCode() == KeyCode.S && noteS.getLayoutY() >= 560 && noteS.getLayoutY() < 600) {
                System.out.println("ss");
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



}