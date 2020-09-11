package dev.dagger.atm.service;

import dev.dagger.atm.configuration.Init;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class Database extends Init {

    Map<String, Account> accounts = new HashMap<>();

    @Inject
    public Database() {
    }

    public Account getAccount(String username) {
        return accounts.computeIfAbsent(username, Account::new);
    }

    public static final class Account {
        BigDecimal balance = BigDecimal.ZERO;
        final String userName;

        Account(String userName) {
            this.userName = userName;
        }

        public String username() {
            return userName;
        }

        public BigDecimal balance() {
            return balance;
        }

        public void balance(BigDecimal balance) {
            this.balance = balance;
        }

    }
}
