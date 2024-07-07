package logic.characters;

import logic.Logic;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class EntityGroup {

    // Constants
    private static final int[] SMALL_VEHICLE_DIMENSIONS = {50, 80};
    private static final int[] MID_VEHICLE_DIMENSIONS = {50, 100};
    private static final int[] BIG_VEHICLE_DIMENSIONS = {60, 250};
    private static final String CAMION_BLUE_UP = "VehicleBlueTruckBigToUpTexture.gif";
    private static final String CAMION_ORANGE_UP = "VehicleOrangeTruckBigToUpTexture.gif";
    private static final String CAMION_GREEN_UP = "VehicleGreenTruckBigToUpTexture.gif";
    private static final String PANDA_PURPLE_UP = "VehiclePurplePandaSmallToUpTexture.gif";
    private static final String PANDA_GREEN_UP = "VehicleGreenPandaSmallToUpTexture.gif";
    private static final String MIATA_UP = "VehicleMiataSmallToUpTexture.gif";
    private static final String EVO_UP = "VehicleLancerEvoXMidToUpTexture.gif";
    private static final String DELTA_UP = "VehicleDeltaHFMidToUpTexture.gif";
    private static final String PORSCHE_UP = "VehicleCarreraGTMidToUpTexture.gif";
    private static final String CAMION_BLUE_DOWN = "VehicleBlueTruckBigToDownTexture.gif";
    private static final String CAMION_ORANGE_DOWN = "VehicleOrangeTruckBigToDownTexture.gif";
    private static final String CAMION_GREEN_DOWN = "VehicleGreenTruckBigToDownTexture.gif";
    private static final String PANDA_PURPLE_DOWN = "VehiclePurplePandaSmallToDownTexture.gif";
    private static final String PANDA_GREEN_DOWN = "VehicleGreenPandaSmallToDownTexture.gif";
    private static final String MIATA_DOWN = "VehicleMiataSmallToDownTexture.gif";
    private static final String EVO_DOWN = "VehicleLancerEvoXMidToDownTexture.gif";
    private static final String DELTA_DOWN = "VehicleDeltaHFMidToDownTexture.gif";
    private static final String PORSCHE_DOWN = "VehicleCarreraGTMidToDownTexture.gif";
    private static final String[] VEHICLE_UP_ARRAY = {CAMION_BLUE_UP, CAMION_ORANGE_UP, CAMION_GREEN_UP, PANDA_PURPLE_UP,
                                                    PANDA_GREEN_UP, MIATA_UP, EVO_UP, DELTA_UP, PORSCHE_UP};
    private static final String[] VEHICLE_DOWN_ARRAY = {CAMION_BLUE_DOWN, CAMION_ORANGE_DOWN, CAMION_GREEN_DOWN, PANDA_PURPLE_DOWN,
                                                    PANDA_GREEN_DOWN, MIATA_DOWN, EVO_DOWN, DELTA_DOWN, PORSCHE_DOWN};
     
    // Entity List
    private static LinkedList<Entity> entityList = new LinkedList<Entity>();
    private static LinkedList<Vehicle> vehicleList = new LinkedList<Vehicle>();

    private static int oldRand = 0;
    private static int numberOfTrucks = 0;
    private static int countVehicles = 0;

    private static Logic logic = new Logic();

    
    public EntityGroup() {
        generateEntityList();
    }

    protected static void generateEntityList() {
        LinkedList<int[]> entityCoordinates = logic.getEntityCoordinates();
        ListIterator<int[]> iterator = entityCoordinates.listIterator();
        while(iterator.hasNext()) {
            // Choosing a random Texture to give to Rocks and Trees
            int randomTextureNumber = new Random(System.currentTimeMillis()).nextInt(2) + 1;
            // Putting the entities into the List
            int[] nextElement = iterator.next();
            if(nextElement[0] == 0) {
                entityList.add(new Rock(nextElement[1], nextElement[2], 48, 48, randomTextureNumber));
            }
            else if(nextElement[0] == 1) {
                entityList.add(new Tree(nextElement[1], nextElement[2], 48, 30, randomTextureNumber));
            }
            else if(nextElement[0] == 2){
                entityList.add(new Coin(nextElement[1], nextElement[2], 48, 48));
            }
            else if(nextElement[0] == 3 || nextElement[0] == 4){
                // Generating a random vehicle to spawn
                Vehicle randVehicle = generateRandom(nextElement);
                entityList.add(randVehicle);
                vehicleList.add(randVehicle);
            }
        }
    }

    protected static Vehicle generateRandom(int[] element) {
        
        Vehicle randVehicle = null;
        int rand = new Random(System.currentTimeMillis()).nextInt(VEHICLE_UP_ARRAY.length);
        
        while(rand == oldRand || ((rand == 0 || rand==1 || rand==2) && numberOfTrucks > 2)) {
            rand = new Random(System.currentTimeMillis()).nextInt(VEHICLE_UP_ARRAY.length);
        }
        
        if(rand==0 || rand==1 || rand==2) {
            numberOfTrucks++;
        } else {
            countVehicles++;
            if(countVehicles % 5 == 0) {
                numberOfTrucks = 0;
            }
        }

        oldRand = rand;
        
        if(element[0] == 4) {
            
            if(VEHICLE_UP_ARRAY[rand].contains("Small")) {
                randVehicle = new Vehicle(element[1], 0, SMALL_VEHICLE_DIMENSIONS[0], SMALL_VEHICLE_DIMENSIONS[1],
                                        VEHICLE_UP_ARRAY[rand], 5);
                
            }

            else if(VEHICLE_DOWN_ARRAY[rand].contains(("Mid"))){
                randVehicle = new Vehicle(element[1], 0, MID_VEHICLE_DIMENSIONS[0], MID_VEHICLE_DIMENSIONS[1],
                                        VEHICLE_UP_ARRAY[rand], 5);

            }

            else if(VEHICLE_UP_ARRAY[rand].contains("Big")){
                randVehicle = new Vehicle(element[1], 0, BIG_VEHICLE_DIMENSIONS[0], BIG_VEHICLE_DIMENSIONS[1],
                                            VEHICLE_UP_ARRAY[rand], 5);
            }
        } else if(element[0] == 3) {

            if(VEHICLE_DOWN_ARRAY[rand].contains("Small")) {
                randVehicle = new Vehicle(element[1], 0, SMALL_VEHICLE_DIMENSIONS[0], SMALL_VEHICLE_DIMENSIONS[1],
                                        VEHICLE_DOWN_ARRAY[rand], 5);
                
            }

            else if(VEHICLE_DOWN_ARRAY[rand].contains(("Mid"))){
                randVehicle = new Vehicle(element[1], 0, MID_VEHICLE_DIMENSIONS[0], MID_VEHICLE_DIMENSIONS[1],
                                        VEHICLE_DOWN_ARRAY[rand], 5);

            }

            else if(VEHICLE_DOWN_ARRAY[rand].contains("Big")){
                randVehicle = new Vehicle(element[1], 0, BIG_VEHICLE_DIMENSIONS[0], BIG_VEHICLE_DIMENSIONS[1],
                                        VEHICLE_DOWN_ARRAY[rand], 5);   
            }

        }
        
        return randVehicle;
    }

    // Fix Vehicles which overlap themselves
    protected static void fixVehiclesOverlap() {
        for(int i=0; i<vehicleList.size(); i++) {
            for(int j=i; j<vehicleList.size(); j++) {
                if(i != j && vehicleList.get(i).getxAbs() - vehicleList.get(j).getxAbs() < 10 &&
                        vehicleList.get(i).getxAbs() - vehicleList.get(j).getxAbs() > -10) {
                    while(vehicleList.get(i).getBoundingBox().intersects(vehicleList.get(j).getBoundingBox())) {
                        if(vehicleList.get(i).getTextureName().contains("Up")) {
                            vehicleList.get(i).setyAbs(vehicleList.get(i).getyAbs() + 250);
                        } else if(vehicleList.get(i).getTextureName().contains("Down")) {
                            vehicleList.get(i).setyAbs(vehicleList.get(i).getyAbs() - 250);
                        }
                    }
                }
            }
        }
    }

    public static void updateList() {
        if(logic.getIsPaused()) {
            flushList();
            generateEntityList();
        }
    }
    
    protected static void flushList() {
        entityList.clear();
    }

    public static LinkedList<Entity> getEntityList() {
        return entityList;
    }

    public static LinkedList<Vehicle> getVehicleList() {
        return vehicleList;
    }
}