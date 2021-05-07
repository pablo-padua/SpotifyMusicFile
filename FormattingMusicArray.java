import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FormattingMusicArray extends PrintingMusicData {

    public static void readFileLine(String currentLine, boolean format) throws ParseException {
        // The following 'for loops' are what it took to properly format this long ass informational music string by using split().
        Music musicEntity = new Music();
        String[] formatter;
        StringBuilder buildingString = new StringBuilder();
        ArrayList<String> fullSentence = new ArrayList<>();
        // Getting the first values by splitting values separated by a comma
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
        // Getting the artists' names that inside the artists' array
        for (String secondArrayDivision : (buildingString.toString().split("\\[", 1))) {
            formatter = secondArrayDivision.split("'],", 2);
            buildingString.delete(0, buildingString.length());
            buildingString.append(formatter[1]);
            formatter = formatter[0].split(",");
            fullSentence.addAll(Collections.singleton(Arrays.toString(formatter)));
        }
        // We got the artists array as we wanted to, continuing our Object formatting
        for (String thirdArrayDivision : (buildingString.toString().split(",\"\\["))) { //Formatting from the end of the artists array till the beginning of the music name array
            if (format) {
                formatter = thirdArrayDivision.split(",");
                fullSentence.addAll(Arrays.asList(formatter));
                format = false;
            } else {
                // Got the music name array, time to format it
                formatter = thirdArrayDivision.split("]\",");
                fullSentence.add(formatter[0]);
                // The rest of the line are just divided by a comma, split() and add everything to the ArrayList<String> fullSentence.
                buildingString.delete(0, buildingString.length());
                fullSentence.addAll(Arrays.asList(formatter[1].split(",")));
                format = true;
            }
        }

        // Setting the values to the Music Entity by using the elements' order that is shown in the csv file
        int indexOfValues = 0;
        musicEntity.setValence(Double.parseDouble(fullSentence.get(indexOfValues++)));
        musicEntity.setYear(Integer.parseInt(fullSentence.get(indexOfValues++)));
        musicEntity.setAcousticness(Double.parseDouble(fullSentence.get(indexOfValues++)));

        // Formatting artists list
        String artistas = fullSentence.get(indexOfValues++);
        artistas = artistas.replace("'", "");
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

        //Formatting Song Name
        String formattingSongName = fullSentence.get(indexOfValues++).replace("[", "");
        formattingSongName = formattingSongName.replace("]", "");
        musicEntity.setName(formattingSongName);
        musicEntity.setPopularity(Integer.parseInt(fullSentence.get(indexOfValues++)));
        if (fullSentence.get(16).length() <= 4) { // If date output is 'year' only, then add Jan 1st as official release date
            LocalDate date = LocalDate.parse(fullSentence.get(16) + "-01-01");
            musicEntity.setRelease_date(date);
        } else if (fullSentence.get(16).length() > 4 && fullSentence.get(16).length() <= 7) { // If day is missing, then add 01 as official day
            LocalDate date = LocalDate.parse(fullSentence.get(16) + "-01");
            musicEntity.setRelease_date(date);
        } else { // If date is complete, just format it
            LocalDate date = LocalDate.parse(fullSentence.get(16));
            musicEntity.setRelease_date(date);
        }
        indexOfValues++;
        musicEntity.setSpeechiness(Double.parseDouble(fullSentence.get(indexOfValues++)));
        musicEntity.setTime(Double.parseDouble(fullSentence.get(indexOfValues)));
        printingValues(musicEntity);
    }

    public static void printingValues(Music MusicEntity) {
        System.out.printf("%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s%n",
                // Formatting artists list so it prints without brackets
                formattedArtists = Arrays.toString(music.getArtists()).replace("[", "");
                formattedArtists = formattedArtists.replace("]", "");
                // Formatting Date, format should be "Double Digits Day / Double Digits Month / Four Digits Year" a.k.a "dd/mm/yyyy"
                formattedDate = music.getRelease_date().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                formattedDate = formattedDate.replace("-", "/");
                MusicEntity.getId(), formattedArtists, MusicEntity.getName(),
                formattedDate, MusicEntity.getAcousticness(),
                MusicEntity.getDanceability(), MusicEntity.getInstrumentalness(),
                MusicEntity.getLiveness(), MusicEntity.getLoudness(),
                MusicEntity.getSpeechiness(), MusicEntity.getEnergy(),
                MusicEntity.getDuration_ms());
    }

}
