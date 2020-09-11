package dev.dagger.atm.configuration.module;

import dagger.Binds;
import dagger.BindsOptionalOf;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import dev.dagger.atm.service.Database;
import dev.dagger.atm.service.command.Command;
import dev.dagger.atm.service.command.impl.LoginCommand;

@Module
public abstract class LoginCommandModule {

    @Binds
    @IntoMap
    @StringKey("login")
    public abstract Command loginCommand(LoginCommand loginCommand);

    @BindsOptionalOf
    public abstract Database.Account optionalAccount();
}
