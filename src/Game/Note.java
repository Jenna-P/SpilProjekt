package Game;

public class Note extends Thread {

   private int x, y;
   private String noteType;
   public final int NOTE_SPEED = 5;
   public final int SLEEP_TIME = 10;
   public Note(int x, int y, String noteType){
       this.x = x;
       this.y = y;
       this.noteType = noteType;
   }

   public void drop() {
       y += NOTE_SPEED;

   }

   public void run() {
       try {
           while (true) {
               drop();
               Thread.sleep(SLEEP_TIME);
           }
       } catch (Exception e) {
           System.err.println(e.getMessage());
       }
   }
}
