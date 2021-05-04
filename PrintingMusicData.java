import java.io.BufferedReader;
import java.io.FileReader;

public class PrintingMusicData extends Music {

    private static BufferedReader file;
    public static String filename = "/home/fabrica-bh/Downloads/dataAEDs.csv"; // Add your .csv file path

    static String formattedDate = "";
    static String formattedArtists = "";

    public static void openFile() {
        try {
            file = new BufferedReader(new FileReader(filename));
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }

    public static void readFile(boolean firstLine) {
        String fileLine;
        try {
            while ((fileLine = file.readLine()) != null && !firstLine) {
                FormattingMusicArray.readFileLine(fileLine, true);
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
            System.out.printf("An error occurred: %s", e);
        }
    }
}


