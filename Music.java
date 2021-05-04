import java.time.LocalDate;

public class Music {
    // Idk if I can use Lombok @Getter and @Setter here
    // Because those are a dependency and idk if 'Verde' system supports it.
    // Lets do the manual boring stuff
    // Don't ask me why 'id' is a String either lol
    private String id;
    private String name;
    private String key;
    private String[] artists;
    private LocalDate release_date;
    private double acousticness;
    private double danceability;
    private double energy;
    private int duration_ms;
    private double instrumentalness;
    private double valence;
    private int popularity;
    private double time;
    private double liveness;
    private double loudness;
    private double speechiness;
    private int year;
    private double explicit;
    private double mode;

    //Constructors, gotta have 2 as default
    public Music(String id, String name, String key, String[] artists, LocalDate release_date,
                 double acousticness, double danceability, double energy, int duration_ms,
                 double instrumentalness, double valence, int popularity, double time,
                 double liveness, double loudness, double speechiness, int year, double explicit, double mode) {
        this.id = id;
        this.name = name;
        this.key = key;
        this.artists = artists;
        this.release_date = release_date;
        this.acousticness = acousticness;
        this.danceability = danceability;
        this.energy = energy;
        this.duration_ms = duration_ms;
        this.instrumentalness = instrumentalness;
        this.valence = valence;
        this.popularity = popularity;
        this.time = time;
        this.liveness = liveness;
        this.loudness = loudness;
        this.speechiness = speechiness;
        this.year = year;
        this.explicit = explicit;
        this.mode = mode;
    }

    Music() {
    }

    //Manual getters (seriously ? XD)
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public String[] getArtists() {
        return artists;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public double getAcousticness() {
        return acousticness;
    }

    public double getDanceability() {
        return danceability;
    }

    public double getEnergy() {
        return energy;
    }

    public int getDuration_ms() {
        return duration_ms;
    }

    public double getInstrumentalness() {
        return instrumentalness;
    }

    public double getValence() {
        return valence;
    }

    public int getPopularity() {
        return popularity;
    }

    public double getTime() {
        return time;
    }

    public double getLiveness() {
        return liveness;
    }

    public double getLoudness() {
        return loudness;
    }

    public double getSpeechiness() {
        return speechiness;
    }

    public int getYear() {
        return year;
    }

    public double getExplicit() {
        return explicit;
    }

    public double getMode() {
        return mode;
    }

    //Manual Setters (boring af Ik)
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setArtists(String[] artists) {
        this.artists = artists;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public void setAcousticness(double acousticness) {
        this.acousticness = acousticness;
    }

    public void setDanceability(double danceability) {
        this.danceability = danceability;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public void setDuration_ms(int duration_ms) {
        this.duration_ms = duration_ms;
    }

    public void setInstrumentalness(double instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public void setValence(double valence) {
        this.valence = valence;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setLiveness(double liveness) {
        this.liveness = liveness;
    }

    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }

    public void setSpeechiness(double speechiness) {
        this.speechiness = speechiness;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setExplicit(double explicit) {
        this.explicit = explicit;
    }

    public void setMode(double mode) {
        this.mode = mode;
    }

    public Music clone(Music music) throws CloneNotSupportedException {
        return (Music) music.clone();
    }
}