package fr.weefle.servermanager;

import fr.weefle.servermanager.commands.ServerCreate;
import fr.weefle.servermanager.commands.ServerKill;
import fr.weefle.servermanager.events.KickEventListener;
import fr.weefle.servermanager.servers.ServersManager;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

    public static Main instance;
    private ServersManager serversManager;
    @Override
    public void onEnable() {
        instance = this;
        serversManager = new ServersManager();
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ServerCreate());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ServerKill());
        ProxyServer.getInstance().getPluginManager().registerListener(this, new KickEventListener());
    }

    @Override
    public void onDisable() {
       serversManager.removeAll();
    }

    public static Main getInstance() {
        return instance;
    }

    public static ServersManager getServersManager(){
        return instance.serversManager;
    }

}
