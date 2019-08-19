package fr.weefle.servermanager.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class ServerCreate extends Command{

	public ServerCreate() {
		super("servercreate");
	}

	@Override
	public void execute(CommandSender arg0, String[] arg1) {
		
		if(arg1.length !=1) {
			
			arg0.sendMessage(new TextComponent("/servercreate <server-type>"));
			return;
			
		}
		
	}
	
	

}
