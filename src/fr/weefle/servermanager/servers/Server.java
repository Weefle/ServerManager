package fr.weefle.servermanager.servers;

import fr.weefle.servermanager.Main;
import fr.weefle.servermanager.enums.ServerTypes;

import java.util.Random;
import java.util.UUID;

public class Server {

    private ServerTypes servertype;
    private String servername;
    private int serverport;

    public Server(ServerTypes servertype) {
        this.servertype = servertype;
        this.servername = UUID.randomUUID().toString().substring(0 ,8).replace("-", "");
        while (Main.getServersManager().exists(servername)){
            this.servername = UUID.randomUUID().toString().substring(0 ,8).replace("-", "");
        }
        this.serverport = new Random().nextInt(1000)+5000;
        while (Main.getServersManager().isUsedPort(serverport)){
            this.serverport = new Random().nextInt(1000)+5000;
        }
    }

    public ServerTypes getServertype() {
        return servertype;
    }

    public String getServername() {
        return servername;
    }

    public int getServerport() {
        return serverport;
    }
}
