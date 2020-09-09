package dev.dagger.atm.configuration.module;

import dagger.Binds;
import dagger.Module;
import dev.dagger.atm.service.Command;
import dev.dagger.atm.service.impl.LoginCommand;

@Module
public abstract class LoginCommandModule {

    @Binds
    public abstract Command loginCommand(LoginCommand loginCommand);
}
