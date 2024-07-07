package utilities;

import logic.ILogic;
import view.IView;

import java.util.List;
import javax.sound.sampled.Clip;

public class Utilities implements IUtilities {

    private static ILogic logic = null;
    private static IView view = null;

    public Utilities() {
        //todo
    }

    public void retrieveLogicView(ILogic newLogic, IView newView) {
        logic = newLogic;
        view = newView;
    }

    public static ILogic getLogic() {
        return logic;
    }

    public static  IView getView() {
        return view;
    }

    // Assets
    public String getElementsAssetsLocation(String assetName) {
        return new Assets().getElementsAssetsLocation(assetName);
    }

    public String getIcon() {
        return new Assets().getIcon();
    }

    public String getLevelMapLocation(int levelNumber) {
        return new Assets().getLevelMapLocation(levelNumber);
    }

    public String getLevelMapFolder() {
        return new Assets().getLevelMapFolder();
    }

    public String getHighScoresFile() {
        return new Assets().getHighScoresFile();
    }

    public String getTexturesLocation(String assetName) {
        return new Assets().getTexturesLocation(assetName);
    }
    
    public String getAudioAssetsLocation(String assetName) {
        return new Assets().getAudioAssetsLocation(assetName);
    }

    // AudioPlayer
    public void playFileLoop(String fileName) {
        new AudioPlayer().playFileLoop(fileName);
    }
    
    public void playFile(String fileName) {
        new AudioPlayer().playFile(fileName);
    }
    
    public void releaseAudioResorces() {
        new AudioPlayer().releaseAudioResources();
    }

    public Clip getClip(String fileName) {
        return new AudioPlayer().getClip(fileName);
    }


    // ReadTextFile
    public List<String> readHighScores() {
        return ReadTextFile.readHighScores();
    }

    public char[][] readMap(int level){
        return ReadTextFile.readMap(level);
    }

    // Write Text File
    public void writeHighScores(String name) {
        WriteTextFile.writeHighScores(name);
    }
}
