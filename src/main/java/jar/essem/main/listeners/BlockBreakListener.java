package jar.essem.main.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class BlockBreakListener implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Location location = event.getBlock().getLocation();
		location.setX(location.getX() + 0.5);
		location.setZ(location.getZ() + 0.5);

		EntityType[] entities = EntityType.values();

		Random random = new Random();
		int i = random.nextInt(entities.length - 1);

		location.getWorld().spawnEntity(location, entities[i]);
	}

	@EventHandler
	public void onChickenSpawn(EntitySpawnEvent event) {

	}

	@EventHandler
	public void onDrop(EntityDeathEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof Enderman) {
			Location location = entity.getLocation();
			World world = location.getWorld();
			world.dropItemNaturally(location, new ItemStack(Material.ENDER_PEARL, 2048));
		}
		if (entity instanceof Blaze) {
			Location location = entity.getLocation();
			World world = location.getWorld();
			world.dropItemNaturally(location, new ItemStack(Material.BLAZE_ROD, 2048));
		}
	}
}
