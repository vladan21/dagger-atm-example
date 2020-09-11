package dev.dagger.atm.service;

import dev.dagger.atm.configuration.annotation.qualifier.MaximumWithdrawal;
import dev.dagger.atm.configuration.annotation.scope.PerSession;

import javax.inject.Inject;
import java.math.BigDecimal;

@PerSession
public final class WithdrawalLimiter {
    private BigDecimal remainingWithdrawalLimit;

    @Inject
    public WithdrawalLimiter(@MaximumWithdrawal BigDecimal remainingWithdrawalLimit) {
        this.remainingWithdrawalLimit = remainingWithdrawalLimit;
    }

    public void recordWithdrawal(BigDecimal amount) {
        remainingWithdrawalLimit = remainingWithdrawalLimit.subtract(amount);
    }

    public BigDecimal getRemainingWithdrawalLimit() {
        return remainingWithdrawalLimit;
    }
}
