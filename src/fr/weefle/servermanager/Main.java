package fr.weefle.servermanager;

import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

    public static Main instance;

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static Main getInstance() {
        return instance;
    }

}
