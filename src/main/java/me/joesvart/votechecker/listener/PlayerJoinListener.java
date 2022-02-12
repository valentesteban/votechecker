package me.joesvart.votechecker.listener;

import me.joesvart.votechecker.VoteChecker;
import me.joesvart.votechecker.file.YamlFile;
import me.joesvart.votechecker.website.WebsiteResponse;
import me.yushust.inject.InjectAll;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import javax.inject.Named;

import static me.joesvart.votechecker.util.ChatUtil.translate;

@InjectAll
public class PlayerJoinListener
        implements Listener {

    private VoteChecker voteChecker;

    @Named("lang_es")
    private YamlFile lang_es;
    @Named("lang_en")
    private YamlFile lang_en;

    private YamlFile config;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        String link = config.getString("namemc-link");
        String ip = config.getString("server-ip");

        WebsiteResponse.getResponse(voteChecker, "https://api.namemc.com/server/" + ip + "/votes?profile=" + player.getUniqueId(),
                response -> {
                    switch (response) {
                        case "false":
                            if (config.getString("lang").equals("en")) {
                                for (String noVoteMessage : lang_en.getStringList("messages.player-no-vote")) {
                                    player.sendMessage(translate(noVoteMessage)
                                            .replace("$player", player.getName())
                                            .replace("$link", link));
                                }
                            } else {
                                for (String noVoteMessage : lang_es.getStringList("mensajes.jugador-no-ha-votado")) {
                                    player.sendMessage(translate(noVoteMessage)
                                            .replace("$jugador", player.getName())
                                            .replace("$link", link));
                                }
                            }

                            break;
                        case "true":
                            if (config.getString("lang").equals("en")) {
                                for (String voteMessage : lang_en.getStringList("messages.player-vote")) {
                                    player.sendMessage(translate(voteMessage)
                                            .replace("$player", player.getName())
                                            .replace("$heart", "❤"));
                                }
                            } else {
                                for (String voteMessage : lang_es.getStringList("mensajes.jugador-ha-votado")) {
                                    player.sendMessage(translate(voteMessage)
                                            .replace("$jugador", player.getName())
                                            .replace("$corazon", "❤"));
                                }
                            }

                            break;
                    }
                }
        );
    }
}
