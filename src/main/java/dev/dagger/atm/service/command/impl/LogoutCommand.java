package dev.dagger.atm.service.command.impl;

import dev.dagger.atm.service.command.Command;

import javax.inject.Inject;
import java.util.List;

public final class LogoutCommand implements Command {

    @Inject
    public LogoutCommand() {
    }

    @Override
    public Result handleInput(List<String> input) {
        return input.isEmpty() ? Result.inputCompleted() : Result.invalid();
    }
}
