package logic;

import logic.characters.Fox;
import logic.characters.EntityGroup;
import java.io.File;

public class Statistics {
    // Constants
    private static final int NUMBEROFLEVELS = new File(Logic.getUtilities().getLevelMapFolder()).listFiles().length;

    // Private Variables
    private static int level = 0;
    private static int levelPercentage = 0;
    private static int lives = 3;
    private static int coins = 0;
    private static int points = 0;
    private static int bonus = 0;
    private static int storicHighScore = 0;
    private static int presentHighScore = 0;
    private static boolean isPaused = false;

    // Get Methods - Public
    protected static int getLevel() {
        return level;
    }
    protected static int getPercentage() {
        return levelPercentage;
    }
    protected static int getLives() {
        return lives;
    }
    protected static int getCoins() {
        return coins;
    }
    protected static boolean getIsPaused() {
        return isPaused;
    }
    protected static int getPoints() {
        return points + bonus;
    }
    protected static int getStoricHighScore() {
        return storicHighScore;
    }
    protected static int getPresentHighScore() {
        return presentHighScore;
    }

    // Set Methods
    protected static void setPercentage() {
        if(levelPercentage < 100){
            levelPercentage = (int)((double)(Fox.getxAbs()) / (double)((Map.getGameCols())*64)*100);
            points = getLevel() * levelPercentage;
        }
        else if (getPercentage() == 100) {
            setLevel(getLevel() + 1);
            levelPercentage = 0;
        }
    }

    protected static void setCoins() {
        coins++;
        bonus += 200;
        if(coins >= 10) {
            lives++;
            coins = 0;
            bonus += 200;
        }
    }

    protected static void setIsPaused(boolean newState) {
        isPaused = newState;
        if(isPaused) {
            Logic.getView().stopTimer();
            Fox.stopFox();
        } else {
            Logic.getView().startTimer();
        }
    }

    protected static void setIsPausedFromKill() {
        isPaused = true;
        Logic.getView().stopTimer();
    }

    protected static void setLives() {
        lives--;
        if(lives == 0) {
            if(presentHighScore < getPoints()){
                presentHighScore = getPoints();
            }
            setLevel(1);
            lives = 3;
            coins = 0;
            points = 0;
            bonus = 0;
        } else {
            bonus -= 200;
            Logic.getView().resetTimer();
            setLevel(getLevel());
        }
    }

    protected static void setLevel(int newLevel) {
        setIsPaused(true);

        if(newLevel > level) {
            points += level * 100;
        }

        if(newLevel + 1 <= NUMBEROFLEVELS) {
            level = newLevel;
            Logic.getView().resetTimer();
            Fox.setxAbs(150);
            Fox.setyAbs(320);
            Fox.setxVis(150);
            Fox.setyVis(320);
            Map.setLevel(level);
            EntityGroup.updateList();
            CollisionController.updateList();
        } else {
            bonus += 2000;
            presentHighScore = points;
            Logic.getView().winPanel();
            Logic.getView().saveHS();
        }
        
        setIsPaused(false);
    }

    protected static void setStoricHighScore(int newScore) {
        storicHighScore = newScore;
    }
    
    
}