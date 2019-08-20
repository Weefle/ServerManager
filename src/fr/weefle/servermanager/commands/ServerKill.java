package fr.weefle.servermanager.commands;

import fr.weefle.servermanager.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class ServerKill extends Command{

	public ServerKill() {
		super("serverkill");
		
	}

	@Override
	public void execute(CommandSender arg0, String[] arg1) {
		
		if(arg1.length == 1) {
			String servername = arg1[0];
			if(Main.getServersManager().exists(servername)) {
				Main.getServersManager().getServer(servername).killServer();
				arg0.sendMessage(new TextComponent("Le serveur: " + servername + " a ete correctement supprime !"));
			}else {
			arg0.sendMessage(new TextComponent("Ce serveur n'existe pas: " + servername + " !"));
			}
		}else {
			arg0.sendMessage(new TextComponent("/serverkill <server-name>"));
			return;
		}
		
	}
	
	

}
