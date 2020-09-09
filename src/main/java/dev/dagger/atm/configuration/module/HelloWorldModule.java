package dev.dagger.atm.configuration.module;

import dagger.Binds;
import dagger.Module;
import dev.dagger.atm.service.Command;
import dev.dagger.atm.service.HelloWorldCommand;

@Module
public abstract class HelloWorldModule {

    @Binds
    abstract Command helloWorldCommand(HelloWorldCommand helloWorldCommand);
}
