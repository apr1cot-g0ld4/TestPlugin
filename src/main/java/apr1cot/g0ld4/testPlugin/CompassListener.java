
package apr1cot.g0ld4.testPlugin;

import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public final class CompassListener implements Listener {

    private final NamespacedKey key;

    public CompassListener(TestPlugin plugin) {
        this.key = new NamespacedKey(plugin, "guide_compass");
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        if (event.getHand() != EquipmentSlot.HAND) {
            return;
        }

        if (event.getAction() != Action.RIGHT_CLICK_AIR
                && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        ItemStack item = event.getItem();

        if (item == null || item.getType() != Material.COMPASS) {
            return;
        }

        if (!item.getPersistentDataContainer().has(
                key, PersistentDataType.INTEGER)) {
            return;
        }

        Player player = event.getPlayer();
        Location location = player.getLocation();

        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();

        player.sendMessage(
                Component.text(
                        "現在地：X=" + x
                        + " Y=" + y
                        + " Z=" + z)
        );
    }
}
