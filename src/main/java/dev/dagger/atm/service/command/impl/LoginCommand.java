package dev.dagger.atm.service.command.impl;

import dev.dagger.atm.configuration.factory.UserCommandsRouter;
import dev.dagger.atm.service.Database;
import dev.dagger.atm.service.Database.Account;
import dev.dagger.atm.service.Outputter;
import dev.dagger.atm.service.command.SingleArgCommand;

import javax.inject.Inject;

public final class LoginCommand extends SingleArgCommand {

    private final Outputter outputter;
    private final Database database;
    private final UserCommandsRouter.Factory userCommandsRouterFactory;

    @Inject
    public LoginCommand(Database database, Outputter outputter, UserCommandsRouter.Factory userCommandsRouterFactory) {
        this.database = database;
        this.outputter = outputter;
        this.userCommandsRouterFactory = userCommandsRouterFactory;
    }

    @Override
    protected Result handleArg(String username) {
        Account account = database.getAccount(username);
        outputter.output(String.format("%s is logged in with balance: %s", username, account.balance()));
        return Result.enterNestedCommandSet(userCommandsRouterFactory.create(account).router());
    }
}
