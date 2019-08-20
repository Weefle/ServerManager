package fr.weefle.servermanager.commands;

import fr.weefle.servermanager.enums.ServerTypes;
import fr.weefle.servermanager.servers.Server;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class ServerCreate extends Command{

	public ServerCreate() {
		super("servercreate");
	}

	@Override
	public void execute(CommandSender arg0, String[] arg1) {
		
		if(arg1.length ==1) {
			
			try {
				ServerTypes type = ServerTypes.getById(Integer.parseInt(arg1[0]));
				Server server = new Server(type, true);
				arg0.sendMessage(new TextComponent("Le serveur: " + server.getServername() + " de type: " + type + " a ete demarre avec succes !"));
			} catch (Exception e) {
				arg0.sendMessage(new TextComponent("Ce type de serveur n'existe pas !"));
			}
			
			
		}else {
			arg0.sendMessage(new TextComponent("/servercreate <server-type>"));
			return;
		}
		
		
	}
	
	

}
