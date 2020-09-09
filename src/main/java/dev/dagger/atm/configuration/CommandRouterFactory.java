package dev.dagger.atm.configuration;

import dagger.Component;
import dev.dagger.atm.service.CommandRouter;

@Component
public interface CommandRouterFactory {
    CommandRouter commandRouter();
}
