package logic.characters;

import java.awt.Rectangle;

public class Tree extends Entity {
    
    public Tree(int xAbs, int yAbs, int xBox, int yBox, int randomTextureNumber) {
        super(xAbs * 64, yAbs * 64, xBox, yBox, "TreeTexture" + randomTextureNumber +".gif");
    }

    @Override
    public Rectangle getBoundingBox() {
        Rectangle bBox = null;
        if(this.getTextureName().contains("1")) {
            bBox = new Rectangle(getxAbs(), getyAbs() + 90, getxBox(), getyBox());
        } else if(this.getTextureName().contains(("2"))) {
            bBox = new Rectangle(getxAbs(), getyAbs() + 64, getxBox(), getyBox());
        }
        else {
            if(this.getTextureName().contains("1")) {
                bBox = new Rectangle(getxAbs(), getyAbs(), 48, 120);
            } else if(this.getTextureName().contains("2")) {
                bBox = new Rectangle(getxAbs(), getyAbs(), 48, 96);
            }
        }
        return bBox;
    }
}