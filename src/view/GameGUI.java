package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.ListIterator;

public class GameGUI extends JPanel implements ActionListener {
    
    private static boolean win = false;

    private static final File TUTORIALKEYS = new File(View.getUtilities().getTexturesLocation("TutorialKeys.png"));
    private static final File TUTORIALWOT = new File(View.getUtilities().getTexturesLocation("TutorialWoT.png"));
    private static final File TUTORIALCOINS = new File(View.getUtilities().getTexturesLocation("TutorialCoins.png"));
    private static final File TUTORIALREADY = new File(View.getUtilities().getTexturesLocation("TutorialReady.png"));
    private static final File WINPANEL = new File(View.getUtilities().getTexturesLocation("WinPanel.png"));
    
    private static final Image BLUETRUCKUP = new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehicleBlueTruckBigToUpTexture.gif")).getImage();
    private static final Image GREENTRUCKUP = new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehicleGreenTruckBigToUpTexture.gif")).getImage();
    private static final Image ORANGETRUCKUP = new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehicleOrangeTruckBigToUpTexture.gif")).getImage();
    private static final Image CARRERAUP =  new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehicleCarreraGTMidToUpTexture.gif")).getImage();
    private static final Image DELTAUP =  new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehicleDeltaHFMidToUpTexture.gif")).getImage();
    private static final Image PANDAGREENUP = new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehicleGreenPandaSmallToUpTexture.gif")).getImage();
    private static final Image PANDAPURPLEUP =  new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehiclePurplePandaSmallToUpTexture.gif")).getImage();
    private static final Image EVOUP =  new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehicleLancerEvoXMidToUpTexture.gif")).getImage();
    private static final Image MIATAUP =  new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehicleMiataSmallToUpTexture.gif")).getImage();
    
    private static final Image BLUETRUCKDOWN = new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehicleBlueTruckBigToDownTexture.gif")).getImage();
    private static final Image GREENTRUCKDOWN = new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehicleGreenTruckBigToDownTexture.gif")).getImage();
    private static final Image ORANGETRUCKDOWN = new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehicleOrangeTruckBigToDownTexture.gif")).getImage();
    private static final Image CARRERADOWN = new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehicleCarreraGTMidToDownTexture.gif")).getImage();
    private static final Image DELTADOWN = new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehicleDeltaHFMidToDownTexture.gif")).getImage();
    private static final Image EVODOWN = new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehicleLancerEvoXMidToDownTexture.gif")).getImage();
    private static final Image MIATADOWN = new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehicleMiataSmallToDownTexture.gif")).getImage();
    private static final Image PANDAGREENDOWN = new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehicleGreenPandaSmallToDownTexture.gif")).getImage();
    private static final Image PANDAPURPLEDOWN = new ImageIcon(View.getUtilities()
        .getTexturesLocation("VehiclePurplePandaSmallToDownTexture.gif")).getImage();

    private static final Image COIN = new ImageIcon(View.getUtilities()
        .getTexturesLocation("CoinTexture.gif")).getImage();
    private static final Image TREE1 = new ImageIcon(View.getUtilities()
        .getTexturesLocation("TreeTexture1.gif")).getImage();
    private static final Image TREE2= new ImageIcon(View.getUtilities()
        .getTexturesLocation("TreeTexture2.gif")).getImage();

    private static final File ROCK1 = new File(View.getUtilities().getTexturesLocation("RockTexture1.png"));
    private static final File ROCK2 = new File(View.getUtilities().getTexturesLocation("RockTexture2.png"));

    private static final int[] SMALLVEHICLEDIMENSIONS = new int[]{50,80};
    private static final int[] MIDVEHICLEDIMENSIONS = new int[]{50,100};
    private static final int[] BIGVEHICLEDIMENSIONS = new int[]{60,250};
    private static final int[] ROCKDIMENSIONS = new int[]{48,48};
    private static final int[] TREE1DIMENSIONS = new int[]{48,120};
    private static final int[] TREE2DIMENSIONS = new int[]{48,96};
    private static final int[] COINDIMENSIONS = new int[]{32,32};

    private static final String FOXSTAYTEXTURENAME = "FoxStayTexture.gif";
    private static final String FOXFORWARDTEXTURENAME = "FoxMoveForwardTexture.gif";
    private static final String FOXBACKTEXTURENAME = "FoxMoveBackwardTexture.gif";
    private static final String FOXKILLTEXTURENAME = "FoxDeathTexture.gif";

    private static final Image FOXSTAYTEXTURE = new ImageIcon(View.getUtilities()
        .getTexturesLocation(FOXSTAYTEXTURENAME)).getImage();
    private static final Image FOXFORWARDTEXTURE = new ImageIcon(View.getUtilities()
        .getTexturesLocation(FOXFORWARDTEXTURENAME)).getImage();
    private static final Image FOXBACKTEXTURE = new ImageIcon(View.getUtilities()
        .getTexturesLocation(FOXBACKTEXTURENAME)).getImage();
    private static final Image FOXKILLTEXTURE = new ImageIcon(View.getUtilities()
        .getTexturesLocation(FOXKILLTEXTURENAME)).getImage();

