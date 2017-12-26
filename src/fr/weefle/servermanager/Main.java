package fr.weefle.servermanager;

import fr.weefle.servermanager.servers.ServersManager;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

    public static Main instance;
    private ServersManager serversManager;
    @Override
    public void onEnable() {
        instance = this;
        serversManager = new ServersManager();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static Main getInstance() {
        return instance;
    }

    public static ServersManager getServersManager(){
        return instance.serversManager;
    }

}
