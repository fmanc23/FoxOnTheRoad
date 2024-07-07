package logic;

import logic.characters.Entity;
import logic.characters.EntityGroup;
import logic.characters.Fox;

import java.util.LinkedList;
import java.util.ListIterator;

public class CollisionController {

    private static final String HIT = "Hit";
    private static final String COIN = "Coin";
    private static final String ROCK = "Rock";
    private static final String VEHICLE = "Vehicle";
    private static final String CARRERA = "Carrera";
    private static final String DELTA = "Delta";
    private static final String EVO =  "Evo";
    private static final String MIATA = "Miata";
    private static final String PANDA = "Panda";
    private static final String TRUCK = "Truck";
    private static final String TREE = "Tree";
    private static final String TRANSPARENT_TEXTURE = "TransparentTexture.png";

    private static boolean collisionRegistered = false;
    private static LinkedList<Entity> entityList = EntityGroup.getEntityList();
    private static LinkedList<Entity> entitiesWithSound = new LinkedList<Entity>();
    private static int currentTime = 0;

    protected static void checkCollision() {

        // Copy the LinkedList "entityList" to avoid the concurrent access from both EntityGroup and CollisionController
        LinkedList<Entity> entityListCopy = (LinkedList) entityList.clone();
        ListIterator<Entity> iterator = entityListCopy.listIterator();  
        // Checking if the fox intersects any entity
        while(iterator.hasNext()) {
            // This is the entity to check
            Entity entityToCheck = iterator.next();
            // Checking if the collision is happening
            if(Fox.getxAbs() - entityToCheck.getxAbs() < 60 && Fox.getxAbs() - entityToCheck.getxAbs() > -60) {
                if(Fox.getBoundingBox().intersects(entityToCheck.getBoundingBox()) && !collisionRegistered) {
                    setCollisionRegistered(true);
                    collisionType(entityToCheck);
                }
                setCollisionRegistered(false); 
            } 
            // Check if sound should be playing
            if(Fox.getSurroundingBox().intersects(entityToCheck.getBoundingBox()) && (entityToCheck.getTextureName().contains(VEHICLE)
                || entityToCheck.getTextureName().contains(TREE)) && !entitiesWithSound.contains(entityToCheck)) {
                dynamicSoundManager(entityToCheck, true);
            }
        }
        stopPlay();
    }

    private static void collisionType(Entity entityToCheck) {  
        // Coin
        if(entityToCheck.getTextureName().contains(COIN)) {
            Statistics.setCoins();
            entityToCheck.setTextureName(TRANSPARENT_TEXTURE);
            entityToCheck.setBoundingBox(0,0);
            new StaticSoundController().playStaticSound(COIN);
        }
        // Car
        else if(entityToCheck.getTextureName().contains(VEHICLE)) {
            // Letting the hit sound play once every second in case of continous hits
            if((int)(System.currentTimeMillis())/1000 != currentTime) {
                new StaticSoundController().playStaticSound(HIT);
                currentTime = (int)(System.currentTimeMillis())/1000;
            }
            Statistics.setIsPaused(true);
            Fox.killFox();
        }
        // Rock and Tree
        else if(entityToCheck.getTextureName().contains(ROCK) || entityToCheck.getTextureName().contains(TREE)) {
            // Moving the fox back immediately as it cannot go any further
            if(Fox.getUp() && Fox.getRight()) {
                Fox.setyAbs(Fox.getyAbs() + Fox.getSpeed());
                Fox.setyVis(Fox.getyVis() + Fox.getSpeed());
                Fox.setxAbs(Fox.getxAbs() - Fox.getSpeed());
                Fox.setxVis(Fox.getxVis() - Fox.getSpeed());
            } else if(Fox.getDown() && Fox.getRight()){
                Fox.setyAbs(Fox.getyAbs() - Fox.getSpeed());
                Fox.setyVis(Fox.getyVis() - Fox.getSpeed());
                Fox.setxAbs(Fox.getxAbs() - Fox.getSpeed());
                Fox.setxVis(Fox.getxVis() - Fox.getSpeed());
            } else if(Fox.getDown() && Fox.getLeft()){
                Fox.setyAbs(Fox.getyAbs() - Fox.getSpeed());
                Fox.setyVis(Fox.getyVis() - Fox.getSpeed());
                Fox.setxAbs(Fox.getxAbs() + Fox.getSpeed());
                Fox.setxVis(Fox.getxVis() + Fox.getSpeed());
            } else if(Fox.getUp() && Fox.getLeft()){
                Fox.setyAbs(Fox.getyAbs() + Fox.getSpeed());
                Fox.setyVis(Fox.getyVis() + Fox.getSpeed());
                Fox.setxAbs(Fox.getxAbs() + Fox.getSpeed());
                Fox.setxVis(Fox.getxVis() + Fox.getSpeed());
            } else if(Fox.getUp()){
                Fox.setyAbs(Fox.getyAbs() + Fox.getSpeed());
                Fox.setyVis(Fox.getyVis() + Fox.getSpeed());
            } else if(Fox.getDown()){
                Fox.setyAbs(Fox.getyAbs() - Fox.getSpeed());
                Fox.setyVis(Fox.getyVis() - Fox.getSpeed());
            } else if(Fox.getLeft()){
                Fox.setxAbs(Fox.getxAbs() + Fox.getSpeed());
                Fox.setxVis(Fox.getxVis() + Fox.getSpeed());
            } else if(Fox.getRight()){
                Fox.setxAbs(Fox.getxAbs() - Fox.getSpeed());
                Fox.setxVis(Fox.getxVis() - Fox.getSpeed());
            }
            
            // Letting the hit sound play once every second in case of continous hits
            if((int)(System.currentTimeMillis())/1000 != currentTime) {
                new StaticSoundController().playStaticSound(HIT);
                currentTime = (int)(System.currentTimeMillis())/1000;
            }
        }
    }

