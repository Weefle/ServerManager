package fr.weefle.servermanager.events;

import net.md_5.bungee.api.AbstractReconnectHandler;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class KickEventListener implements Listener {
	
	
		
	 
	  @SuppressWarnings("deprecation")
	@EventHandler
	  public void onServerKickEvent(ServerKickEvent ev)
	  {
	    ServerInfo kickedFrom = null;
	    if (ev.getPlayer().getServer() != null)
	    {
	      kickedFrom = ev.getPlayer().getServer().getInfo();
	    }
	    else if (ProxyServer.getInstance().getReconnectHandler() != null)
	    {
	      kickedFrom = ProxyServer.getInstance().getReconnectHandler().getServer(ev.getPlayer());
	    }
	    else
	    {
	      kickedFrom = AbstractReconnectHandler.getForcedHost(ev.getPlayer().getPendingConnection());
	      if (kickedFrom == null) {
	        kickedFrom = ProxyServer.getInstance().getServerInfo(ev.getPlayer().getPendingConnection().getListener().getDefaultServer());
	      }
	    }
	    ServerInfo kickTo = ProxyServer.getInstance().getServerInfo("lobby");
	    if ((kickedFrom != null) && (kickedFrom.equals(kickTo))) {
	      return;
	    }
	    ev.setCancelled(true);
	    ev.setCancelServer(kickTo);
	    String msg = "Tu as ete redirige vers le lobby !";
	      msg = ChatColor.translateAlternateColorCodes('&', msg);
	      String kmsg = ChatColor.stripColor(BaseComponent.toLegacyText(ev.getKickReasonComponent()));
	      msg = msg + kmsg;
	      ev.getPlayer().sendMessage(new TextComponent(msg));
	  }

}
