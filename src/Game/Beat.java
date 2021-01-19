package Game;

public class Beat {
    private int time;
    private String noteName;

    public Beat(int time, String noteName) {
        super(); // 왜 이걸 여기에??
        this.time = time;
        this.noteName = noteName;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }
}
