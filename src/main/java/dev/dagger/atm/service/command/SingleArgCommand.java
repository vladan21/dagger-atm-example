package dev.dagger.atm.service.command;

import dev.dagger.atm.configuration.Init;

import java.util.List;

public abstract class SingleArgCommand extends Init implements Command {

    protected abstract Result handleArg(String username);

    @Override
    public final Result handleInput(List<String> input) {
        return input.size() == 1 ? handleArg(input.get(0)) : Result.invalid();
    }
}
