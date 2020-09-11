package dev.dagger.atm.configuration;

public abstract class Init {

    public Init() {
        System.out.printf("Init: %s\n", this.getClass());
    }
}
