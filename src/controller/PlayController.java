package controller;

import Game.Beat;
import Game.Music;
import Game.Note;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

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

    public Music gameMusic;

    ArrayList<Note> noteList = new ArrayList<Note>();
    ArrayList<Beat> beats = new ArrayList<Beat>();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // Note note1 = new Note("S");
      //  noteList.add(note1);
        dropNotes();

        for (int j = 0; j < noteList.size(); j++) {
            Note note = noteList.get(j);
            pane.getChildren().add(note.getNote());
            //note.start();
        }
       }
      public void dropNotes() {
        // playMusicTitle(FXML text).getText 불러오질 못함.
               
                    beats.add(new Beat(1000, "Space"));
                    beats.add(new Beat(3000, "S"));
                    beats.add(new Beat(5000, "D"));

              for (int m = 0; m < beats.size(); m++) {
                  if (beats.get(m).getTime() <= 170000) {  //대략 노래 끝나는 시간
                      Note note = new Note(beats.get(m).getNoteName());
                      note.start();
                      noteList.add(note);

                  }
              }


}

    public void setMusicInfo(String title, String s, String p) {
        playMusicTitle.setText(title);
        singer.setText(s);
        period.setText(p);

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
            System.out.println(playMusicTitle.getText());

        } else if (playMusicTitle.getText().equals("Smile")) {
            gameMusic = new Music("smile.mp3", false);
            gameMusic.start();
        } else if (playMusicTitle.getText().equals("Spotlight")) {
            gameMusic = new Music("Spotlight.mp3", false);
            gameMusic.start();
        }
    }





}