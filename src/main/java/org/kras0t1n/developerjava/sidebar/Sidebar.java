package org.kras0t1n.developerjava.sidebar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class Sidebar {

    private Player player;
    private Scoreboard scoreboard;
    private Objective objective;

    public Sidebar(Player player, String displayName) {
        this.player = player;

        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        this.scoreboard = scoreboardManager.getNewScoreboard();

        this.objective = scoreboard.registerNewObjective("sidebar", "dummy");
        this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
    }

    public void setLine(int line, String text) {
        if (line < 0 || line > 15) {
            throw new IllegalArgumentException("Line index must be between 0 and 15");
        }

        Team team = scoreboard.getTeam("line_" + line);
        if (team == null) {
            team = scoreboard.registerNewTeam("line_" + line);
            objective.getScoreboard().resetScores("§" + Integer.toHexString(line));
        }

        team.addEntry("§" + Integer.toHexString(line));
        team.setPrefix(text);
    }

    public void show() {
        player.setScoreboard(scoreboard);
    }

    public void hide() {
        player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
    }

    public void showTo(Player player) {
        player.setScoreboard(scoreboard);
    }
}
