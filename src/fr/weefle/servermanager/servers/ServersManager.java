package fr.weefle.servermanager.servers;

import java.util.HashMap;

public class ServersManager {

    private HashMap<String, Server> servers;

    public ServersManager() {
        servers = new HashMap<>();
    }
    
    public void addServer(Server server) {
    	
    	if(!exists(server.getServername())) {
    		servers.put(server.getServername(), server);
    	}
    	
    }
    
    public void removeServer(String servername) {
    	if(exists(servername)) {
    		servers.remove(servername);
    	}
    }

    public boolean exists(String servername){
        return servers.containsKey(servername);
    }

    public boolean isUsedPort(int port){
        return servers.values().stream().filter(server -> server.getServerport() == port).count() > 0;
    }
    
    public  Server getServer(String servername) {
    	
    	return servers.get(servername);
    	
    }
    
    public void removeAll() {
    	servers.values().forEach(server -> server.killServer());
    }

}
