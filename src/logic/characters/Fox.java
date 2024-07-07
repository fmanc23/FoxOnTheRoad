package logic.characters;

import logic.Logic;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Rectangle;

public class Fox {
    
    // Constants
    private static final String STAYTEXTURE= "FoxStayTexture.gif";
    private static final String FORWARDTEXTURE= "FoxMoveForwardTexture.gif";
    private static final String BACKTEXTURE= "FoxMoveBackwardTexture.gif";
    private static final String KILLTEXTURE= "FoxDeathTexture.gif";
    
    // Static Variables
    private static Logic logic = new Logic();
    private static int[][] coordinates = new int[2][2];
    private static int[] boundingBox = new int[2];
    private static String textureName = STAYTEXTURE;
    private static int speed = 1;
    private static boolean up = false;
    private static boolean down = false;
    private static boolean right = false;
    private static boolean left = false;
    private static Timer resetTimer = new Timer(1040, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            resetTimer.stop();
            logic.setLives();
            logic.setIsPaused(false);
        }
    });

    public Fox(int xAbs, int yAbs, int xVis, int yVis, int xBox, int yBox, int newSpeed) {
        coordinates[0][0] = xAbs;
        coordinates[0][1] = yAbs;
        coordinates[1][0] = xVis;
        coordinates[1][1] = yVis;
        boundingBox[0] = xBox;
        boundingBox[1] = yBox;
        speed = newSpeed;
    }

    // Moving the fox
    public static void moveFox(){
        if(up){
            moveUp();
        }
        if(down){
            moveDown();
        }
        if(right){
            moveRight();
        }
        if(left){
            moveLeft();
        }
        if(!up && !down && !right && !left) {
            setTextureName(STAYTEXTURE);
        }
    }

    private static void moveUp() {
        if(getyVis() > 0) {
            setyAbs(getyAbs() - getSpeed());
            setyVis(getyVis() - getSpeed());
            // Changing the texture
            if(right) {
                setTextureName(FORWARDTEXTURE);
            } else if(left) {
                setTextureName(BACKTEXTURE);
            }
        }
    }
    private static void moveDown() {
        if(getyVis() < 640-32) {
            setyAbs(getyAbs() + getSpeed());
            setyVis(getyVis() + getSpeed());
            // Changing the texture
            if(right) {
                setTextureName(FORWARDTEXTURE);
            } else if(left) {
                setTextureName(BACKTEXTURE);
            }
        }
    }
    private static void moveRight() {
        if(getxAbs() < ((logic.getGameCols()) * 64)) {
            if(getxVis() >= 300) {
                setxAbs(getxAbs() + getSpeed());
            }
            else {
                setxAbs(getxAbs() + getSpeed());
                setxVis(getxVis() + getSpeed());
            }
        }
        setTextureName(FORWARDTEXTURE);
        logic.setPercentage();
    }

    private static void moveLeft() {
        if (getxAbs() > 200) {
            if (getxVis() <= 100) {
                setxAbs(getxAbs() - getSpeed());
            } else {
                setxAbs(getxAbs() - getSpeed());
                setxVis(getxVis() - getSpeed());
            }
        }
        setTextureName(BACKTEXTURE);
        logic.setPercentage();
    }

    public static void stopFox() {
        setTextureName(STAYTEXTURE);
    }

    public static void killFox() {
        setTextureName(KILLTEXTURE);
        resetTimer.start();
        logic.setIsPausedFromKill();
    }
    
    // Get and set methods
    public static int getxAbs() {
        return coordinates[0][0];
    }
    public static int getyAbs() {
        return coordinates[0][1];
    }
    public static int getxVis() {
        return coordinates[1][0];
    }
    public static int getyVis() {
        return coordinates[1][1];
    }
    public static int getxBox() {
        return boundingBox[0];
    }
    public static int getyBox() {
        return boundingBox[1];
    }
    public static int getSpeed() {
        return speed;
    }
    public static String getTextureName() {
        return textureName;
    }
    public static boolean getUp() {
        return up;
    }
    public static boolean getDown() {
        return down;
    }
    public static boolean getRight() {
        return right;
    }
    public static boolean getLeft() {
        return left;
    }
    public static Rectangle getBoundingBox() {
        return new Rectangle(getxAbs() + 5, getyAbs(), getxBox(), getyBox());
    }
    public static Rectangle getSurroundingBox() {
        return new Rectangle(getxAbs()-200, getyAbs()-200, 400, 400);
    }

    public static void setxAbs(int newxAbs) {
        coordinates[0][0] = newxAbs;
    }
    public static void setyAbs(int newyAbs) {
        coordinates[0][1] = newyAbs;
    }
    public static void setxVis(int newxVis) {
        coordinates[1][0] = newxVis;
    }
    public static void setyVis(int newyVis) {
        coordinates[1][1] = newyVis;
    }
    public static void setxBox(int newxBox) {
        boundingBox[0] = newxBox;
    }
    public static void setyBox(int newyBox) {
        boundingBox[1] = newyBox;
    }
    public static void setSpeed(int newSpeed) {
        speed = newSpeed;
    }
    public static void setTextureName(String newTextureName) {
        textureName = newTextureName;
    }
    public static void setUp(Boolean newUp) {
        up = newUp;
    }
    public static void setDown(Boolean newDown) {
        down = newDown;
    }
    public static void setRight(Boolean newRight) {
        right = newRight;
    }
    public static void setLeft(Boolean newLeft) {
        left = newLeft;
    }

}