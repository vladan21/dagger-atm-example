package dev.dagger.atm.configuration.module;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import dev.dagger.atm.service.command.Command;
import dev.dagger.atm.service.command.impl.UserCommand;

@Module
public abstract class UserCommandsModule {

    @Binds
    @IntoMap
    @StringKey("deposit")
    public abstract Command userCommand(UserCommand userCommand);
}
