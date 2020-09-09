package dev.dagger.atm.configuration.module;

import dagger.Module;
import dagger.Provides;
import dev.dagger.atm.service.Outputter;

@Module
public abstract class SystemOutModule {

    @Provides
    public static Outputter textOutputter() {
        return System.out::println;
    }
}
