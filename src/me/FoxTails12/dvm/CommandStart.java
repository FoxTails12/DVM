package me.FoxTails12.dvm;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandStart implements CommandExecutor{
	
	private DVM_Main plugin;
	
	public CommandStart(DVM_Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("DVM.Start")) {
			if (args.length > 0) {
	           sender.sendMessage(ChatColor.RED + "Too many arguments!");
	           return false;
	        } 
	        else {
	        	//CONTINUE
	        	sender.sendMessage(ChatColor.AQUA + "YOU HAVE BEGUN THE GAME!");
	        	plugin.broadcastAdmin(ChatColor.DARK_AQUA + "THE GAME HAS BEGUN");
	        	plugin.giveAll(378, 0, 1, "DVM.Participate", "DVM.Admin.Exempt.Handout", (ChatColor.RED + "You were not given a magma cream because you are an admin"));
	        }
		}
		else {
			sender.sendMessage(ChatColor.RED + "You don't have permission to use this command");
		}
		
		return false;
	}
}
