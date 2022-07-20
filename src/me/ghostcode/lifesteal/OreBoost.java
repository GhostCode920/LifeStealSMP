package me.ghostcode.lifesteal;

import me.ghostcode.lifesteal.versionsupport.Version;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;

final class OreBoost implements Listener {
	
	@EventHandler
	public void onDrop(BlockDropItemEvent e) {
		if(!isOre(e.getBlockState().getType())) return;
		
		for(Item i : e.getItems())
			if(isValuable(i.getItemStack().getType()))
				i.getItemStack().setAmount(i.getItemStack().getAmount()*LifeSteal.getInstance().oreBoost());
	}
	
	private boolean isOre(Material m) {
		return  m == Material.COAL_ORE || 
				m == Material.DIAMOND_ORE ||
				m == Material.EMERALD_ORE ||
				(!LifeSteal.getInstance().ironAndGoldPrevent()[1] && m == Material.GOLD_ORE) ||
				(!LifeSteal.getInstance().ironAndGoldPrevent()[0] && m == Material.IRON_ORE) ||
				m == Material.LAPIS_ORE ||
				m == Material.REDSTONE_ORE ||
				m == Material.NETHER_QUARTZ_ORE ||
				(Version.isOrAbove(160) && m == Material.NETHER_GOLD_ORE);
				// and i have to add copper, not rn
	}
	
	private boolean isValuable(Material m) {
		return  m == Material.COAL ||
				m == Material.DIAMOND ||
				m == Material.EMERALD ||
				m == Material.GOLD_ORE ||
				m == Material.IRON_ORE ||
				m == Material.LAPIS_LAZULI ||
				m == Material.REDSTONE ||
				m == Material.QUARTZ ||
				(Version.isOrAbove(160) && m == Material.GOLD_NUGGET);
				// and still copper, not rn
	}

}
