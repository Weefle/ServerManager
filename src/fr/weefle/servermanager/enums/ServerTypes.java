package fr.weefle.servermanager.enums;

public enum ServerTypes {

    SKYWARS(0, "SkyWars", "skywars"),
    RUSHWARS(1, "RushWars", "rushwars");

    private int id;
    private String name, model;

    ServerTypes(int id, String name, String model) {
        this.id = id;
        this.name = name;
        this.model = model;
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
}
