package dev.dagger.atm.configuration.factory;

import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;
import dev.dagger.atm.configuration.module.UserCommandsModule;
import dev.dagger.atm.service.CommandRouter;
import dev.dagger.atm.service.Database;

@Subcomponent(modules = UserCommandsModule.class)
public interface UserCommandsRouter {
    CommandRouter router();

    @Subcomponent.Factory
    interface Factory {
        UserCommandsRouter create(@BindsInstance Database.Account account);
    }

    @Module(subcomponents = UserCommandsRouter.class)
    interface InstallationModule {
    }
}
