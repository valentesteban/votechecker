package me.joesvart.votechecker;

import me.joesvart.votechecker.file.YamlFile;
import me.joesvart.votechecker.service.Service;
import me.joesvart.votechecker.service.impl.ListenerService;
import me.yushust.inject.AbstractModule;

import java.util.HashSet;
import java.util.Set;

public class VoteCheckerModule
        extends AbstractModule {

    private final VoteChecker voteChecker;

    public VoteCheckerModule(VoteChecker voteChecker) {
        this.voteChecker = voteChecker;
    }

    @Override
    protected void configure() {
        YamlFile config = new YamlFile(voteChecker, "config");

        bind(YamlFile.class)
                .toInstance(config);
        bind(YamlFile.class)
                .named("lang_es")
                .toInstance(new YamlFile(voteChecker, "lang/lang_es"));
        bind(YamlFile.class)
                .named("lang_en")
                .toInstance(new YamlFile(voteChecker, "lang/lang_en"));

        multibind(Service.class)
                .asCollection(Set.class, HashSet::new)
                .to(ListenerService.class)
                .singleton();

        bind(VoteChecker.class).toInstance(voteChecker);
    }
}
