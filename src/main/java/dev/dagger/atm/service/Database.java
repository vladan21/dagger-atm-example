package dev.dagger.atm.service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Database {

    Map<String, Account> accounts = new HashMap<>();

    @Inject
    public Database() {
    }

    public Account getAccount(String username) {
        return accounts.computeIfAbsent(username, Account::new);
    }

    public static final class Account {
        final BigDecimal balance = BigDecimal.ZERO;
        final String userName;

        Account(String userName) {
            this.userName = userName;
        }

        public String username() {
            return userName;
        }

        public
        BigDecimal balance() {
            return balance;
        }
    }
}
