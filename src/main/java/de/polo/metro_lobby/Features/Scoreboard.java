package de.polo.metro_lobby.Features;

import de.polo.metro_lobby.Utils.PlayerManager;
import de.polo.metro_lobby.Utils.ScoreboardBuilder;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import de.polo.metro_lobby.Main;

public class Scoreboard extends ScoreboardBuilder {

    private int socialId;

    public Scoreboard(Player player) {
        super(player, ChatColor.RED.toString() + ChatColor.BOLD + "  METRO  ");
        socialId = 0;

        run();
    }

    @Override
    public void createScoreboard() {
        setScore("test", 9);
        setScore(ChatColor.DARK_GRAY.toString(), 8);
        setScore(ChatColor.GRAY + "Spielzeit" + ChatColor.DARK_GRAY + ":", 7);
        setScore(ChatColor.DARK_GRAY + "➥ " + ChatColor.GRAY + PlayerManager.playtime + "h", 6);
        setScore(ChatColor.GRAY.toString(), 5);
        setScore(ChatColor.YELLOW + "Coins" + ChatColor.DARK_GRAY + ":", 4);
        setScore(ChatColor.DARK_GRAY + "➥" + ChatColor.YELLOW + " " + PlayerManager.coins, 3);
        setScore(ChatColor.RED.toString(), 2);
        setScore(ChatColor.DARK_PURPLE + "metro.com/shop", 1);
        setScore(ChatColor.AQUA.toString(), 0);
    }

    @Override
    public void update() {

    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {

                switch (socialId) {
                    case 0:
                        setScore(ChatColor.AQUA + "twitter.com/metro", 1);
                        break;
                    case 1:
                        setScore(ChatColor.DARK_PURPLE + "metro.com/shop", 1);
                        break;
                    case 2:
                        setScore(ChatColor.DARK_RED + "youtube.com/metro", 1);
                        break;
                }

                socialId++;

                if(socialId >= 3) {
                    socialId = 0;
                }

            }
        }.runTaskTimer(Main.getInstance(), 20, 1120);
    }
}