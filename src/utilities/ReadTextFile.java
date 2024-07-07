package utilities;

// Import Section
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JOptionPane;

public class ReadTextFile {

    private static final String ATT = "Attenzione";

    /*
     * High Scores
     */
    protected static List<String> readHighScores(){
        // Getting the path of the level file
        Path hsPath = Paths.get(new Assets().getHighScoresFile());

        // Creating the String List
        List<String> hsLines = null;

        // Trying to read the file
        try {
            hsLines = Files.readAllLines(hsPath);
        }
        // Catching the exceptions
        catch(IOException ioe) {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nella scrittura del file HighScores",
                                        ATT, JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        // Returning lines
        return hsLines;
    }

    /*
     * Map
     */
    protected static char[][] readMap(int level) {
        // Generating the Matrix to return
        char[][] mapMatrix = null;

        try {
            // Getting the path of the level file
            Path levelPath = Paths.get(new Assets().getLevelMapLocation(level));

            // Creating the List 
            List<String> mapLines = null;

            // Reading the file
            mapLines = Files.readAllLines(levelPath);

            // Reading one line to check how long the Matrix can be
            mapMatrix = new char[mapLines.size()][mapLines.get(0).length()];
            // Putting each character in the matrix
            ListIterator<String> iterator = mapLines.listIterator();
            // Counter
            int i=0;
            while(iterator.hasNext()){
                String line = iterator.next();
                for(int j=0; j < line.length(); j++){
                    mapMatrix[i][j] = line.charAt(j);
                }
                i++;
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel caricamento del file della mappa", "Attenzione!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        
        return mapMatrix;
    }
}