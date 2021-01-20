package Game;

import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Game extends Thread {

     ArrayList<Note> noteList = new ArrayList<Note>();
     ArrayList<Beat> beats = new ArrayList<Beat>();

     AnchorPane pane;
     String title;
     public Music gameMusic;

     public Game(String title, Music gameMusic, AnchorPane pane) {
         this.gameMusic = gameMusic;
         this.title = title;
         this.pane = pane;
         if(this.title.equals("Energy")) {
             beats.add(new Beat(1000, "Space"));
             beats.add(new Beat(3000, "S"));
             beats.add(new Beat(5000, "D"));
         }

     }

    @Override
    public void run() {
        int i = 0;
        while(beats.size()!=i) {
            if(beats.get(i).getTime() <= gameMusic.getTime()) {
                Note note = new Note(beats.get(i).getNoteName());
                Platform.runLater(() -> {
                    pane.getChildren().add(note.getNote());
                });
                note.start();
                noteList.add(note);
                i++;
            }
        }
    }





}
