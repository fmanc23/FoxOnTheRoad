package utilities;

public class Assets {
    // Getting the absolute path
    private String assetPath = AbsolutePath.getAbsolutePath();
    // This string will be concatenated with the rest of the path which is needed

    /*
     * Elements
     */
    protected String getElementsAssetsLocation(String assetName) {
        // Navigating to the assets folder while checking on Windows or *NIX-Like
        if (assetPath.contains("\\")) {
            assetPath = assetPath + "assets\\Elements\\" + assetName; // Windows version
        }
        else if (assetPath.contains("/")) {
            assetPath = assetPath + "assets/Elements/" + assetName; // *NIX version
        }
        return assetPath;
    }

    /*
     * Icon
     */
    protected String getIcon() {
        // Navigating to the assets folder while checking on Windows or *NIX-Like
        if (assetPath.contains("\\")) {
            assetPath = assetPath + "assets\\Elements\\Icon.png"; // Windows version
        }
        else if (assetPath.contains("/")) {
            assetPath = assetPath + "assets/Elements/Icon.png"; // *NIX version
        }
        return assetPath;
    }

    /*
     * Level Map
     */
    protected String getLevelMapLocation(int levelNumber) {
        // Navigating to the assets folder while checking on Windows or *NIX-Like
        if (assetPath.contains("\\")) {
            assetPath = assetPath + "assets\\LevelMaps\\" + levelNumber + ".txt"; // Windows version
        }
        else if (assetPath.contains("/")) {
            assetPath = assetPath + "assets/LevelMaps/" + levelNumber + ".txt"; // *NIX version
        }
        return assetPath;
    }
    protected String getLevelMapFolder() {
        // Navigating to the assets folder while checking on Windows or *NIX-Like
        if (assetPath.contains("\\")) {
            assetPath = assetPath + "assets\\LevelMaps\\"; // Windows version
        }
        else if (assetPath.contains("/")) {
            assetPath = assetPath + "assets/LevelMaps/"; // *NIX version
        }
        return assetPath;
    }

    /*
     * High Scores
     */
    protected String getHighScoresFile() {
        // Navigating to the assets folder while checking on Windows or *NIX-Like
        if (assetPath.contains("\\")) {
            assetPath = assetPath + "assets\\Misc\\HighScores.csv"; // Windows version
        }
        else if (assetPath.contains("/")) {
            assetPath = assetPath + "assets/Misc/HighScores.csv"; // *NIX version
        }
        return assetPath;
    }

    /*
     * Textures
     */
    protected String getTexturesLocation(String assetName) {
        // Navigating to the assets folder while checking on Windows or *NIX-Like
        if (assetPath.contains("\\")) {
            assetPath = assetPath + "assets\\Textures\\" + assetName; // Windows version
        }
        else if (assetPath.contains("/")) {
            assetPath = assetPath + "assets/Textures/" + assetName; // *NIX version
        }
        return assetPath;
    }

    /*
     * Audio
     */
    protected String getAudioAssetsLocation(String assetName) {
        // Navigating to the assets folder while checking on Windows or *NIX-Like
        if (assetPath.contains("\\")) {
            assetPath = assetPath + "assets\\Audio\\" + assetName; // Windows version
        }
        else if (assetPath.contains("/")) {
            assetPath = assetPath + "assets/Audio/" + assetName; // *NIX version
        }
        return assetPath;
    }
}