    // Creating the GameGUI for the Game to appear
    protected GameGUI() {
        // Setting the size of the JPanel
        super.setSize(new Dimension(1400, 640)); // Each tile is 64x64
        super.isFocusable();
        // Starting the timer to refresh the visualizer
        new Timer(16, this).start();
    } // End of constructor


    // Paint the game
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        try {
            // Drawing the Map
            g.drawImage(MapGraphics.getMapImage(), View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                        0, MapGraphics.getMapImage().getWidth(), MapGraphics.getMapImage().getHeight(), null, null);

            // Drawing the Tutorial if needed
            if(View.getLogic().getLevel() == 0) {
                g.drawImage(ImageIO.read(TUTORIALKEYS), View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                0, 335, 608, null, null);
                g.drawImage(ImageIO.read(TUTORIALWOT), 460+View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                0, 757, 640, null, null);
                g.drawImage(ImageIO.read(TUTORIALCOINS), 1555+View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                0, 291, 214, null, null);
                g.drawImage(ImageIO.read(TUTORIALREADY), 2310+View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                0, 128, 640, null, null);
            }

            // Drawing the fox
            if(View.getLogic().getFoxTextureName().contains(FOXSTAYTEXTURENAME)) {
                g.drawImage(FOXSTAYTEXTURE,
                    View.getLogic().getFoxRelativeCoordinates()[0], View.getLogic().getFoxRelativeCoordinates()[1],
                    60, 40, null, null);
            } else if(View.getLogic().getFoxTextureName().contains(FOXFORWARDTEXTURENAME)) {
                g.drawImage(FOXFORWARDTEXTURE,
                    View.getLogic().getFoxRelativeCoordinates()[0], View.getLogic().getFoxRelativeCoordinates()[1],
                    60, 40, null, null);
            } else if(View.getLogic().getFoxTextureName().contains(FOXBACKTEXTURENAME)) {
                g.drawImage(FOXBACKTEXTURE,
                    View.getLogic().getFoxRelativeCoordinates()[0], View.getLogic().getFoxRelativeCoordinates()[1],
                    60, 40, null, null);
            } else if(View.getLogic().getFoxTextureName().contains(FOXKILLTEXTURENAME)) {
                g.drawImage(FOXKILLTEXTURE,
                    View.getLogic().getFoxRelativeCoordinates()[0], View.getLogic().getFoxRelativeCoordinates()[1],
                    60, 40, null, null);
            }

            // Drawing the obstacles
            LinkedList<String[]> entitiesToDraw = View.getLogic().getEntityListToDraw();
            ListIterator<String[]> iterator = entitiesToDraw.listIterator();
            while(iterator.hasNext()) {
                String[] nextEntity = iterator.next();
                if(nextEntity[0].contains("gif")) {
                    // Vehicles going up
                    if(nextEntity[0].contains("Up")){
                        if(nextEntity[0].contains("VehicleBlueTruckBig")){
                            g.drawImage(BLUETRUCKUP,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), BIGVEHICLEDIMENSIONS[0], BIGVEHICLEDIMENSIONS[1], null, null);
                        } else if(nextEntity[0].contains("VehicleGreenTruckBig")){
                            g.drawImage(GREENTRUCKUP,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), BIGVEHICLEDIMENSIONS[0], BIGVEHICLEDIMENSIONS[1], null, null);
                        } else if(nextEntity[0].contains("VehicleOrangeTruckBig")){
                            g.drawImage(ORANGETRUCKUP,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), BIGVEHICLEDIMENSIONS[0], BIGVEHICLEDIMENSIONS[1], null, null);
                        } else if(nextEntity[0].contains("VehicleCarreraGTMid")){
                            g.drawImage(CARRERAUP,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), MIDVEHICLEDIMENSIONS[0], MIDVEHICLEDIMENSIONS[1], null, null);
                        } else if(nextEntity[0].contains("VehicleDeltaHFMid")){
                            g.drawImage(DELTAUP,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), MIDVEHICLEDIMENSIONS[0], MIDVEHICLEDIMENSIONS[1], null, null);
                        } else if(nextEntity[0].contains("VehicleGreenPandaSmall")){
                            g.drawImage(PANDAGREENUP,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), SMALLVEHICLEDIMENSIONS[0], SMALLVEHICLEDIMENSIONS[1], null, null);
                        } else if(nextEntity[0].contains("VehiclePurplePandaSmall")){
                            g.drawImage(PANDAPURPLEUP,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), SMALLVEHICLEDIMENSIONS[0], SMALLVEHICLEDIMENSIONS[1], null, null);
                        } else if(nextEntity[0].contains("VehicleMiataSmall")){
                            g.drawImage(MIATAUP,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), SMALLVEHICLEDIMENSIONS[0], SMALLVEHICLEDIMENSIONS[1], null, null);
                        } else if(nextEntity[0].contains("VehicleLancerEvoXMid")){
                            g.drawImage(EVOUP,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), MIDVEHICLEDIMENSIONS[0], MIDVEHICLEDIMENSIONS[1], null, null);
                        }
                    } 
                    // Vehicles Going Down
                    else if(nextEntity[0].contains("Down")) {
                        if(nextEntity[0].contains("VehicleBlueTruckBig")){
                            g.drawImage(BLUETRUCKDOWN,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), BIGVEHICLEDIMENSIONS[0], BIGVEHICLEDIMENSIONS[1], null, null);
                        } else if(nextEntity[0].contains("VehicleGreenTruckBig")){
                            g.drawImage(GREENTRUCKDOWN,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), BIGVEHICLEDIMENSIONS[0], BIGVEHICLEDIMENSIONS[1], null, null);
                        } else if(nextEntity[0].contains("VehicleOrangeTruckBig")){
                            g.drawImage(ORANGETRUCKDOWN,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), BIGVEHICLEDIMENSIONS[0], BIGVEHICLEDIMENSIONS[1], null, null);
                        } else if(nextEntity[0].contains("VehicleCarreraGTMid")){
                            g.drawImage(CARRERADOWN,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), MIDVEHICLEDIMENSIONS[0], MIDVEHICLEDIMENSIONS[1], null, null);
                        } else if(nextEntity[0].contains("VehicleDeltaHFMid")){
                            g.drawImage(DELTADOWN,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), MIDVEHICLEDIMENSIONS[0], MIDVEHICLEDIMENSIONS[1], null, null);
                        } else if(nextEntity[0].contains("VehicleGreenPandaSmall")){
                            g.drawImage(PANDAGREENDOWN,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), SMALLVEHICLEDIMENSIONS[0], SMALLVEHICLEDIMENSIONS[1], null, null);
                        } else if(nextEntity[0].contains("VehiclePurplePandaSmall")){
                            g.drawImage(PANDAPURPLEDOWN,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), SMALLVEHICLEDIMENSIONS[0], SMALLVEHICLEDIMENSIONS[1], null, null);
                        } else if(nextEntity[0].contains("VehicleMiataSmall")){
                            g.drawImage(MIATADOWN,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), SMALLVEHICLEDIMENSIONS[0], SMALLVEHICLEDIMENSIONS[1], null, null);
                        } else if(nextEntity[0].contains("VehicleLancerEvoXMid")){
                            g.drawImage(EVODOWN,
                                    Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                    Integer.valueOf(nextEntity[2]), MIDVEHICLEDIMENSIONS[0], MIDVEHICLEDIMENSIONS[1], null, null);
                        }
                    }
                    
                    // Other entities
                    else if(nextEntity[0].contains("CoinTexture")) {
                        g.drawImage(COIN,
                            Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                            Integer.valueOf(nextEntity[2]), COINDIMENSIONS[0], COINDIMENSIONS[1], null, null);
                    } else if(nextEntity[0].contains("TreeTexture1")) {
                        g.drawImage(TREE1,
                            Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                            Integer.valueOf(nextEntity[2]), TREE1DIMENSIONS[0], TREE1DIMENSIONS[1], null, null);
                    } else if(nextEntity[0].contains("TreeTexture2")) {
                        g.drawImage(TREE2,
                            Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                            Integer.valueOf(nextEntity[2]),TREE2DIMENSIONS[0], TREE2DIMENSIONS[1], null, null);
                    }
                   
                } else {
                    if(nextEntity[0].contains("1")){
                        g.drawImage(ImageIO.read(ROCK1),
                                Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                Integer.valueOf(nextEntity[2]), ROCKDIMENSIONS[0], ROCKDIMENSIONS[1], null, null);
                    }
                    else if(nextEntity[0].contains("2")){
                        g.drawImage(ImageIO.read(ROCK2),
                                Integer.valueOf(nextEntity[1]) + View.getLogic().getFoxRelativeCoordinates()[0]-View.getLogic().getFoxAbsoluteCoordinates()[0],
                                Integer.valueOf(nextEntity[2]), ROCKDIMENSIONS[0], ROCKDIMENSIONS[1], null, null);
                    }

                    // Win
                    if(win) {
                        g.drawImage(ImageIO.read(WINPANEL), 0, 0, 1400, 640, null, null);
                    }
                }
            }    
        } catch(IOException ioe) {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nella stampa di un'entità o della mappa", "Attenzione", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        
    } // end of painting

    protected static void triggerWin() {
        win = true;
    }

    // Action Listener Functions (to repaint the panel)
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        // If it's not paused, let the game mechanics work
        if(!View.getLogic().getIsPaused()) {
            View.getLogic().moveVehicles();
            View.getLogic().moveFox();
            View.getLogic().checkCollision();
        }
    }
    
}