    private static void dynamicSoundManager(Entity entityToCheck, Boolean toPlay) {
        if(toPlay == true) {
            entitiesWithSound.add(entityToCheck);
            if(entityToCheck.getTextureName().contains(CARRERA)) {
                DynamicSoundController.playSound(CARRERA);
            } else if(entityToCheck.getTextureName().contains(DELTA)) {
                DynamicSoundController.playSound(DELTA);
            } else if(entityToCheck.getTextureName().contains(EVO)) {
                DynamicSoundController.playSound(EVO);            
            } else if(entityToCheck.getTextureName().contains(MIATA)) {
                DynamicSoundController.playSound(MIATA);
            } else if(entityToCheck.getTextureName().contains(PANDA)) {
                DynamicSoundController.playSound(PANDA);
            } else if(entityToCheck.getTextureName().contains(TRUCK)) {
                DynamicSoundController.playSound(TRUCK);
            } else if(entityToCheck.getTextureName().contains(TREE)) {
                DynamicSoundController.playSound(TREE);
            }
        } else if(toPlay == false) {
            entitiesWithSound.remove(entityToCheck); 
            if(entityToCheck.getTextureName().contains(CARRERA)) {
                DynamicSoundController.stopSound(CARRERA);
            } else if(entityToCheck.getTextureName().contains(DELTA)) {
                DynamicSoundController.stopSound(DELTA);
            } else if(entityToCheck.getTextureName().contains(EVO)) {
                DynamicSoundController.stopSound(EVO);            
            } else if(entityToCheck.getTextureName().contains(MIATA)) {
                DynamicSoundController.stopSound(MIATA);
            } else if(entityToCheck.getTextureName().contains(PANDA)) {
                DynamicSoundController.stopSound(PANDA);
            } else if(entityToCheck.getTextureName().contains(TRUCK)) {
                DynamicSoundController.stopSound(TRUCK);
            } else if(entityToCheck.getTextureName().contains(TREE)) {
                DynamicSoundController.stopSound(TREE);
            }           
        }
    }

    private static void stopPlay() {
        LinkedList<Entity> entitiesWithSoundCopy = (LinkedList<Entity>) entitiesWithSound.clone();
        ListIterator<Entity> iterator = entitiesWithSoundCopy.listIterator();
        while(iterator.hasNext()) {
            Entity entityToCheck = iterator.next();
            if(!Fox.getSurroundingBox().intersects(entityToCheck.getBoundingBox())) {
                dynamicSoundManager(entityToCheck, false);
            }
        }
    }
        
    private static void setCollisionRegistered(Boolean newRegistration) {
        collisionRegistered = newRegistration;
    }

    protected static void updateList() {
        entityList = EntityGroup.getEntityList();
    }
}