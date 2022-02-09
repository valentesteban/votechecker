package me.joesvart.votechecker;

import me.joesvart.votechecker.service.Service;
import me.yushust.inject.Injector;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;
import java.util.Set;

public final class VoteChecker
        extends JavaPlugin {

    @Inject
    private Set<Service> services;

    @Override
    public void onLoad() {
        Injector.create(new VoteCheckerModule(this))
                .injectMembers(this);
    }

    @Override
    public void onEnable() {

        for (Service service : services) {
            service.start();
        }
    }

    @Override
    public void onDisable() {
        for (Service service : services) {
            service.stop();
        }
    }
}
