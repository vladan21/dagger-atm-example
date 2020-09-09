package dev.dagger.atm;

import dev.dagger.atm.configuration.factory.DaggerCommandRouterFactory;

import java.util.Scanner;

public class CommandLineAtm {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        var commandRouter = DaggerCommandRouterFactory.create().commandRouter();

        while (scanner.hasNextLine()) {
            commandRouter.route(scanner.nextLine());
        }

    }
}
