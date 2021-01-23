package Game;


import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;


public class Note extends Thread {


   public String noteType;
    public final int NOTE_SPEED = 4;
    public final int SLEEP_TIME = 10;
   public Rectangle note;
    public int x, y ; // 580 - (1000 / SLEEP_TIME * NOTE_SPEED)
    public double width = 100;

    public ImageView ivJudge;



   public Note(String noteType, ImageView ivJudge) {
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
       this.ivJudge = ivJudge;
       this.note = new Rectangle(this.x, this.y, width, 50);
       note.setArcHeight(5);
       note.setArcWidth(5);
       Color fill = Color.web("#46afe0e4");
       note.setFill(fill);
       Color stroke = Color.web("#4d779000");
       note.setStroke(stroke);
       note.setStrokeType(StrokeType.INSIDE);
       
   }





    public String getNoteType() {
        return noteType;
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

    @Override
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

    public void judge() {
        Platform.runLater(() -> {
        if (note.getLayoutY()  >= 610) {
                ivJudge.setImage(new Image("Image/judgeMiss.png"));
                ivJudge.setVisible(true);
                System.out.println("miss");

        }
        else if (note.getLayoutY() >= 550 && note.getLayoutY() <= 565 ) {  //good
                ivJudge.setImage(new Image("Image/judgeGood.png"));
                ivJudge.setVisible(true);
                System.out.println("good");

        }
        else if (note.getLayoutY() >= 566 && note.getLayoutY() <= 575 ) { //great
                ivJudge.setImage(new Image("Image/judgeGreat.png"));
                ivJudge.setVisible(true);
                System.out.println("great");

        }
        else if (note.getLayoutY() >= 576 && note.getLayoutY() <= 585) { //perfect
                ivJudge.setImage(new Image("Image/judgePerfect.png"));
                ivJudge.setVisible(true);
                System.out.println("Perfect");

        }
        else if (note.getLayoutY() >= 586 && note.getLayoutY() <= 595) { //great
                ivJudge.setImage(new Image("Image/judgeGreat.png"));
                ivJudge.setVisible(true);
                System.out.println("great");

        }
        else if (note.getLayoutY() >= 596 && note.getLayoutY() <= 609) { //good
            ivJudge.setImage(new Image("Image/judgeGood.png"));
            ivJudge.setVisible(true);
            System.out.println("good");
        }
        });
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                ivJudge.setVisible(false);
            });



    }
}