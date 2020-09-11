package dev.dagger.atm.configuration.module;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import dev.dagger.atm.service.command.Command;
import dev.dagger.atm.service.command.impl.DepositCommand;
import dev.dagger.atm.service.command.impl.WithdrawnCommand;

@Module
public abstract class UserCommandsModule {

    @Binds
    @IntoMap
    @StringKey("deposit")
    public abstract Command depositCommand(DepositCommand depositCommand);

    @Binds
    @IntoMap
    @StringKey("withdraw")
    public abstract Command withdrawCommand(WithdrawnCommand depositCommand);
}
