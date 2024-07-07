package utilities;

import view.IView;
import logic.ILogic;

import java.util.List;
import javax.sound.sampled.Clip;

public interface IUtilities {

    public void retrieveLogicView(ILogic logic, IView view);

    // Assets
    public String getElementsAssetsLocation(String assetName);
    public String getIcon();
    public String getLevelMapLocation(int levelNumber);
    public String getLevelMapFolder();
    public String getHighScoresFile();
    public String getTexturesLocation(String assetName);
    public String getAudioAssetsLocation(String assetName);

    // Audio Player
    public void playFileLoop(String fileName);
    public void playFile(String fileName);
    public void releaseAudioResorces();
    public Clip getClip(String fileName);

    // Read Text File
    public List<String> readHighScores();
    public char[][] readMap(int level);

    // Write Text File
    public void writeHighScores(String name);
}
