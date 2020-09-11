package dev.dagger.atm.configuration.factory;

import dagger.Component;
import dev.dagger.atm.configuration.module.AmountsModule;
import dev.dagger.atm.configuration.module.LoginCommandModule;
import dev.dagger.atm.configuration.module.SystemOutModule;
import dev.dagger.atm.service.CommandProcessor;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        LoginCommandModule.class,
        SystemOutModule.class,
        UserCommandsRouter.InstallationModule.class,
        AmountsModule.class})
public interface CommandProcessorFactory {
    CommandProcessor commandProcessor();
}
