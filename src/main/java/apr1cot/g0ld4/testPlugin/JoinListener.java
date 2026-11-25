package apr1cot.g0ld4.testPlugin;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import net.kyori.adventure.text.format.NamedTextColor;

public final class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String name = player.getName();

        player.sendMessage(
                Component.text(
                        "ようこそ、" + name + "さん！",
                        NamedTextColor.GREEN
                )
        );
    }
}
