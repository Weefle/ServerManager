package fr.weefle.servermanager.servers;

import fr.weefle.servermanager.Main;
import fr.weefle.servermanager.enums.ServerTypes;

import java.io.File;
import java.util.Random;
import java.util.UUID;

public class Server {

    private ServerTypes servertype;
    private String servername;
    private int serverport;
    private Thread thread;

    public Server(ServerTypes servertype, boolean autostart) {
        this.servertype = servertype;
        this.servername = UUID.randomUUID().toString().substring(0 ,8).replace("-", "");
        while (Main.getServersManager().exists(servername)){
            this.servername = UUID.randomUUID().toString().substring(0 ,8).replace("-", "");
        }
        this.serverport = new Random().nextInt(1000)+5000;
        while (Main.getServersManager().isUsedPort(serverport)){
            this.serverport = new Random().nextInt(1000)+5000;
        }
        this.thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				File source = new File("/home/waze/models/" + servertype.getModel());
				File destination = new File("/home/waze/servers/" + servername);
				FilesUtils.copyFolder(source, destination);
				thread.interrupt();
				if(autostart) {
					startServer();
				}
				
			}

		});
        thread.start();
        Main.getServersManager().addServer(this);
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
    public void startServer() {
		
		
		
	}
}
