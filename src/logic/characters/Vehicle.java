package logic.characters;

import java.util.Random;

import logic.Logic;

public class Vehicle extends Entity {
    
    private static final String TOUP = "ToUp";
    private static final String TODOWN = "ToDown";
    private static final String SMALL = "Small";
    private static final String MID = "Mid";
    private static final String BIG = "Big";

    private int speed = 5;

    public Vehicle(int xAbs, int yAbs, int xBox, int yBox, String newTextureName, int speed){
        super(xAbs, yAbs, xBox, yBox, newTextureName);
        this.setSpeed(speed);
        this.setxAbs(64*xAbs);
        centerVehicle();
        // 80--> Height of Small vehicle
        // 100-->Height of Mid vehicle
        // 250--> Height of Big vehicle
        if(this.textureName.contains(TOUP)) {
            if(this.getTextureName().contains(SMALL)) {
                this.setyAbs((getyAbs() + 80));
            } else if(this.getTextureName().contains(MID)) {
                this.setyAbs((getyAbs() + 100));
            } else if(this.getTextureName().contains(BIG)) {
                this.setyAbs((getyAbs() + 250));
            }
        }
        else if(this.textureName.contains(TODOWN)) {
            if(this.getTextureName().contains(SMALL)) {
                this.setyAbs((getyAbs() - 80));
            } else if(this.getTextureName().contains(MID)) {
                this.setyAbs((getyAbs() - 100));
            } else if(this.getTextureName().contains(BIG)) {
                this.setyAbs((getyAbs() - 250));
            }
        }
        EntityGroup.fixVehiclesOverlap();
    }

    private int getSpeed() {
        return this.speed;
    }

    private void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }

    
    public void move() {
        // Moving and resetting the vehicles once they reach the non-visible state (250px is for the biggest vehicle to not be visible)
        if(this.textureName.contains(TOUP)) {
            this.setyAbs(this.getyAbs() - this.getSpeed());
            if(this.getyAbs() <= 0 - 250) {
                this.setyAbs((Logic.getView().getMapImage().getHeight()));
                EntityGroup.fixVehiclesOverlap();
            }
        } else if(this.textureName.contains(TODOWN)) {
            this.setyAbs(this.getyAbs() + this.getSpeed());
            if(this.getyAbs() >= Logic.getView().getMapImage().getHeight() + 250) {
                this.setyAbs((0 - 250) - new Random().nextInt(150) - 250);
                EntityGroup.fixVehiclesOverlap();
            }
        }
    }

    public void centerVehicle() {
        if(this.textureName.contains(BIG)) {
            this.setxAbs(this.getxAbs() + 2);
        } else if(this.textureName.contains(MID)) {
            this.setxAbs(this.getxAbs() + 7);
        } else if(this.textureName.contains(SMALL)) {
            this.setxAbs(this.getxAbs() + 7);
        }
    }

}
