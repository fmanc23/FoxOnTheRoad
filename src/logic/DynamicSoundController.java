package logic;

import javax.sound.sampled.Clip;

public class DynamicSoundController {

    // Constants for audio clips
    private static final Clip CLIPCARRERA = Logic.getUtilities().getClip("CarreraGTSound.wav");
    private static final Clip CLIPDELTA = Logic.getUtilities().getClip("DeltaSound.wav");
    private static final Clip CLIPEVO = Logic.getUtilities().getClip("EvoXSound.wav");
    private static final Clip CLIPMIATA = Logic.getUtilities().getClip("MiataSound.wav");
    private static final Clip CLIPPANDA = Logic.getUtilities().getClip("PandaSound.wav");
    private static final Clip CLIPTRUCK = Logic.getUtilities().getClip("TruckSound.wav");
    private static final Clip CLIPTREE = Logic.getUtilities().getClip("TreeSound.wav");
    // Locks to play a sound once for every type of different entity (otherwise volume would be unbearable - sound design decision)
    private static boolean carreraLock = false;   
    private static boolean deltaLock = false;   
    private static boolean evoLock = false;   
    private static boolean miataLock = false;   
    private static boolean pandaLock = false;   
    private static boolean truckLock = false;   
    private static boolean treeLock = false;

    // Playing the clips
    protected static void playSound(String command) {
        if(command.contains("Carrera") && !carreraLock) {
            carreraLock = true;
            CLIPCARRERA.start();
        } else if(command.contains("Delta") && !deltaLock) {
            deltaLock = true;
            CLIPDELTA.start();
        } else if(command.contains("Evo") && !evoLock) {
            evoLock = true;
            CLIPEVO.start();
        } else if(command.contains("Miata") && !miataLock) {
            miataLock = true;
            CLIPMIATA.start();
        } else if(command.contains("Panda") && !pandaLock) {
            pandaLock = true;
            CLIPPANDA.start();
        } else if(command.contains("Truck") && !truckLock) {
            truckLock = true;
            CLIPTRUCK.start();
        } else if(command.contains("Tree") && !treeLock) {
            treeLock = true;
            CLIPTREE.start();
        }
    }
    
    // Stopping the clips
    protected static void stopSound(String command) {
        if(command.contains("Carrera") && carreraLock) {
            CLIPCARRERA.stop();
            carreraLock = false;
        } else if(command.contains("Delta") && deltaLock) {
            CLIPDELTA.stop();
            deltaLock = false;
        } else if(command.contains("Evo") && evoLock) {
            CLIPCARRERA.stop();
            evoLock = false;
        } else if(command.contains("Miata") && miataLock) {
            CLIPMIATA.stop(); 
            miataLock = false;
        } else if(command.contains("Panda") && pandaLock) {
            CLIPPANDA.stop();
            pandaLock = false;
        } else if(command.contains("Truck") && truckLock) {
            CLIPTRUCK.stop();
            truckLock = false;
        } else if(command.contains("Tree") && treeLock) {
            CLIPTREE.stop();
            treeLock = false;
        }
    }
}