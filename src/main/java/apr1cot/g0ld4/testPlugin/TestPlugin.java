package apr1cot.g0ld4.testPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import net.kyori.adventure.text.Component;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // プラグインの起動処理
        getLogger().info("TestPluginが起動しました！");

        registerCommand("hello",(source, args) -> {
            source.getSender().sendMessage(
                    Component.text("こんにちは！")
            );
        });
    }

    @Override
    public void onDisable() {
        // プラグインの終了処理
        getLogger().info("TestPluginが停止しました！");
    }
}
