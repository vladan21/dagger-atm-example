package dev.dagger.atm.configuration.module;

import dagger.Module;
import dagger.Provides;
import dev.dagger.atm.configuration.annotation.qualifier.MaximumWithdrawal;
import dev.dagger.atm.configuration.annotation.qualifier.MinimumBalance;

import java.math.BigDecimal;

@Module
public abstract class AmountsModule {

    @Provides
    @MinimumBalance
    public static BigDecimal minimumBalance() {
        return BigDecimal.ZERO;
    }

    @Provides
    @MaximumWithdrawal
    public static BigDecimal maximumWithdrawal() {
        return new BigDecimal(1000);
    }
}
