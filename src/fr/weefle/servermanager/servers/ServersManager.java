package fr.weefle.servermanager.servers;

import java.util.HashMap;

public class ServersManager {

    private HashMap<String, Server> servers;

    public ServersManager() {
        servers = new HashMap<>();
    }

    public boolean exists(String servername){
        return servers.containsKey(servername);
    }

    public boolean isUsedPort(int port){
        return servers.values().stream().filter(server -> server.getServerport() == port).count() > 0;
    }

}
