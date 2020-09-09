package dev.dagger.atm.service.impl;

import dev.dagger.atm.service.Command;
import dev.dagger.atm.service.Outputter;

import javax.inject.Inject;
import java.util.List;

public final class HelloWorldCommand implements Command {

    private final Outputter outputter;

    @Inject
    public HelloWorldCommand(Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    public String key() {
        return "hello";
    }

    @Override
    public Status handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Status.INVALID;
        }
        outputter.output("world!");
        return Status.HANDLED;
    }
}
