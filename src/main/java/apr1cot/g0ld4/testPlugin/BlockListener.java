package apr1cot.g0ld4.testPlugin;

import net.kyori.adventure.text.Component;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public final class BlockListener implements Listener {

    @EventHandler(
            priority = EventPriority.MONITOR,
            ignoreCancelled = true
    )
    public void onBlockBreak(BlockBreakEvent event) {

        event.getPlayer().sendMessage(
                Component.text(
                        "破壊したブロック："
                                + event.getBlock().getType().name()
                )
        );
    }

    @EventHandler(
            priority = EventPriority.MONITOR,
            ignoreCancelled = true
    )
    public void onBlockPlace(BlockPlaceEvent event) {

        event.getPlayer().sendMessage(
                Component.text(
                        "設置したブロック："
                                + event.getBlockPlaced().getType().name()
                )
        );
    }
}