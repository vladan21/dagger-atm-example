package dev.dagger.atm.service.command.impl;

import dev.dagger.atm.service.command.Command;
import dev.dagger.atm.service.Database;
import dev.dagger.atm.service.Outputter;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

public final class UserCommand implements Command {

    private final Outputter outputter;
    private final Database database;

    @Inject
    public UserCommand(Database database, Outputter outputter) {
        this.database = database;
        this.outputter = outputter;
    }

    @Override
    public Result handleInput(List<String> input) {
        if (input.size() != 2) {
            return Result.invalid();
        }

        var account = database.getAccount(input.get(0));
        account.balance(new BigDecimal(input.get(1)));
        outputter.output(String.format("%s now has: %s", account.username(), account.balance()));
        return Result.handled();
    }
}
