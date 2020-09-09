package dev.dagger.atm.service;

import dev.dagger.atm.service.Command.Status;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CommandRouter {

    private final Map<String, Command> commands = new HashMap<>();

    @Inject
    public CommandRouter(Command command) {
        commands.put(command.key(), command);
    }

    public Status route(String input) {
        List<String> splitInput = split(input);
        if (splitInput.isEmpty()) {
            return invalidCommand(input);
        }

        String commandKey = splitInput.get(0);
        var command = commands.get(commandKey);
        if (command == null) {
            return invalidCommand(input);
        }

        var status = command.handleInput(splitInput.subList(1, splitInput.size()));
        if (status == Status.INVALID) {
            System.out.printf("%s : invalid arguments\n", commandKey);
        }
        return status;
    }

    private Status invalidCommand(String input) {
        System.out.printf("Couldn't understand \"%s\". Please try again.\n", input);
        return Status.INVALID;
    }

    private static List<String> split(String input) {
        return Arrays.asList(input.trim().split("\\s+"));
    }
}
