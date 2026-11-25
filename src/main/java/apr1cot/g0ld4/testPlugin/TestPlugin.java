package apr1cot.g0ld4.testPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // プラグインの起動処理
        getLogger().info("TestPluginが起動しました！");

        //コマンド
        registerCommand("hello", (source, args) -> {
            String message = "こんにちは！";
            String name = source.getSender().getName();

            source.getSender().sendMessage(
                    Component.text(message + name + "さん！")
            );
        });

        //コマンド
        registerCommand("whoami", (source, args) -> {
            String message = "あなたの名前は";
            String name = source.getSender().getName();

            source.getSender().sendMessage(
                    Component.text(message + name + "です！")
            );
        });

        //コマンド
        registerCommand("test", (source, args) -> {
            String message = "テスト成功！";

            source.getSender().sendMessage(
                    Component.text(message)
            );
        });

        //コマンド
        registerCommand("levelcheck", (source, args) -> {
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
            } else {
                source.getSender().sendMessage(
                        Component.text("プレイヤー専用コマンドです。")
                );
            }
        });

        //コマンド
        registerCommand("healthcheck", (source, args) -> {
            if (source.getSender() instanceof Player player) {
                double health = player.getHealth();
                if (health >= 15) {
                    player.sendMessage(
                            Component.text("元気です！")
                    );
                } else if (health >= 10) {
                    player.sendMessage(
                            Component.text("少し体力が減っています！")
                    );
                } else {
                    player.sendMessage("回復しましょう！");
                }
            } else {
                source.getSender().sendMessage(
                        Component.text("プレイヤー専用コマンドです。")
                );
            }
        });

        //コマンド
        registerCommand("greet", (source, args) -> {

            if (args.length != 1) {
                source.getSender().sendMessage(
                        Component.text("使い方：/greet <名前>")
                );
                return;
            }

            String name = args[0];

            source.getSender().sendMessage(
                    Component.text("こんにちは、" + name + "さん！")
            );
        });

        //コマンド
        registerCommand("playerinfo",(source,args) -> {
            if (args.length != 1){
                source.getSender().sendMessage(
                        Component.text("使い方：/playerinfo <名前>")
                );
                return;
            }

            //プレイヤーの取得
            Player target = Bukkit.getPlayerExact(args[0]);

            //プレイヤーの存在確認
            if (target == null) {
                source.getSender().sendMessage(
                        Component.text("プレイヤーが見つかりません。")
                );
                return;
            }
            //プレイヤーの情報取得
            String name = target.getName();
            int level = target.getLevel();
            double health = target.getHealth();
            int food = target.getFoodLevel();
            boolean op = target.isOp();

            //プレイヤーの情報の表示
            source.getSender().sendMessage(
                    Component.text("===== プレイヤー情報 =====")
            );
            source.getSender().sendMessage(
                    Component.text("名前：" + name)
            );
            source.getSender().sendMessage(
                    Component.text("レベル：" + level)
            );
            source.getSender().sendMessage(
                    Component.text("体力：" + health)
            );
            source.getSender().sendMessage(
                    Component.text("満腹度：" + food)
            );
            source.getSender().sendMessage(
                    Component.text("OP権限：" + op)
            );
        });
        registerCommand("add", (source, args) -> {
            if (args.length != 2) {
                source.getSender().sendMessage(
                        Component.text("使い方：/add 数値1 数値2")
                );
                return;
            }
            try {
                int a = Integer.parseInt(args[0]);
                int b = Integer.parseInt(args[1]);

                int result = Math.addExact(a,b);

                source.getSender().sendMessage(
                        Component.text("計算結果：" + result)
                );
            } catch (NumberFormatException e) {
                source.getSender().sendMessage(
                        Component.text("整数を入力してください。")
                );
            } catch (ArithmeticException e) {
                source.getSender().sendMessage(
                        Component.text("計算結果が大きすぎるか、小さすぎます。")
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
