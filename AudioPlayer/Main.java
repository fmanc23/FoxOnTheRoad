public class Main {

    public static void main(String[] args) {
        for(int i=0; i<5; i++) {
            System.out.println(i);
            AudioPlayer.playFile("bobo.wav");
        }
        AudioPlayer.releaseResources();
    }
    
} // end class