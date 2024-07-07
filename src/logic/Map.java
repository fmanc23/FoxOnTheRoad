package logic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Map {

    private static char[][] mapMatrix = null;

    // Constructor
    public Map(int level) {
        // Getting the Map Matrix
        setLevel(level);
    }

    protected static void generateMapMatrix(char[][] mapMatrixReference){
        // Copying the referenced into the effective one
        mapMatrix = Arrays.copyOf(mapMatrixReference, mapMatrixReference.length);
    }

    // Getting the coordinates of the obstacles
    protected static LinkedList<int[]> getEntityCoordinates() {
        LinkedList<int[]> entityCoordinates = new LinkedList<int[]>();
        for(int i=0; i< mapMatrix.length; i++){
            for(int j=0; j< mapMatrix[i].length; j++){
                if(mapMatrix[i][j] == 'r' || mapMatrix[i][j] == 't' || mapMatrix[i][j] == 'c' || mapMatrix[i][j] == 'a' || mapMatrix[i][j] == 's') {
                    // Rocks -> 0
                    if(mapMatrix[i][j] == 'r') {
                        entityCoordinates.add(new int[] {0, j, i});
                    }
                    // Trees -> 1
                    else if(mapMatrix[i][j] == 't') {
                        //-1 because the paint method draws from the upper-left corner
                        entityCoordinates.add(new int[] {1, j, i - 1});
                    }
                    // Coin -> 2
                    else if(mapMatrix[i][j] == 'c') {
                        entityCoordinates.add(new int[] {2, j, i});
                    }
                    // Vehicle down -> 3
                    else if(mapMatrix[i][j] == 'a') {
                        if(i == 1) {
                            for(int k=0; k <= 2 + new Random(System.currentTimeMillis()).nextInt(1); k++) {
                                entityCoordinates.add(new int[] {3, j, i});
                            }
                        }
                    }
                    // Vehicle up -> 4
                    else if(mapMatrix[i][j] == 's') {
                        if(i == 1) {
                            for(int k=0; k <= 2 + new Random(System.currentTimeMillis()).nextInt(1); k++) {
                                entityCoordinates.add(new int[] {4, j, i});
                            }
                        }
                    }
                }
            }
        }
        return entityCoordinates;
    }

    // Getting how many coloumns the map has
    protected static int getCols() {
        return mapMatrix.length;
    }

    // Getting how many playable coloumns the map has
    protected static int getGameCols() {
        return (mapMatrix[0].length - 18);
    }

    // Get the MapMatrix (Char)
    protected static char[][] getMapMatrix() {
        return mapMatrix;
    }

    // Set Level - changes the map
    protected static void setLevel(int newLevel) {
        mapMatrix = null;
        Logic.getView().clearMap();
        char[][] mapMatrixReference = Logic.getUtilities().readMap(newLevel);
        generateMapMatrix(mapMatrixReference);
        // Generating the map
        Logic.getView().generateMapImage(mapMatrix);
    }

}