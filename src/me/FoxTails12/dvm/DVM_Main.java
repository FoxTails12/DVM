package me.FoxTails12.dvm;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class DVM_Main extends JavaPlugin{
	
	/////////////////////////////////////////////////////////////
	//==================== GLOBAL SETTINGS ====================//
	//  Who can receive Admin broadcasts?
	private String BroadcastAdminPerm = "DVM.Messages";
	//  Who can join when server is not open?
	private String JoinAdminPerm = "DVM.Join";
	//  Who won't be kicked when the server is closed?
	private String NoKickPerm = "DVM.NoKick";
	
	
	/////////////////////////////////////////////////////////////
	public static DVM_Main plugin;
	
	public boolean open = false;
	
	@Override
	public void onDisable() {
		this.getLogger().info("DVM has been disabled!");
	}
	
	@Override
	public void onEnable() {
		this.getLogger().info("Enabling DVM...");
		getCommand("start").setExecutor(new CommandStart(this));
		getCommand("stop").setExecutor(new CommandStop(this));
		getCommand("monster").setExecutor(new CommandMonster(this));
		
		//plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(plugin, new Runnable() {
//
//			   public void run() {
//				   if(open == false) {
//					   broadcastAdmin(ChatColor.DARK_RED + "NOTICE: THE SERVER IS CURRENTLY CLOSED - PLAYERS CAN NOT JOIN");
//				   }
//			   }
//			}, 60L, 200L);
	}
	
	
	//REFRENCE METHODS
	//These methods are intended to be referenced from within the alternate command classes - they peform actions
	//Such as giving all players an item or setting a single players armor.
	
	
	public void giveAll(int item, int damage, int quantity, String permission, String exemptPermission, String exemptMessage) {
		//Give everyone on the server who has a permission but does NOT have another permission
		ItemStack give = new ItemStack(Material.getMaterial(item), quantity);
		for(Player player: this.getServer().getOnlinePlayers()) {
			if(player.hasPermission(permission)) { 
				player.getInventory().addItem(give);
			}
			if(player.hasPermission(exemptPermission)) {
				player.sendMessage(exemptMessage);
			}
		}
	}
	
	public void teleAll(World world, double x, double y, double z, String permission, String Message) {
		World teleworld = (World) world;
		for(Player player: this.getServer().getOnlinePlayers()) {
			if(player.hasPermission(permission)) {
				player.teleport(new Location(teleworld, x, y, z));
				player.sendMessage(Message);
			}
		}
	}
	
	public void teleOne(World world, double x, double y, double z, String message, Player player) {
		World teleworld = (World) world;
		player.teleport(new Location(teleworld, x, y, z));
		player.sendMessage(message);
	}
	
	public void armorAll(int Helmet, Enchantment HEnchant, int HLevel, int Chestplate, Enchantment CEnchant,int CLevel, int Leggings, Enchantment LEnchant, int LLevel, int Boots, Enchantment BEnchant, int BLevel, String permission) {
		for(Player player: this.getServer().getOnlinePlayers()) {
			if(player.hasPermission(permission)) {
				ItemStack Helm = new ItemStack(Material.getMaterial(Helmet));
				ItemStack Chest = new ItemStack(Material.getMaterial(Chestplate));
				ItemStack Legs = new ItemStack(Material.getMaterial(Leggings));
				ItemStack Boot = new ItemStack(Material.getMaterial(Boots));
				Helm.addEnchantment(HEnchant, HLevel);
				Chest.addEnchantment(CEnchant, CLevel);
				Legs.addEnchantment(LEnchant, LLevel);
				Boot.addEnchantment(BEnchant, BLevel);
				player.getInventory().setHelmet(Helm);
				player.getInventory().setChestplate(Chest);
				player.getInventory().setChestplate(Legs);
				player.getInventory().setBoots(Boot);
			}
		}
	}
	
	public void armorOne(int Helmet, Enchantment HEnchant, int HLevel, int Chestplate, Enchantment CEnchant,int CLevel, int Leggings, Enchantment LEnchant, int LLevel, int Boots, Enchantment BEnchant, int BLevel, String permission, Player player) {
		if(player.hasPermission(permission)) {
			ItemStack Helm = new ItemStack(Material.getMaterial(Helmet));
			ItemStack Chest = new ItemStack(Material.getMaterial(Chestplate));
			ItemStack Legs = new ItemStack(Material.getMaterial(Leggings));
			ItemStack Boot = new ItemStack(Material.getMaterial(Boots));
			Helm.addEnchantment(HEnchant, HLevel);
			Chest.addEnchantment(CEnchant, CLevel);
			Legs.addEnchantment(LEnchant, LLevel);
			Boot.addEnchantment(BEnchant, BLevel);
			player.getInventory().setHelmet(Helm);
			player.getInventory().setChestplate(Chest);
			player.getInventory().setChestplate(Legs);
			player.getInventory().setBoots(Boot);
		}
	}
	
	public void broadcastAdmin(String message) {
		for(Player player: this.getServer().getOnlinePlayers()) {
			if(player.hasPermission(BroadcastAdminPerm) || player.isOp()) {
				player.sendMessage(message);
			}
		}
	}
	
	public void broadcastUser(String message) {
		for(Player player: this.getServer().getOnlinePlayers()) {
			if(player.hasPermission(BroadcastAdminPerm) || player.isOp()) {
				player.sendMessage(message);
			}
			else {
				player.sendMessage(message);
			}
		}
	}
	
	public void broadcastAll(String message) {
		for(Player player: this.getServer().getOnlinePlayers()) {
			player.sendMessage(message);
		}
	}
	
	public void KickOnDelay(final String message, int ticks) {
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			

			@Override
			public void run() {
				for(Player player: plugin.getServer().getOnlinePlayers()) {
					if(!player.hasPermission(NoKickPerm) || !player.isOp()) {
						player.kickPlayer(message);
					}
				}
			}
		}, ticks);
	}
}
