package logic;


public class StaticSoundController {
    
    protected void playStaticSound(String command) {
        if(command.equalsIgnoreCase("Coin")) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Logic.getUtilities().playFile("CoinSound.wav");
                }
            }).start();
        } else if(command.equalsIgnoreCase("Hit")) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Logic.getUtilities().playFile("HitSound.wav");
                }
            }).start();
        }
    }


}