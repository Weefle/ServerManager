package fr.weefle.servermanager.servers;

import fr.weefle.servermanager.Main;
import fr.weefle.servermanager.enums.ServerTypes;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;

import java.io.File;
import java.net.InetSocketAddress;
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
        ServerInfo info = ProxyServer.getInstance().constructServerInfo(servername, InetSocketAddress.createUnresolved("localhost", serverport), servername, false);
        ProxyServer.getInstance().getServers().put(servername, info);
        Main.getServersManager().addServer(this);
    }
    
    public void killServer() {
    	try {
			Runtime.getRuntime().exec("screen -S " + this.servername + " -X quit");
		} catch (Exception e) {
			ProxyServer.getInstance().getLogger().warning("Le serveur suivant n'a pas pu etre tue: " + servername + ":" + serverport);
			e.printStackTrace();
			return;
		}
    	deleteServer();
    	ProxyServer.getInstance().getLogger().info("Le serveur: " + servername + ":" + serverport + " a ete tue !");
    }
    
    public void deleteServer() {
    	FilesUtils.deleteFolder(new File("/home/waze/servers/" + servername));
    	ProxyServer.getInstance().getServers().remove(servername);
    	Main.getServersManager().removeServer(servername);
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
		
		ProxyServer.getInstance().getLogger().info("Demarrage du serveur: " + servername + ":" + serverport);
		try {
			String command = "./start_server.sh " + servername + " " + servertype.getMemory() + " " + serverport;
			Runtime.getRuntime().exec(command);
		} catch (Exception e) {
			e.printStackTrace();
			ProxyServer.getInstance().getLogger().warning("Le serveur suivant n'a pas pu demarrer: " + servername + ":" + serverport);
		}
		
	}
}
