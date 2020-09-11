package dev.dagger.atm.service.command.impl;

import dev.dagger.atm.configuration.qualifiers.MaximumWithdrawn;
import dev.dagger.atm.configuration.qualifiers.MinimumBalance;
import dev.dagger.atm.service.Database;
import dev.dagger.atm.service.Outputter;
import dev.dagger.atm.service.command.BigDecimalCommand;

import javax.inject.Inject;
import java.math.BigDecimal;

public final class WithdrawnCommand extends BigDecimalCommand {

    private final Outputter outputter;
    private final Database.Account account;
    private final BigDecimal minimumBalance;
    private final BigDecimal maximumWithdrawal;

    @Inject
    public WithdrawnCommand(Outputter outputter,
                            Database.Account account,
                            @MinimumBalance BigDecimal minimumBalance,
                            @MaximumWithdrawn BigDecimal maximumWithdrawal) {
        super(outputter);
        this.outputter = outputter;
        this.account = account;
        this.minimumBalance = minimumBalance;
        this.maximumWithdrawal = maximumWithdrawal;
    }

    @Override
    protected void handleAmount(BigDecimal amount) {
        if (amount.compareTo(maximumWithdrawal) > 0) {
            outputter.output(String.format("You cannot withdraw more than %s", maximumWithdrawal));
            return;
        }

        BigDecimal newBalance = account.balance().subtract(amount);
        if (newBalance.compareTo(minimumBalance) < 0) {
            outputter.output(String.format("You don't have enough balance to withdraw %s", amount));
        } else {
            account.withdraw(amount);
            outputter.output(String.format("your new balance is: %s", account.balance()));
        }
    }
}
