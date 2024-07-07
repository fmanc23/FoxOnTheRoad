package utilities;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class AudioPlayer {

    private static final String ERROR = "Errore nella riproduzione della soundtrack";
    private static final String ATT = "Attenzione!";


    private Clip clip;
    private DataLine.Info info;
    
    protected void playFileLoop(String fileName) {
        try {
            File audioFile = new File(new Assets().getAudioAssetsLocation(fileName));
            AudioInputStream stream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = stream.getFormat();
            this.info = new DataLine.Info(Clip.class, format);
            this.clip = (Clip) AudioSystem.getLine(this.info);
            this.clip.open(stream);
            this.clip.loop(Clip.LOOP_CONTINUOUSLY);
            this.clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
            this.clip.drain();
            this.clip.close();
        } catch(IOException ioe){
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, ERROR, ATT , JOptionPane.ERROR_MESSAGE );
            System.exit(1);
        } catch(UnsupportedAudioFileException uafe) {
            uafe.printStackTrace();
            JOptionPane.showMessageDialog(null, ERROR, ATT, JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch(LineUnavailableException lue) {
            lue.printStackTrace();
            JOptionPane.showMessageDialog(null, ERROR, ATT, JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch(InterruptedException ie) {
            ie.printStackTrace();
            JOptionPane.showMessageDialog(null, ERROR +" - Stoppamento del Thread", ATT, JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } 

    }

    protected void playFile(String fileName) {
        try {
            File audioFile = new File(new Assets().getAudioAssetsLocation(fileName));
            AudioInputStream stream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = stream.getFormat();
            this.info = new DataLine.Info(Clip.class, format);
            this.clip = (Clip) AudioSystem.getLine(this.info);
            this.clip.open(stream);
            this.clip.loop(0);
            this.clip.start();
            Thread.sleep(this.clip.getMicrosecondLength() / 1000);
        } catch(IOException ioe){
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, ERROR, ATT, JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch(UnsupportedAudioFileException uafe) {
            uafe.printStackTrace();
            JOptionPane.showMessageDialog(null, ERROR, ATT, JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch(LineUnavailableException lue) {
            lue.printStackTrace();
            JOptionPane.showMessageDialog(null, ERROR, ATT, JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch(InterruptedException ie) {
            ie.printStackTrace();
            JOptionPane.showMessageDialog(null, ERROR + " - Stoppamento del Thread", ATT, JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } 

    }

    protected Clip getClip(String fileName) {
        try {
            File audioFile = new File(new Assets().getAudioAssetsLocation(fileName));
            AudioInputStream stream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = stream.getFormat();
            this.info = new DataLine.Info(Clip.class, format);
            this.clip = (Clip) AudioSystem.getLine(this.info);
            this.clip.open(stream);
        } catch(IOException ioe){
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, ERROR, ATT, JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch(UnsupportedAudioFileException uafe) {
            uafe.printStackTrace();
            JOptionPane.showMessageDialog(null, ERROR, ATT, JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch(LineUnavailableException lue) {
            lue.printStackTrace();
            JOptionPane.showMessageDialog(null, ERROR, ATT, JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        return this.clip;
    }

    protected void releaseAudioResources() {
        this.clip.drain();
        this.clip.close();
    }

}