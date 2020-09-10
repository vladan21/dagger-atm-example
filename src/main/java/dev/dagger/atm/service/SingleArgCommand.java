package dev.dagger.atm.service;

import java.util.List;

public abstract class SingleArgCommand implements Command {

    protected abstract Status handleArg(String username);

    @Override
    public final Status handleInput(List<String> input) {
        return input.size() == 1 ? handleArg(input.get(0)) : Status.INVALID;
    }
}
