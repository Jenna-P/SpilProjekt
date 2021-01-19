package Game;

import controller.PlayController;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;


public class Note extends Thread {


   public String noteType;
    public final int NOTE_SPEED = 5;
    public final int SLEEP_TIME = 10;
   public Rectangle note;
    public int x, y = 580 - (1000 / SLEEP_TIME * NOTE_SPEED) ;
    public double width = 100;

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
           width = 200;
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
       this.note = new Rectangle(this.x, this.y, width, 50);
       note.setArcHeight(5);
       note.setArcWidth(5);
       Color fill = Color.web("#46afe0e4");
       note.setFill(fill);
       Color stroke = Color.web("#4d779000");
       note.setStroke(stroke);
       note.setStrokeType(StrokeType.INSIDE);
       
   }

   public Rectangle getNote() {
       return note;
   }

    public void setNote(Rectangle note) {

       this.note = note;
    }


   public void drop() {
       note.setLayoutY(note.getLayoutY() + NOTE_SPEED);
   }

    public void run() {
        while(true) {

            Platform.runLater(() -> {
                drop();
            });

            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

   }
}
