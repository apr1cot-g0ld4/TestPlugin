package apr1cot.g0ld4.testPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // プラグインの起動処理
        getLogger().info("TestPluginが起動しました！");

        registerCommand("hello",(source, args) -> {
            String message = "こんにちは！";
            String name = source.getSender().getName();

            source.getSender().sendMessage(
                    Component.text(message + name + "さん！")
            );
        });

        registerCommand("whoami",(source, args) -> {
            String message = "あなたの名前は";
            String name = source.getSender().getName();

            source.getSender().sendMessage(
                    Component.text(message + name + "です！")
            );
        });

        registerCommand("test",(source, args) -> {
            String message = "テスト成功！";

            source.getSender().sendMessage(
                    Component.text(message)
            );
        });

        registerCommand("levelcheck",(source, args) -> {
            if (source.getSender() instanceof Player player) {
                int level = player.getLevel();
                if (level >= 10) {
                    player.sendMessage(
                            Component.text("入場できます！")
                    );
                 } else {
                    player.sendMessage(
                            Component.text("レベルが足りません！")
                    );
                }
        } else{
                source.getSender().sendMessage(
                        Component.text("プレイヤー専用コマンドです。")
                );
            }
        });

        registerCommand("healthcheck",(source, args) -> {
            if (source.getSender() instanceof Player player) {
                double health = player.getHealth();
                if (health >= 15){
                    player.sendMessage(
                            Component.text("元気です！")
                    );
                } else if (health >= 10){
                    player.sendMessage(
                            Component.text("少し体力が減っています！")
                    );
                } else {
                    player.sendMessage("回復しましょう！");
                }
            } else{
                source.getSender().sendMessage(
                        Component.text("プレイヤー専用コマンドです。")
                );
            }
        });
    }

    @Override
    public void onDisable() {
        // プラグインの終了処理
        getLogger().info("TestPluginが停止しました！");
    }
}
