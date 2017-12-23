package arraylist;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
	
	private  ArrayList<String> playerlist = new ArrayList<String>();
	
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this,this);
	}

	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender sender,Command cmd,String cmdlablem,String[] args){
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "請使用玩家身分輸入");
			return true;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("frozen")){
			if(args.length == 1){
				playerlist.add(args[0]);
				player.sendMessage(ChatColor.RED + args[0] + "已被凍結！");
				return true;
			}
			
		}
		if(cmd.getName().equalsIgnoreCase("unfrozen")){
			if(args.length == 1){
				if(playerlist.contains(args[0]))
				playerlist.remove(args[0]);
				player.sendMessage(ChatColor.RED + args[0] + "已解除凍結！");
				return true;
			}
		}
		return true;							
	}
	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent evt){
		if(playerlist.contains(evt.getPlayer().getName())){
			evt.setCancelled(true);
		}
		
	}
}
	
