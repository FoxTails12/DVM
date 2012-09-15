package me.FoxTails12.dvm;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMonster implements CommandExecutor{
	
	private DVM_Main plugin;
	
	public CommandMonster(DVM_Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("DVM.Monster")) {
	        if (args.length < 0) {
	           sender.sendMessage(ChatColor.RED + "Not enough arguments!");
	           return false;
	        }
	        else {
	        	if(args[0].equalsIgnoreCase("SuperLow")) {
	        		//Spawns a monster every 20 seconds
	        		player.getWorld().setTicksPerMonsterSpawns(400);
	        		plugin.broadcastAdmin(ChatColor.GREEN + "Monster spawn rate changed to SuperLow (400)");
	        		plugin.getLogger().info(player.getDisplayName() + " changed spawn rate to SuperLow (400)");
	        	}
	        	if(args[0].equalsIgnoreCase("Low")) {
	        		//Spawns a monster every 10 seconds
	        		player.getWorld().setTicksPerMonsterSpawns(200);
	        		plugin.broadcastAdmin(ChatColor.GREEN + "Monster spawn rate changed to Low (200)");
	        		plugin.getLogger().info(player.getDisplayName() + " changed monster spawn rate to Low (200)");
	        	}
	        	if(args[0].equalsIgnoreCase("Medium")) {
	        		//Spawns a monster every 5 seconds
	        		player.getWorld().setTicksPerMonsterSpawns(100);
	        		plugin.broadcastAdmin(ChatColor.GREEN + "Monster spawn rate changed to Medium (100)");
	        		plugin.getLogger().info(player.getDisplayName() + " changed monster spawn rate to Medium (100)");
	        	}
	        	if(args[0].equalsIgnoreCase("High")) {
	        		//Spawns a monster every 2.5 seconds
	        		player.getWorld().setTicksPerMonsterSpawns(50);
	        		plugin.broadcastAdmin(ChatColor.GREEN + "Monster spawn rate changed to High (50)");
	        		plugin.getLogger().info(player.getDisplayName() + " changed monster spawn rate to High (50)");
	        	}
	        	if(args[0].equalsIgnoreCase("SuperHigh")) {
	        		//Spawns a monster every .5 seconds
	        		player.getWorld().setTicksPerMonsterSpawns(10);
	        		plugin.broadcastAdmin(ChatColor.GREEN + "Monster spawn rate changed to SuperHigh (10)");
	        		plugin.getLogger().info(player.getDisplayName() + " changed monster spawn rate to SuperHigh (10)");
	        	}
	        	if(args[0].equalsIgnoreCase("Off")) {
	        		player.getWorld().setTicksPerMonsterSpawns(0);
	        		plugin.broadcastAdmin(ChatColor.GREEN + "Monster spawn diabled");
	        		plugin.getLogger().info(player.getDisplayName() + " disabled monster spawning");
	        	}
	        	else {
	        		player.sendMessage(ChatColor.RED + "Invalid usage: Use following paramaters");
	        		player.sendMessage(ChatColor.RED + " SuperLow  = Spawns a monster every 20 seconds");
	        		player.sendMessage(ChatColor.RED + " Low = Spawns a monster every 10 seconds");
	        		player.sendMessage(ChatColor.RED + " Medium = Spawns a monster every 5 seconds");
	        		player.sendMessage(ChatColor.RED + " High = Spawns a monster every 2.5 seconds");
	        		player.sendMessage(ChatColor.RED + " SuperHigh = Spawns a monster every .5 seconds");
	        		player.sendMessage(ChatColor.RED + " Off = Disables monster spawning");
	        	}
	        	
	        }
		}
		else {
			sender.sendMessage(ChatColor.RED + "You don't have permission to use this command");
		}
		
		return false;
	}
}
