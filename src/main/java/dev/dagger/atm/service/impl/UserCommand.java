package dev.dagger.atm.service.impl;

import dev.dagger.atm.service.Command;
import dev.dagger.atm.service.Database;
import dev.dagger.atm.service.Outputter;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

public class UserCommand implements Command {

    private final Database database;
    private final Outputter outputter;

    @Inject
    public UserCommand(Database database, Outputter outputter) {
        this.database = database;
        this.outputter = outputter;
    }

    @Override
    public Status handleInput(List<String> input) {
        if (input.size() != 2) {
            return Status.INVALID;
        }

        var account = database.getAccount(input.get(0));
        account.balance(new BigDecimal(input.get(1)));
        outputter.output(String.format("%s now has: %s", account.username(), account.balance()));
        return Status.HANDLED;
    }
}
