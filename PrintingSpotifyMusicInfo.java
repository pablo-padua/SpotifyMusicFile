import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PrintingSpotifyMusicInfo {


    public static class Music {
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

    private static BufferedReader file;
    public static String filename = "tmp/spotifyMusicData.csv";

    static String formattedDate = "";
    static String formattedArtists = "";

    public static void formattingArray(String currentLine, boolean format) {
        //The following 'for loops' are what it took to properly format this long ass informational music string by using split().
        Music musicEntity = new Music();
        String[] formatter;
        StringBuilder buildingString = new StringBuilder();
        ArrayList<String> fullSentence = new ArrayList<>();
        //Getting the first comma values with split()
        for (String arrayDivision : currentLine.split(",\\[", 3)) {
            if (format) {
                formatter = arrayDivision.split(",");
                fullSentence.addAll(Arrays.asList(formatter));
                format = false;
            } else {
                buildingString.append(arrayDivision);
                format = true;
            }
        }
        //Getting the 'artists' strings inside the artists' array
        for (String secondArrayDivision : (buildingString.toString().split("\\[|\\],", 2))) {
            if (format) {
                formatter = secondArrayDivision.split(",");
                fullSentence.addAll(Collections.singleton(Arrays.toString(formatter)));
                format = false;
            } else {
                buildingString.setLength(0);
                buildingString.append(secondArrayDivision);
            }
        }
        format = true;
        for (String thirdArrayDivision : (buildingString.toString().split(",\"\\["))) {
            if (format) {
                formatter = thirdArrayDivision.split(",");
                fullSentence.addAll(Arrays.asList(formatter));
                format = false;
            } else {
                buildingString.setLength(0);
                buildingString.append(thirdArrayDivision);
            }
        }
        format = true;
        for (String fourthArrayDivision : (buildingString.toString().split("\\]\","))) {
            if (format) {
                formatter = fourthArrayDivision.split("\\]\",");
                fullSentence.addAll(Arrays.asList(formatter));
                format = false;
            } else {
                buildingString.setLength(0);
                buildingString.append(fourthArrayDivision);
            }
        }
        for (String lastArrayDivision : (buildingString.toString().split(","))) {
            buildingString.setLength(0);
            fullSentence.addAll(Collections.singletonList(lastArrayDivision));
        }

        // Setting the values to the Music Entity by using the elements' order that is shown in the csv file
        int indexOfValues = 0;
        musicEntity.setValence(Double.parseDouble(fullSentence.get(indexOfValues++)));
        musicEntity.setYear(Integer.parseInt(fullSentence.get(indexOfValues++)));
        musicEntity.setAcousticness(Double.parseDouble(fullSentence.get(indexOfValues++)));

        // Formatting artists list
        String artistas = fullSentence.get(indexOfValues++);
        artistas = artistas.replace("'", "");
        formattedArtists = artistas;
        artistas = artistas.replace("[", "");
        artistas = artistas.replace("]", "");
        musicEntity.setArtists(artistas.split(", "));

        musicEntity.setDanceability(Double.parseDouble(fullSentence.get(indexOfValues++)));
        musicEntity.setDuration_ms(Integer.parseInt(fullSentence.get(indexOfValues++)));
        musicEntity.setEnergy(Double.parseDouble(fullSentence.get(indexOfValues++)));
        musicEntity.setExplicit(Double.parseDouble(fullSentence.get(indexOfValues++)));
        musicEntity.setId(fullSentence.get(indexOfValues++));
        musicEntity.setInstrumentalness(Double.parseDouble(fullSentence.get(indexOfValues++)));
        musicEntity.setKey(fullSentence.get(indexOfValues++));
        musicEntity.setLiveness(Double.parseDouble(fullSentence.get(indexOfValues++)));
        musicEntity.setLoudness(Double.parseDouble(fullSentence.get(indexOfValues++)));
        musicEntity.setMode(Double.parseDouble(fullSentence.get(indexOfValues++)));
        musicEntity.setName(fullSentence.get(indexOfValues++));
        musicEntity.setPopularity(Integer.parseInt(fullSentence.get(indexOfValues++)));

        // Formatting Date, format should be "Double Digits Day / Double Digits Month / Four Digits Year" a.k.a "dd/mm/yyyy"
        if (fullSentence.get(16).length() <= 4) { // If date output is 'year' only, then add Jan 1st as official release date
            formattedDate = fullSentence.get(16) + "-01-01";
            LocalDate date = LocalDate.parse(formattedDate);
            formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            formattedDate = formattedDate.replace("-", "/");
            musicEntity.setRelease_date(date);
        } else if (fullSentence.get(16).length() > 4 && fullSentence.get(16).length() <= 7) {
            formattedDate = fullSentence.get(16);
            formattedDate = formattedDate + "-01"; // If date output is 'year' and 'month' only, then add '01' as Day.
            LocalDate date = LocalDate.parse(formattedDate);
            formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            formattedDate = formattedDate.replace("-", "/");
            musicEntity.setRelease_date(date);
        } else { // If date is complete, just format it
            formattedDate = fullSentence.get(16);
            LocalDate date = LocalDate.parse(formattedDate);
            formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            formattedDate = formattedDate.replace("-", "/");
            musicEntity.setRelease_date(date);
        }
        indexOfValues++;
        musicEntity.setSpeechiness(Double.parseDouble(fullSentence.get(indexOfValues++)));
        musicEntity.setTime(Double.parseDouble(fullSentence.get(indexOfValues)));
        printingValues(musicEntity);
    }

    public static void printingValues(Music MusicEntity) {
        System.out.printf("%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s%n",
                MusicEntity.getId(), formattedArtists,
                formattedDate, MusicEntity.getAcousticness(),
                MusicEntity.getDanceability(), MusicEntity.getInstrumentalness(),
                MusicEntity.getLiveness(), MusicEntity.getLoudness(),
                MusicEntity.getSpeechiness(), MusicEntity.getEnergy(),
                MusicEntity.getDuration_ms());
    }

    public static void openFile() {
        try {
            file = new BufferedReader(new FileReader(filename));
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }

    public static void readFile(boolean firstLine) {
        String fileCurrentLine;
        try {
            while ((fileCurrentLine = file.readLine()) != null && !firstLine) {
                formattingArray(fileCurrentLine, true);
            }
        } catch (Exception e) {
            System.out.printf("Error while trying to read file: %s\n", e);
        }
    }

    public static void closeFile() {
        try {
            file.close();
        } catch (Exception e) {
            System.out.printf("Error while closing the file: %s", e);
        }
    }

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        try {
            openFile();
            readFile(true);
            readFile(false);
            closeFile();
        } catch (Exception e) {
            System.out.printf("Error while opening the file: %s", e);
        }
    }
}

