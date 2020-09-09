package dev.dagger.atm.configuration;

import dagger.Component;
import dev.dagger.atm.configuration.module.SystemOutModule;
import dev.dagger.atm.service.impl.CommandRouter;

@Component(modules = {SystemOutModule.class})
public interface CommandRouterFactory {
    CommandRouter commandRouter();
}
