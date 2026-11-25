package apr1cot.g0ld4.testPlugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public final class QuitListener implements Listener{

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String name = player.getName();

        player.sendMessage(
                Component.text(
                        name + "さんが退出しました。",
                        NamedTextColor.RED
                )
        );
    }
}
