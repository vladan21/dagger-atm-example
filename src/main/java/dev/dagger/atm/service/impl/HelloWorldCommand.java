package dev.dagger.atm.service;

import javax.inject.Inject;
import java.util.List;

public final class HelloWorldCommand implements Command {

    @Inject
    public HelloWorldCommand() {
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
        System.out.println("world!");
        return Status.HANDLED;
    }
}
