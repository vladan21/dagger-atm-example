package dev.dagger.atm.configuration.module;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import dev.dagger.atm.service.Command;
import dev.dagger.atm.service.impl.HelloWorldCommand;

@Module
public abstract class HelloWorldModule {

    @Binds
    @IntoMap
    @StringKey("hello")
    abstract Command helloWorldCommand(HelloWorldCommand helloWorldCommand);
}
