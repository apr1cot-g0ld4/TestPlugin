package apr1cot.g0ld4.testPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import net.kyori.adventure.text.Component;

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
    }

    @Override
    public void onDisable() {
        // プラグインの終了処理
        getLogger().info("TestPluginが停止しました！");
    }
}
