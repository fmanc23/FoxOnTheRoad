package logic;

import view.IView;
import utilities.IUtilities;
import logic.characters.Entity;
import logic.characters.EntityGroup;
import logic.characters.Fox;
import logic.characters.Vehicle;

import java.util.LinkedList;
import java.util.ListIterator;


public class Logic implements ILogic{

    private static IView view = null;
    private static IUtilities utilities = null;

    public Logic() {}

    public Logic(IUtilities utilities, IView view) {
        setUtilities(utilities);
        setView(view);
        new Fox(150, 320, 150, 320, 50, 40, 5);
        new Map(getLevel());
        new EntityGroup();
        Statistics.setIsPaused(true);
    }

    public static void setView(IView newView) {
        view = newView;
    }

    private static void setUtilities(IUtilities newUtilities) {
        utilities = newUtilities;
    }
    
    public static IView getView() {
        return view;
    }

    public static IUtilities getUtilities() {
        return utilities;
    }

    // Statistics
    public int getLevel() {
        return Statistics.getLevel();
    }
    public int getPercentage() {
        return Statistics.getPercentage();
    }
    public int getLives() {
        return Statistics.getLives();
    }
    public int getCoins() {
        return Statistics.getCoins();
    }
    public int getPoints() {
        return Statistics.getPoints();
    }
    public int getStoricHighScore() {
        return Statistics.getStoricHighScore();
    }
    public int getPresentHighScore() {
        return Statistics.getPresentHighScore();
    }
    public boolean getIsPaused() {
        return Statistics.getIsPaused();
    }
    public void setStoricHighScore(int newScore) {
        Statistics.setStoricHighScore(newScore);
    }
    public void setLives() {
        Statistics.setLives();
    }
    public void setIsPaused(boolean newState) {
        Statistics.setIsPaused(newState);
    }
    public void setIsPausedFromKill() {
        Statistics.setIsPausedFromKill();
    }
    public void setPercentage() {
        Statistics.setPercentage();
    }
    public int getGameCols() {
        return Map.getGameCols();
    }
    public LinkedList<int[]> getEntityCoordinates() {
        return Map.getEntityCoordinates();
    }

    // Entities
    public LinkedList<String[]> getEntityListToDraw() {
        // Since View doesn't have Entity as Object, pass an array of parameters for each entity
        LinkedList<String[]> entityListToDraw = new LinkedList<String[]>();
        LinkedList<Entity> entityList = EntityGroup.getEntityList();
        ListIterator<Entity> iterator = entityList.listIterator();
        while(iterator.hasNext()) {
            Entity nextEntity = iterator.next();
            entityListToDraw.add(new String[]{nextEntity.getTextureName(), Integer.toString(nextEntity.getxAbs()),
                                Integer.toString(nextEntity.getyAbs())});
        }
        return entityListToDraw;
    }
    public void moveVehicles() {
        LinkedList<Vehicle> vehicleList = EntityGroup.getVehicleList();
        ListIterator<Vehicle> iterator = vehicleList.listIterator();
        while(iterator.hasNext()) {
            iterator.next().move();
        }
    }
    // Fox
    public int[] getFoxAbsoluteCoordinates() {
        return new int[]{Fox.getxAbs(), Fox.getyAbs()};
    }
    public int[] getFoxRelativeCoordinates() {
        return new int[]{Fox.getxVis(), Fox.getyVis()};
    }
    public int[] getFoxBoundingBox() {
        return new int[]{Fox.getxBox(), Fox.getyBox()};
    }
    public String getFoxTextureName() {
        return Fox.getTextureName();
    }
    public void moveFox() {
        Fox.moveFox();
    }

    // CollisionManager
    public void checkCollision() {
        CollisionController.checkCollision();
    }

    // KeyHandler
    public void inputPressed(int input) {
        KeyHandler.inputPressed(input);
    }
    public void inputReleased(int input) {
        KeyHandler.inputReleased(input);
    }
    
}