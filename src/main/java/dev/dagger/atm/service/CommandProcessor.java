package dev.dagger.atm.service;

import dagger.Component;
import dev.dagger.atm.service.command.Command;
import dev.dagger.atm.service.command.impl.CommandRouter;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayDeque;
import java.util.Deque;

@Singleton
@Component
public class CommandProcessor {
    private final Deque<CommandRouter> commandRouterStack = new ArrayDeque<>();

    @Inject
    public CommandProcessor(CommandRouter commandRouter) {
        commandRouterStack.push(commandRouter);
    }

    Command.Status process(String input) {
        Command.Result result = commandRouterStack.peek().route(input);
        if (result.getStatus().equals(Command.Status.INPUT_COMPLETED)) {
            commandRouterStack.pop();
            return commandRouterStack.isEmpty()
                    ? Command.Status.INPUT_COMPLETED
                    : Command.Status.HANDLED;
        }

        result.getNestedCommandRouter().ifPresent(commandRouterStack::push);
        return result.getStatus();
    }
}
