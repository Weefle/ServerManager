package fr.weefle.servermanager.enums;

public enum ServerStates {

    STARTING(0),
    ONLINE(1),
    OFFLINE(2),
    CLOSING(3);

    private int id;

    ServerStates(int id) {
       this.id = id;
    }

    public int getId() {
        return id;
    }
}
