package logic.characters;

import java.awt.Rectangle;

public class Entity {

    protected int[] coordinates = new int[2];
    protected int[] boundingBox = new int[2];
    protected String textureName = "";


    protected Entity (int xAbs, int yAbs, int xBox, int yBox, String newTextureName) {
        this.coordinates[0] = xAbs;
        this.coordinates[1] = yAbs;
        this.boundingBox[0] = xBox;
        this.boundingBox[1] = yBox;
        this.textureName = newTextureName;
    }

    // Get and Set Methods
    public int getxAbs(){
        return this.coordinates[0];
    }
    public int getyAbs(){
        return this.coordinates[1];
    }
    public int getxBox(){
        return this.boundingBox[0];
    }
    public int getyBox(){
        return this.boundingBox[1];
    }
    public String getTextureName() {
        return this.textureName;
    }
    public Rectangle getBoundingBox() {
        return new Rectangle(getxAbs(), getyAbs(), getxBox(), getyBox());
    }

    public void setxAbs(int newxAbs) {
        this.coordinates[0] = newxAbs;
    }
    public void setyAbs(int newyAbs) {
        this.coordinates[1] = newyAbs;
    }
    
    public void setxBox(int newxBox) {
        this.boundingBox[0] = newxBox;
    }
    public void setyBox(int newyBox) {
        this.boundingBox[0] = newyBox;
    }
    public void setTextureName(String newTextureName) {
        this.textureName = newTextureName;
    }
    public void setBoundingBox(int x, int y) {
        this.setxBox(x);
        this.setyBox(y);
    }
}
