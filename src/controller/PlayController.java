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
        // playMusicTitle(FXML text).getText 불러오질 못함. 왜?
          //if (playMusicTitle.getText().equal("Energy"))..

          //whilef문 오류 나서 for문으로 바꿔 봤는데. 노트 세개가 잘 떨어 지긴 하는데.. 시간 차 없이 한꺼번에 떨어짐 *line61
          //168째 줄 에 와일 문 써서 gameMusic.getTime 이 노래 끝나는 시간이랑 맞음 화면 변경하게끔 할려고 했는데 와일 문 동작을 먼저하고 게임 페이지가 열려요
          //저번에 말씀 하셨던 그 문제 같은데 이걸 어떻게 해결 할 수 있을 지 도저히 모르겠어요..

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
        if (playMusicTitle.getText().equals("Energy")) {              //이 메소드를 ListController playButton 메소드 안에
                                                                      // controller.playGameMusic(); (라인58) 호출하니까 getText가 나오고 노래도 정상 작동되
            gameMusic = new Music("energy.mp3", false);
            gameMusic.start();



        } else if (playMusicTitle.getText().equals("Smile")) {
            gameMusic = new Music("smile.mp3", false);
            gameMusic.start();
        } else if (playMusicTitle.getText().equals("Spotlight")) {
            gameMusic = new Music("Spotlight.mp3", false);
            gameMusic.start();
        }
    }





}