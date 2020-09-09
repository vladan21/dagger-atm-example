package dev.dagger.atm.service.impl;

import dev.dagger.atm.service.Outputter;
import dev.dagger.atm.service.SingleArgCommand;

import javax.inject.Inject;
import java.util.List;

public final class LoginCommand extends SingleArgCommand {

    private final Outputter outputter;

    @Inject
    public LoginCommand(Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    public String key() {
        return "login";
    }

    @Override
    protected Status handleArg(String username) {
        outputter.output(String.format("%s is logged in", username));
        return Status.HANDLED;
    }

    @Override
    public Status handleInput(List<String> input) {
        return input.size() == 1 ? handleArg(input.get(0)) : Status.INVALID;
    }
}
