package view;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatGUI {

    // Font
    private static final Font FONT = new Font("Sans Serif", Font.BOLD, 18); // Creating the UI Elements
    private static JLabel lvlStats = new JLabel();
    private static JLabel storicHS = new JLabel();
    private static JLabel presentHS = new JLabel();
    private static JLabel hp = new JLabel();
    private static JLabel coins = new JLabel();
    private static JLabel points = new JLabel();
    private static JButton startBut = new JButton();
    // Time for level
    private static int timeRemaining = 120;
    // 1000 are milliseconds of delay
    private static Timer levelTimer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(timeRemaining > 0) {
                setTimer(-1);
            }
            setButton();
        }
    });

    // Creating the StatPane with the top game status (Level, Percentage of completion, Start/Stop button and Lives)
    protected JPanel getPanel() {

        //Creating the panel
        JPanel statPane = new JPanel(new GridLayout(1, 7)); // Using 7 coloumns to align the items

        // Setting the height, the width is mostly because of the gamePane
        statPane.setPreferredSize(new Dimension(1400, 75));

        // Creating borders for upper panel
        statPane.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // Setting up the labels and the button
        setLabels();
        setButton();
        startBut.setFocusable(false);

        // Adding the statistics to the statPane
        statPane.add(lvlStats);
        statPane.add(storicHS);
        statPane.add(presentHS);
        statPane.add(startBut);
        statPane.add(points);
        statPane.add(coins);
        statPane.add(hp);

        // Using a timer to update the labels
        new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLabels();
            }
        }
        ).start();

        // Starting the game through the button by adding the Action Listener
        startBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(View.getLogic().getIsPaused()) {
                    View.getLogic().setIsPaused(false);
                    levelTimer.start();
                }
                else {
                    View.getLogic().setIsPaused(true);
                    levelTimer.stop();
                }
            }
        });
        
        return statPane;
    }

    // Setting the Labels and the Button
    private static void setLabels() {
        
        // Creating the interactive JLabel to display the level with the percentage of completion
        if(View.getLogic().getLevel() == 0) {
            lvlStats.setText("Livello Tutorial - " + View.getLogic().getPercentage() + "%");
        } else {
            lvlStats.setText("Livello " + View.getLogic().getLevel() + " - " + View.getLogic().getPercentage() + "%");
        }
        lvlStats.setHorizontalAlignment(SwingConstants.LEFT);
        lvlStats.setFont(FONT);

        // Creating the interactive JLabel to display the Storic High Score
        storicHS.setText("HS assoluto: " + View.getLogic().getStoricHighScore());
        storicHS.setHorizontalAlignment(SwingConstants.LEFT);
        storicHS.setFont(FONT);
        
        // Creating the interactive JLabel to display the Session's High Score
        presentHS.setText("HS sessione: " + View.getLogic().getPresentHighScore());
        presentHS.setHorizontalAlignment(SwingConstants.LEFT);
        presentHS.setFont(FONT);

        // Creating the interactive JLabel to display the points
        points.setText("Punti: " + View.getLogic().getPoints());
        points.setHorizontalAlignment(SwingConstants.RIGHT);
        points.setFont(FONT);

        // Creating the interactive JLabel to display the lives
        hp.setText("Vite: " + View.getLogic().getLives());
        hp.setHorizontalAlignment(SwingConstants.RIGHT);
        hp.setIcon(new ImageIcon(View.getUtilities().getElementsAssetsLocation("HeartIcon.gif")));
        hp.setFont(FONT);

        // Creating the interactive JLabel to display the lives
        coins.setText("Monete: " + View.getLogic().getCoins());
        coins.setHorizontalAlignment(SwingConstants.RIGHT);
        coins.setIcon(new ImageIcon(View.getUtilities().getElementsAssetsLocation("CoinTexture.gif")));
        coins.setFont(FONT);
    }
    
    private static void setButton() {
        
        // timeRemaining
        if(timeRemaining >= 600) {
            if(timeRemaining%60 < 10) {
                startBut.setText("Timer: " + timeRemaining/60 + ":0" + timeRemaining%60);
            } else {
                startBut.setText("Timer: " + timeRemaining/60 + ":" + timeRemaining%60);
            }
        } else if(timeRemaining < 600 && timeRemaining > 0) {
            if(timeRemaining%60 < 10) {
                startBut.setText("Timer: 0" + timeRemaining/60 + ":0" + timeRemaining%60);
            } else {
                startBut.setText("Timer: 0" + timeRemaining/60 + ":" + timeRemaining%60);
            }
        } else if(timeRemaining == 0) {
            View.getLogic().setLives();
        }

        startBut.setFont(FONT);
        startBut.setPreferredSize(new Dimension(200, 50)); // Making the button bigger

    }

    // Timer controls
    protected static void startTimer() {
        levelTimer.start();
    }
    protected static void stopTimer() {
        levelTimer.stop();
    }

    protected static void resetTimer() {
        timeRemaining = 120;
    }
    
    private static void setTimer(int i) {
        timeRemaining += i;
    }

}