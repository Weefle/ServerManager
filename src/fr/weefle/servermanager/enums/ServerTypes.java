package fr.weefle.servermanager.enums;

public enum ServerTypes {

    SKYWARS(0, "SkyWars", "skywars", 2048),
    RUSHWARS(1, "RushWars", "rushwars", 2048);

    private int id,memory;
    private String name, model;

    ServerTypes(int id, String name, String model, int memory) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.memory = memory;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }
    
    public int getMemory() {
        return memory;
    }
    
    public static ServerTypes getById(int id) {
    	return ServerTypes.values()[id];
    }
}
