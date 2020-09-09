package dev.dagger.atm.service.impl;

import dev.dagger.atm.service.Database;
import dev.dagger.atm.service.Database.Account;
import dev.dagger.atm.service.Outputter;
import dev.dagger.atm.service.SingleArgCommand;

import javax.inject.Inject;
import java.util.List;

public final class LoginCommand extends SingleArgCommand {

    private final Outputter outputter;
    private final Database database;

    @Inject
    public LoginCommand(Database database, Outputter outputter) {
        this.database = database;
        this.outputter = outputter;
    }

    @Override
    public String key() {
        return "login";
    }

    @Override
    protected Status handleArg(String username) {
        Account account = database.getAccount(username);
        outputter.output(String.format("%s is logged in with balance %s", username, account.balance()));
        return Status.HANDLED;
    }

    @Override
    public Status handleInput(List<String> input) {
        return input.size() == 1 ? handleArg(input.get(0)) : Status.INVALID;
    }
}
