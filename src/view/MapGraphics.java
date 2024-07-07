package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.Random;

public class MapGraphics {

    private static BufferedImage mapBufferedImage = null;

    protected static void generateMapImage(char[][] mapMatrix) {
        try {
            // Creating the imgMatrix
            BufferedImage[][] imgMatrix = new BufferedImage[mapMatrix.length][mapMatrix[0].length]; 

            // Checking the matrix
            for(int i=0; i<mapMatrix.length;i++) {
                for(int j=0; j<mapMatrix[i].length; j++) {

                    char tileType = mapMatrix[i][j];
                    String texture = null;

                    // For each type of tile try to load the respective type
                    
                    // G -> Grass (g, r, t tiles are accepted)
                    if(tileType == 'g' || tileType == 'r' || tileType == 't' || tileType == 'c') {
                        // Randomizer which chooses the Grass Block
                        int val = new Random(System.currentTimeMillis()).nextInt(3) + 1;
                        // Choosing one of the available Grass textures
                        texture = "GrassTexture" + val + ".png";
                        imgMatrix[i][j] = ImageIO.read(new File(View.getUtilities().getTexturesLocation(texture)));
                    }
                    // A -> Road Left
                    else if (tileType == 'a'){
                        texture = "RoadTextureSX.png";
                        imgMatrix[i][j] = ImageIO.read(new File(View.getUtilities().getTexturesLocation(texture)));
                    }
                    // S -> Road Right
                    else if (tileType == 's'){
                        texture = "RoadTextureDX.png";
                        imgMatrix[i][j] = ImageIO.read(new File(View.getUtilities().getTexturesLocation(texture)));
                    }
                    // F -> Finish
                    else if (tileType == 'f'){
                        texture = "FinishTexture.png";
                        imgMatrix[i][j] = ImageIO.read(new File(View.getUtilities().getTexturesLocation(texture)));
                    }
                    // Everything Else -> Debug Texture
                    else {
                        texture = "TestTexture.png";
                        imgMatrix[i][j] = ImageIO.read(new File(View.getUtilities().getTexturesLocation(texture)));
                    }
                }
            } // At this point we have the Matrix of BufferedImages, it only has to be merged into only one BufferedImage

            // Calculating width and height of the image I'm going to generate
            int width = imgMatrix[0][0].getWidth() * imgMatrix[0].length;
            int height = imgMatrix[0][0].getHeight() * imgMatrix.length;

            // Creating the map image
            mapBufferedImage = new BufferedImage(width, height, imgMatrix[0][0].getType());
            Graphics2D g2d = mapBufferedImage.createGraphics();
            for(int i=0; i<imgMatrix.length; i++) {
                for(int j=0; j<imgMatrix[0].length; j++) {
                    g2d.drawImage(imgMatrix[i][j], j*imgMatrix[i][j].getWidth(), i*imgMatrix[i][j].getHeight(), null);
                }
            }

        }
        catch(IOException ioe) {
            JOptionPane.showMessageDialog(null, "Errore nel caricamento delle tile della Mappa",
                                        "Attenzione", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

    }
  
    // Get the Map (BufferedImage)
    protected static BufferedImage getMapImage() {
        return mapBufferedImage;
    }

    // Clear the map
    protected static void clearMapImage() {
        mapBufferedImage = null;
    }

}