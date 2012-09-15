package me.FoxTails12.dvm;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandStop implements CommandExecutor{
	
	private DVM_Main plugin;
	
	public CommandStop(DVM_Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("DVM.Stop")) {
	        	//CONTINUE
	        	sender.sendMessage(ChatColor.AQUA + "YOU HAVE ENDED THE GAME!");
	        	plugin.broadcastAdmin(ChatColor.RED + "THE GAME HAS ENDED - KICKING ALL PLAYERS IN 15 SECONDS");
	        	plugin.broadcastUser(ChatColor.RED + "THE GAME HAS ENDED - DISCONNECTING IN 15 SECONDS");
	        	plugin.KickOnDelay(ChatColor.AQUA + "Thank you for playing - Come again soon!", 300);
	        	
		}
		else {
			sender.sendMessage(ChatColor.RED + "You don't have permission to use this command");
		}
		
		return false;
	}
}
