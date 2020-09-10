package dev.dagger.atm.service.command;

import dev.dagger.atm.service.command.Command;

import java.util.List;

public abstract class SingleArgCommand implements Command {

    protected abstract Result handleArg(String username);

    @Override
    public final Result handleInput(List<String> input) {
        return input.size() == 1 ? handleArg(input.get(0)) : Result.invalid();
    }
}
