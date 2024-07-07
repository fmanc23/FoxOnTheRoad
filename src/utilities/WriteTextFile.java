package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class WriteTextFile {

    private static final String ATT = "Attenzione";

	protected static void writeHighScores(String name) {

        BufferedWriter writer = null;
        try{
            // Creating a file object
            File hsFile = new File(new Assets().getHighScoresFile());
            // Using a BufferedReader to append text to file
            writer = new BufferedWriter(new FileWriter(hsFile, true));
            writer.append("\n" + name + "," + Utilities.getLogic().getPoints() +";");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nell'apertura del file HighScores",
                                        ATT, JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch(IOException ioe) {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nella scrittura del file HighScores",
                                        ATT, JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            try {
                writer.close();
            } catch (NullPointerException npe) {
                npe.printStackTrace();
                JOptionPane.showMessageDialog(null, "Errore nella chiusura del BufferedWriter - oggetto nullo",
                                        ATT, JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            } catch(IOException ioe) {
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null, "Errore nella chiusura del BufferedWriter - IOException",
                                        ATT, JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }
    }
}