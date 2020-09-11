package dev.dagger.atm.service.command.impl;

import dev.dagger.atm.configuration.factory.UserCommandsRouter;
import dev.dagger.atm.service.Database;
import dev.dagger.atm.service.Database.Account;
import dev.dagger.atm.service.Outputter;
import dev.dagger.atm.service.command.SingleArgCommand;

import javax.inject.Inject;
import java.util.Optional;

public final class LoginCommand extends SingleArgCommand {

    private final Outputter outputter;
    private final Database database;
    private final UserCommandsRouter.Factory userCommandsRouterFactory;
    private final Optional<Database.Account> account;

    @Inject
    public LoginCommand(Database database,
                        Outputter outputter,
                        UserCommandsRouter.Factory userCommandsRouterFactory,
                        Optional<Database.Account> account) {
        this.database = database;
        this.outputter = outputter;
        this.userCommandsRouterFactory = userCommandsRouterFactory;
        this.account = account;
    }

    @Override
    protected Result handleArg(String username) {
        if (account.isPresent()) {
            // Ignore "login <foo>" commands if we already have an account
            return Result.handled();
        }
        Account account = database.getAccount(username);
        outputter.output(String.format("%s is logged in with balance: %s", username, account.balance()));
        return Result.enterNestedCommandSet(userCommandsRouterFactory.create(account).router());
    }
}
