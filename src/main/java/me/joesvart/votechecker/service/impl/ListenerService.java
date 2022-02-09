package me.joesvart.votechecker.service.impl;

import me.joesvart.votechecker.VoteChecker;
import me.joesvart.votechecker.listener.PlayerJoinListener;
import me.joesvart.votechecker.service.Service;
import me.yushust.inject.InjectAll;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

@InjectAll
public class ListenerService
        implements Service {

    private VoteChecker voteChecker;

    private PlayerJoinListener playerJoinListener;

    @Override
    public void start() {
        registerListeners(
                playerJoinListener
        );
    }

    private void registerListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, voteChecker);
        }
    }
}
