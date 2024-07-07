package logic;

import logic.characters.Fox;

public class KeyHandler {
    
    protected static void inputPressed(int input) {
        if(input == 1) {
            Fox.setUp(true);
        } else if(input == 3) {
            Fox.setDown(true);
        } else if(input == 4) {
            Fox.setRight(true);
        } else if(input == 2){
            Fox.setLeft(true);
        } else if(input == 5) {
            if(Statistics.getIsPaused()) {
                Statistics.setIsPaused(false);
            } else {
                Statistics.setIsPaused(true);
            }
        }
        if(input == 6){
            Statistics.setLevel(Statistics.getLevel() + 1);
        }
    }

    protected static void inputReleased(int input) {
        if(input == 1) {
            Fox.setUp(false);
        } else if(input == 3) {
            Fox.setDown(false);
        } else if(input == 4) {
            Fox.setRight(false);
        } else if(input == 2){
            Fox.setLeft(false);
        }
    }
}
