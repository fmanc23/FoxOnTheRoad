package logic.characters;

import java.util.Random;

public class Rock extends Entity {
    
    public Rock(int xAbs, int yAbs, int xBox, int yBox, int randomTextureNumber) {
        super(xAbs * 64 + new Random(System.currentTimeMillis()).nextInt(16), yAbs * 64 + new Random(System.currentTimeMillis()).nextInt(16),
        xBox, yBox, "RockTexture" + randomTextureNumber +".png");
    }
}
