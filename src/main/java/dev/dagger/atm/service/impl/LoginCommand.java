package dev.dagger.atm.service;

import static java.lang.String.format;

public final class LoginCommand extends SingleArgCommand {

    private Outputter outputter;

    public LoginCommand(Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    public String key() {
        return "login";
    }

    @Override
    protected Status handleArg(String username) {
        outputter.output(format("%s is logged in", username));
        return Status.HANDLED;
    }
}
