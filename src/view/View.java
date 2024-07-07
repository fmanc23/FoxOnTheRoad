package view;

import logic.ILogic;
import utilities.IUtilities;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.image.BufferedImage;


public class View implements IView {

    private static ILogic logic = null;
    private static IUtilities utilities = null;

    public View(IUtilities newUtilities) {
        setUtilities(newUtilities);
    }

    // Logic
    public void retrieveLogic(ILogic newLogic){
        setLogic(newLogic);
    }
    private static void setLogic(ILogic newLogic) {
        logic = newLogic;
    }
    private static void setUtilities(IUtilities newUtilities) {
        utilities = newUtilities;
    }
    public static ILogic getLogic() {
        return logic;
    }
    public static IUtilities getUtilities() {
        return utilities;
    }

    // Starting the GUI
    public void createAndShowGUI() {
        // Calling the invokeLater to put the GUI related stuff in the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Changing the look and feel of the application
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (ClassNotFoundException cnfe) {
                    cnfe.printStackTrace();
                } catch (InstantiationException ie) {
                    ie.printStackTrace();
                } catch (IllegalAccessException iae) {
                    iae.printStackTrace();
                } catch (UnsupportedLookAndFeelException ulfe) {
                    ulfe.printStackTrace();
                } catch (ClassCastException cce) {
                    cce.printStackTrace();
                } catch (NullPointerException npe) {
                    npe.printStackTrace();
                }

                // Starting the GUI
                new GeneralGUI();
            }
        });
    }

    // GeneralGUI
    public void startTimer() {
        StatGUI.startTimer();
    }
    public void stopTimer() {
        StatGUI.stopTimer();
    }
    public void resetTimer() {
        StatGUI.resetTimer();
    }

    // Map
    public void generateMapImage(char[][] mapMatrix) {
        MapGraphics.generateMapImage(mapMatrix);
    }
    public void clearMap() {
        MapGraphics.clearMapImage();
    }
    public BufferedImage getMapImage() {
        return MapGraphics.getMapImage();
    }

    // HighScore GUI
    public void saveHS() {
        HighScoreGUI scoreWindow = GeneralGUI.getHSGUI();
        scoreWindow.setExitMenu();
        scoreWindow.setVisible(true);
    }

    // Game GUI
    public void winPanel() {
        GameGUI.triggerWin();
    }

}
