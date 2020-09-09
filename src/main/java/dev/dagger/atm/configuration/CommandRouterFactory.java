package dev.dagger.atm.configuration;

import dagger.Component;
import dev.dagger.atm.configuration.module.HelloWorldModule;
import dev.dagger.atm.service.CommandRouter;

@Component(modules = HelloWorldModule.class)
public interface CommandRouterFactory {
    CommandRouter commandRouter();
}
