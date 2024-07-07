package logic.characters;

public class Coin extends Entity {
    
    protected Coin(int xAbs, int yAbs, int xBox, int yBox) {
        super((xAbs * 64) + 16, (yAbs * 64) + 16, xBox, yBox, "CoinTexture.gif");
    }
}