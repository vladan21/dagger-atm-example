package dev.dagger.atm.service.impl;

import dev.dagger.atm.service.Command;

public abstract class SingleArgCommand implements Command {

    protected abstract Status handleArg(String arg);

}
