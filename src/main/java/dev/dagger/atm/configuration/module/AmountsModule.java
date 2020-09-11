package dev.dagger.atm.configuration.module;

import dagger.Module;
import dagger.Provides;
import dev.dagger.atm.configuration.qualifiers.MaximumWithdrawn;
import dev.dagger.atm.configuration.qualifiers.MinimumBalance;

import java.math.BigDecimal;

@Module
public abstract class AmountsModule {

    @Provides
    @MinimumBalance
    public static BigDecimal minimumBalance() {
        return BigDecimal.ZERO;
    }

    @Provides
    @MaximumWithdrawn
    public static BigDecimal maximumWithdrawn() {
        return new BigDecimal(1000);
    }
}
