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
     int gap = 125;

     public Game(String title, Music gameMusic, AnchorPane pane) {
         this.gameMusic = gameMusic;
         this.title = title;
         this.pane = pane;
         if (this.title.equals("Spotlight")) {
             int startTime = 2000;
             beats.add(new Beat(startTime, "Space"));
             beats.add(new Beat(startTime + gap * 4, "D"));
             beats.add(new Beat(startTime + gap * 6, "F"));
             beats.add(new Beat(startTime + gap * 8, "Space"));
             beats.add(new Beat(startTime + gap * 10, "J"));
             beats.add(new Beat(startTime + gap * 12, "K"));
             beats.add(new Beat(startTime + gap * 14, "L"));
             beats.add(new Beat(startTime + gap * 18, "Space"));
             beats.add(new Beat(startTime + gap * 20, "Space"));
             beats.add(new Beat(startTime + gap * 22, "Space"));
             beats.add(new Beat(startTime + gap * 24, "K"));
             beats.add(new Beat(startTime + gap * 26, "J"));
             beats.add(new Beat(startTime + gap * 28, "K"));
             beats.add(new Beat(startTime + gap * 30, "J"));
             beats.add(new Beat(startTime + gap * 32, "K"));
             beats.add(new Beat(startTime + gap * 36, "S"));
             beats.add(new Beat(startTime + gap * 38, "D"));
             beats.add(new Beat(startTime + gap * 40, "S"));
             beats.add(new Beat(startTime + gap * 42, "D"));
             beats.add(new Beat(startTime + gap * 44, "S"));
             beats.add(new Beat(startTime + gap * 46, "D"));
             beats.add(new Beat(startTime + gap * 48, "Space"));
             beats.add(new Beat(startTime + gap * 49, "J"));
             beats.add(new Beat(startTime + gap * 50, "K"));
             beats.add(new Beat(startTime + gap * 52, "L"));
             beats.add(new Beat(startTime + gap * 52, "J"));
             beats.add(new Beat(startTime + gap * 52, "J"));
         }
         if (this.title.equals("Smile")) {
             int startTime = 3000;
             beats.add(new Beat(startTime, "Space"));
             beats.add(new Beat(startTime + gap * 4, "D"));
             beats.add(new Beat(startTime + gap * 6, "F"));
             beats.add(new Beat(startTime + gap * 8, "Space"));

         }
         if (this.title.equals("Energy")) {
             int startTime = 1000;
             beats.add(new Beat(startTime, "Space"));
             beats.add(new Beat(startTime + gap * 4, "D"));
             beats.add(new Beat(startTime + gap * 6, "F"));
             beats.add(new Beat(startTime + gap * 4, "J"));

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
