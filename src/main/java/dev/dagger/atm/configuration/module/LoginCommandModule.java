package dev.dagger.atm.configuration.module;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import dev.dagger.atm.service.Command;
import dev.dagger.atm.service.impl.LoginCommand;

@Module
public abstract class LoginCommandModule {

    @Binds
    @IntoMap
    @StringKey("login")
    public abstract Command loginCommand(LoginCommand loginCommand);
}
