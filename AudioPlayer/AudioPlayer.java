import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;



public class AudioPlayer {

    private static Clip clip;
    private static DataLine.Info info;
    
    public static void playFileLoop(String fileName) {

        try {

            File audioFile = new File(fileName);
            AudioInputStream stream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.loop(clip.LOOP_CONTINUOUSLY);
            clip.start();

            Thread.sleep(clip.getMicrosecondLength() / 1000);

            clip.drain();
            clip.close();


        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void playFile(String fileName) {

        try {

            File audioFile = new File(fileName);
            AudioInputStream stream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.loop(0);
            clip.start();

            Thread.sleep(clip.getMicrosecondLength() / 1000);

            //clip.drain();
            //clip.close();


        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void releaseResources() {
        clip.drain();
        clip.close();
    }

}
