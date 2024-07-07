package logic;

import java.util.LinkedList;

public interface ILogic {

    // Statistics
    public int getLevel();    
    public int getPercentage();
    public int getLives();
    public int getCoins();
    public int getPoints();
    public int getStoricHighScore();
    public int getPresentHighScore();
    public boolean getIsPaused();
    public void setLives();
    public void setIsPaused(boolean newState);
    public void setStoricHighScore(int newScore);

    // Entities
    public LinkedList<String[]> getEntityListToDraw();
    public void moveVehicles();
    // Fox
    public int[] getFoxAbsoluteCoordinates();
    public int[] getFoxRelativeCoordinates();
    public int[] getFoxBoundingBox();
    public String getFoxTextureName();
    public void moveFox();

    // CollisionManager
    public void checkCollision();

    // KeyHandler
    public void inputPressed(int input);
    public void inputReleased(int input);

}
