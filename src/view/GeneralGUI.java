package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GeneralGUI implements KeyListener {

    private static final int JFRAMEWIDTH = 1400;
    private static final int JFRAMEHEIGHT = 640+75+36; // +36 is for adjustment only
    private static HighScoreGUI scoreWindow = new HighScoreGUI();


    protected GeneralGUI() {
        // Creating a JFrame
        JFrame frame = new JFrame("Fox On The Road");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(new Dimension(JFRAMEWIDTH, JFRAMEHEIGHT)); 
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon(View.getUtilities().getIcon()).getImage());

        // Content pane
        Container contPane = frame.getContentPane();

        // JPanels for GameGUI and StatGUI
        JPanel statPane = new StatGUI().getPanel();
        GameGUI gamePane = new GameGUI();
        
        // Adding the JPanels to the Content Pane
        contPane.add(statPane, BorderLayout.NORTH);
        contPane.add(gamePane, BorderLayout.CENTER);
        contPane.add(scoreWindow, BorderLayout.SOUTH);

        // Key Listener
        frame.addKeyListener(this);
        frame.setFocusable(true);

        // Play Background Music (loop)
        new Thread(new Runnable() {
            @Override
            public void run() {
                View.getUtilities().playFileLoop("BackgroundMusic.wav");
            }
        }).start();

        // Starting the Level timer
        StatGUI.startTimer();
    }

    protected static HighScoreGUI getHSGUI() {
        return scoreWindow;
    }

    
    // KeyListener methods
    @Override
    public void keyTyped(KeyEvent e) {/* Left Implemented */}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            View.getLogic().inputPressed(1);
        } else if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            View.getLogic().inputPressed(2);
        } else if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            View.getLogic().inputPressed(3);
        } else if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            View.getLogic().inputPressed(4);
        } else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            View.getLogic().inputPressed(5);
        } else if(e.getKeyCode() == KeyEvent.VK_L) {
            View.getLogic().inputPressed(6);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            View.getLogic().inputReleased(1);
        } else if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            View.getLogic().inputReleased(2);
        } else if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            View.getLogic().inputReleased(3);
        } else if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            View.getLogic().inputReleased(4);
        }
    }

}