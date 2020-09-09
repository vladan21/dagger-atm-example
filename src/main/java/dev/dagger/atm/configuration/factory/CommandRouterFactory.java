package dev.dagger.atm.configuration.factory;

import dagger.Component;
import dev.dagger.atm.configuration.module.LoginCommandModule;
import dev.dagger.atm.configuration.module.SystemOutModule;
import dev.dagger.atm.configuration.module.UserCommandsModule;
import dev.dagger.atm.service.impl.CommandRouter;

import javax.inject.Singleton;

@Singleton
@Component(modules = {LoginCommandModule.class, UserCommandsModule.class,
        SystemOutModule.class})
public interface CommandRouterFactory {
    CommandRouter commandRouter();
}
