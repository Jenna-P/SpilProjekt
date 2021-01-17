package Game;

import controller.PlayController;
import javafx.application.Platform;
import javafx.scene.shape.Rectangle;

import javax.swing.text.html.ImageView;

public class Note {


   public String noteType;
    public final int NOTE_SPEED = 5;
    public final int SLEEP_TIME = 10;
   public Rectangle note;
    public int x, y = 580 - (1000 / SLEEP_TIME * NOTE_SPEED);

   public Note(String noteType) {
       if (noteType.equals("S")) {
           x = 250;
       }
       else if (noteType.equals("D")) {
           x = 350;
       }
       else if (noteType.equals("F")) {
           x = 450;
       }
       else if (noteType.equals("Space")) {
           x = 550;
       }
       else if (noteType.equals("J")) {
           x = 750;
       }
       else if (noteType.equals("K")) {
           x = 850;
       }
       else if (noteType.equals("L")) {
           x = 950;
       }
       this.noteType = noteType; //reset note type
   }


   public void drawNotes() {
       note.setLayoutY(y);
       note.setLayoutX(x);
       note.setVisible(true);

   }


   public void run() {

   }
}
