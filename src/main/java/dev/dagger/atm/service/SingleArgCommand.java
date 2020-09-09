package dev.dagger.atm.service;

public abstract class SingleArgCommand implements Command {

    protected abstract Status handleArg(String username);
}
