package dev.dagger.atm;

import dev.dagger.atm.service.CommandRouter;

import java.util.Scanner;

public class CommandLineAtm {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        var commandRouter = new CommandRouter();

        while (scanner.hasNextLine()) {
            commandRouter.route(scanner.nextLine());
        }

    }
}
