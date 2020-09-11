package dev.dagger.atm.service.command.impl;

import dev.dagger.atm.service.Database;
import dev.dagger.atm.service.Outputter;
import dev.dagger.atm.service.command.BigDecimalCommand;

import javax.inject.Inject;
import java.math.BigDecimal;

public final class DepositCommand extends BigDecimalCommand {

    private final Outputter outputter;
    private final Database.Account account;

    @Inject
    public DepositCommand(Outputter outputter, Database.Account account) {
        super(outputter);
        this.outputter = outputter;
        this.account = account;
    }

    @Override
    protected void handleAmount(BigDecimal amount) {
        account.balance(amount);
        outputter.output(String.format("%s now has: %s", account.username(), account.balance()));
    }
}
