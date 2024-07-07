import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class ReadCSV {
    static Charset charset = Charset.forName("UTF-8");
    static Path filepath = Paths.get("Prova.csv");
    
    
    // Constructor
    ReadCSV() {
        //to do
    } // End of constructor

    public static void main(String[] args) {
        LinkedList<String> mapRows = new LinkedList<String>();
        char[][] mapMatrix = null;
        try {
            // Calcolo quanti elementi ha la LinkedList leggendola per intero e incrementando un contatore
            BufferedReader buffReadCheck = Files.newBufferedReader(filepath, charset);
            String s = null;

            int numRows=0;
            while((s = buffReadCheck.readLine()) != null) {
                numRows++;
            }

            buffReadCheck.close();

            // Leggo le righe e le aggiungo alla LinkedList dove le ripongo
            BufferedReader buffRead = Files.newBufferedReader(filepath, charset);
            
            for(int i=0; i<numRows; i++) {
                s = buffRead.readLine();
                mapRows.add(s);
            }
            
            mapMatrix = new char[numRows][mapRows.get(0).length()];
            for(int i=0; i<numRows; i++){
                for(int j=0; j<mapRows.get(0).length(); j++){
                    mapMatrix[i][j]= mapRows.get(i).charAt(j);
                }
            }
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }

        // Stampo la matrice per controllo
        {
            for(int i=0; i<mapMatrix.length; i++) {
                for(int j=0; j<mapMatrix[i].length; j++) {
                    System.out.print(mapMatrix[i][j] + " ");
                }
                System.out.print("\n");
            }
        }
    }

}
