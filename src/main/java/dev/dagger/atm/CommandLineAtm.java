package dev.dagger.atm;

import dev.dagger.atm.configuration.factory.DaggerCommandProcessorFactory;
import dev.dagger.atm.service.CommandProcessor;

import java.util.Scanner;

public class CommandLineAtm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandProcessor commandProcessor = DaggerCommandProcessorFactory.create().commandProcessor();

        while (scanner.hasNextLine()) {
            commandProcessor.process(scanner.nextLine());
        }
    }
}
