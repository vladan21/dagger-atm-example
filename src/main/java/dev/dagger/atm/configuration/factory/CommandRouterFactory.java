package dev.dagger.atm.configuration.factory;

import dagger.Component;
import dev.dagger.atm.configuration.module.LoginCommandModule;
import dev.dagger.atm.configuration.module.SystemOutModule;
import dev.dagger.atm.service.impl.CommandRouter;

@Component(modules = {LoginCommandModule.class, SystemOutModule.class})
public interface CommandRouterFactory {
    CommandRouter commandRouter();
}
