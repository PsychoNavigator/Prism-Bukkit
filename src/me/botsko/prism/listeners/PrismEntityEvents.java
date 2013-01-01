package me.botsko.prism.listeners;

import me.botsko.prism.Prism;
import me.botsko.prism.actions.EntityKillAction;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class PrismEntityEvents implements Listener {

	/**
	 * 
	 */
	private Prism plugin;
	
	
	/**
	 * 
	 * @param plugin
	 */
	public PrismEntityEvents( Prism plugin ){
		this.plugin = plugin;
	}

	
	/**
	 * 
	 * @param event
	 */
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void onEntityDeath(EntityDeathEvent event) {

		Entity entity = event.getEntity();
		
		// Mob Death
		if(!(entity instanceof Player)){
			if(entity.getLastDamageCause() instanceof EntityDamageByEntityEvent){
				
				// Mob killed by player
				EntityDamageByEntityEvent entityDamageByEntityEvent = (EntityDamageByEntityEvent) entity.getLastDamageCause();
				if(entityDamageByEntityEvent.getDamager() instanceof Player){
					
					Player player = (Player) entityDamageByEntityEvent.getDamager();
					plugin.actionsRecorder.addToQueue( new EntityKillAction("entity-kill", entity, player.getName()) );
		        	
				}
				// Mob shot by an arrow
				else if(entityDamageByEntityEvent.getDamager() instanceof Arrow){
					Arrow arrow = (Arrow) entityDamageByEntityEvent.getDamager();
					if(arrow.getShooter() instanceof Player){
						
						Player player = (Player) arrow.getShooter();
						plugin.actionsRecorder.addToQueue( new EntityKillAction("entity-kill", entity, player.getName()) );
			        	
					}
				}
			}
		} else {
			
		// Player death
			
//			Player p = (Player)event.getEntity();
//			Player attacker = p.getKiller();
			
		}
	}
}