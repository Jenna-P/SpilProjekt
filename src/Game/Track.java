package Game;

public class Track {

    private String title;
    private String artistName;
    private String timePeriod;
    private String startMusic;  // in MusiList when its selected
    private String gameMusic;  //when game start


    public Track(String title, String artistName, String timePeriod, String startMusic, String gameMusic) {
        this.title = title;
        this.artistName = artistName;
        this.timePeriod = timePeriod;
        this.startMusic = startMusic;
        this.gameMusic = gameMusic;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    public String getStartMusic() {
        return startMusic;
    }

    public void setStartMusic(String startMusic) {
        this.startMusic = startMusic;
    }

    public String getGameMusic() {
        return gameMusic;
    }

    public void setGameMusic(String gameMusic) {
        this.gameMusic = gameMusic;
    }
}
