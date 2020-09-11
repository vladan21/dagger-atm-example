package dev.dagger.atm.service.command.impl;

import dev.dagger.atm.configuration.annotation.qualifier.MinimumBalance;
import dev.dagger.atm.service.Database;
import dev.dagger.atm.service.Outputter;
import dev.dagger.atm.service.WithdrawalLimiter;
import dev.dagger.atm.service.command.BigDecimalCommand;

import javax.inject.Inject;
import java.math.BigDecimal;

public final class WithdrawalCommand extends BigDecimalCommand {

    private final Outputter outputter;
    private final Database.Account account;
    private final BigDecimal minimumBalance;
    private final WithdrawalLimiter withdrawalLimiter;

    @Inject
    public WithdrawalCommand(Outputter outputter,
                             Database.Account account,
                             @MinimumBalance BigDecimal minimumBalance,
                             WithdrawalLimiter withdrawalLimiter) {
        super(outputter);
        this.outputter = outputter;
        this.account = account;
        this.minimumBalance = minimumBalance;
        this.withdrawalLimiter = withdrawalLimiter;
    }

    @Override
    protected void handleAmount(BigDecimal amount) {
        BigDecimal remainingWithdrawalLimit = withdrawalLimiter.getRemainingWithdrawalLimit();
        if (amount.compareTo(remainingWithdrawalLimit) > 0) {
            outputter.output(String.format("You may not withdraw %s; You may withdraw %s more in this session",
                    amount, remainingWithdrawalLimit));
            return;
        }

        BigDecimal newBalance = account.balance().subtract(amount);
        if (newBalance.compareTo(minimumBalance) < 0) {
            outputter.output(String.format("You don't have enough balance to withdraw %s", amount));
        } else {
            account.withdraw(amount);
            withdrawalLimiter.recordWithdrawal(amount);
            outputter.output(String.format("your new balance is: %s", account.balance()));
        }
    }
}
