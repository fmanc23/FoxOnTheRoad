package view;

import logic.ILogic;

import java.awt.image.BufferedImage;

public interface IView {

    // At the start
    public void retrieveLogic(ILogic logic);
    public void createAndShowGUI();

    // StatGUI
    public void startTimer();
    public void stopTimer();
    public void resetTimer();
    
    // MapGraphics
    public void generateMapImage(char[][] mapMatrix);
    public void clearMap();
    public BufferedImage getMapImage();

    // HighScore GUI
    public void saveHS();

    // GameGUI
    public void winPanel();
}
