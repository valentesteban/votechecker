package me.joesvart.votechecker.service.impl;

import me.joesvart.votechecker.VoteChecker;
import me.joesvart.votechecker.listener.PlayerJoinListener;
import me.joesvart.votechecker.service.Service;
import me.yushust.inject.InjectAll;

@InjectAll
public class ListenerService
        implements Service {

    private VoteChecker voteChecker;

    private PlayerJoinListener playerJoinListener;

    @Override
    public void start() {
        // used this method cause is only one listener
        voteChecker
                .getServer()
                .getPluginManager()
                .registerEvents(playerJoinListener, voteChecker);
    }
}
