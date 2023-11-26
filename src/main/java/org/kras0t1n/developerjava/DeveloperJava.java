package org.kras0t1n.developerjava;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.kras0t1n.developerjava.sidebar.Sidebar;

public final class DeveloperJava extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {
    }
    public class PlayerJoinListener implements Listener {

        @EventHandler
        public void onPlayerJoin(PlayerJoinEvent event) {
            Player player = event.getPlayer();

            // Создание и отображение при подключении игрока
            Sidebar sidebar = new Sidebar(player, "My Sidebar");
            sidebar.setLine(0, "Text: 10");
            sidebar.showTo(player);
        }
    }
}