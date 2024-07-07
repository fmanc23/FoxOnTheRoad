package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class HighScoreGUI extends JPanel implements ActionListener {

    private static final Font FONT = new Font("Sans Serif", Font.BOLD, 18); 
    // Creating the UI Elements
    private static JLabel text = new JLabel("Vuoi caricare il tuo miglior punteggio?");
    private static JButton buttonYes = new JButton("Si");
    private static JButton buttonNo = new JButton("No");
    private static JTextArea nameArea = new JTextArea("Il tuo nome");
    

    protected HighScoreGUI() {
        super();

        // To set the JPanel visible
        super.setVisible(true);
        // Applying the style to the text
        setStyle();
        // Adding the Action Listener
        buttonYes.addActionListener(this);
        buttonNo.addActionListener(this);
        // Setting the command to run in case of button press
        buttonYes.setActionCommand("LoadPersonalBest");
        buttonNo.setActionCommand("NotLoadPersonalBest");
        // Adding the elements to the UI
        super.add(text);
        super.add(buttonYes);
        super.add(buttonNo);
        
    }
    //set the style of the JLabel and the JButton
    private void setStyle() {
        buttonYes.setFont(FONT);
        buttonNo.setFont(FONT);
        buttonYes.setPreferredSize(new Dimension(200, 50));
        buttonNo.setPreferredSize(new Dimension(200, 50));
        text.setFont(FONT);
        nameArea.setFont(FONT);
    }
    
    private void saveHighScores() {
        super.removeAll();
        buttonYes.setActionCommand("SaveFile");
        buttonYes.setText("Salva");
        super.repaint();
        text.setText("Inserisci il tuo nome nel box di fianco:");
        nameArea.setText("Il tuo nome"); 
        super.add(text);
        super.add(nameArea);
        super.add(buttonYes);
        super.repaint();
    }

    private void loadSaveHighScore(){
        super.removeAll();
        text.setText("Inserisci il tuo nome nel box di fianco:");
        buttonYes.setText("Ok");
        buttonYes.setActionCommand("LoadName");
        super.add(text);
        super.add(nameArea);
        super.add(buttonYes);
        super.repaint();
    }
    
    private void loadUserBest(){
        int pointsActualHigh = 0;
        String playerName = nameArea.getText();
        LinkedList<String> names = new LinkedList<String>();
        LinkedList<Integer> points = new LinkedList<Integer>();
        List<String> highScoresFileLines = View.getUtilities().readHighScores();
        highScoresFileLines.remove(0);
        ListIterator<String> hsIterator = highScoresFileLines.listIterator();
        while(hsIterator.hasNext()) {
            String line = (String) hsIterator.next();
            // Removing ";"
            line = line.substring(0, line.length()-1);

            String[] namePoints = line.split(",");
            names.add(namePoints[0]);
            points.add(Integer.valueOf(namePoints[1]));
        }

        ListIterator<String> nameIterator = names.listIterator();
        int index = 0;
        while(nameIterator.hasNext()){
            String name = (String)nameIterator.next();
            if(playerName.equalsIgnoreCase(name) && pointsActualHigh < points.get(index)) {
                pointsActualHigh = points.get(index);
            }
            index++;
        }
        View.getLogic().setStoricHighScore(pointsActualHigh);
    }

    private void loadBest(){
        int pointsActualHigh = 0;
        List<String> highScoresFileLines = View.getUtilities().readHighScores();
        highScoresFileLines.remove(0);
        ListIterator<String> hsIterator = highScoresFileLines.listIterator();
        while(hsIterator.hasNext()) {
            String line = (String) hsIterator.next();
            // Removing ";"
            line = line.substring(0, line.length()-1);
            String[] namePoints = line.split(",");

            if(Integer.valueOf(namePoints[1]) > pointsActualHigh) {
                pointsActualHigh = Integer.valueOf(namePoints[1]);
                View.getLogic().setStoricHighScore(pointsActualHigh);
            } 
        }
    }

    private void saveBest(String name) {
        View.getUtilities().writeHighScores(name);
    }

    protected void setExitMenu() {
        super.removeAll();
        buttonYes.setActionCommand("SaveBestSession");
        buttonNo.setActionCommand("NotSaveBestSession");
        text.setText("Vuoi salvare il punteggio migliore di questa sessione?");
        super.add(text);
        super.add(buttonYes);
        super.add(buttonNo);
    }

    // ActionListener
    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if(action.equals("LoadPersonalBest")) {
            loadSaveHighScore();
            super.repaint();
        } else if(action.equals("NotLoadPersonalBest")) {
            super.setVisible(false);
            super.removeAll();
            super.repaint();
            View.getLogic().setIsPaused(false);
            loadBest();
            super.setFocusable(false);
        } else if(action.equals("LoadName")) {
            loadUserBest();
            super.setVisible(false);
            super.removeAll();
            super.repaint();
            super.setFocusable(false);
            View.getLogic().setIsPaused(false);
        } else if(action.equals("SaveBestSession")) {
            saveHighScores();
            super.repaint();
        } else if(action.equals("NotSaveBestSession")) {
            System.exit(1);
        } else if(action.equals("SaveFile")) {
            saveBest(nameArea.getText() + ";");
            System.exit(1);
        }
    }
}