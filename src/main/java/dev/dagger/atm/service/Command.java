package dev.dagger.atm.service;

import dev.dagger.atm.service.impl.CommandRouter;

import java.util.List;
import java.util.Optional;

public interface Command {

    Status handleInput(List<String> input);

    class Result {
        private final Status status;
        private final CommandRouter commandRouter;

        public Result(Status status, CommandRouter commandRouter) {
            this.status = status;
            this.commandRouter = commandRouter;
        }

        static Result enterNestedCommandSet(CommandRouter nestedCommandRouter) {
            return new Result(Status.HANDLED, nestedCommandRouter);
        }

        public Status getStatus() {
            return status;
        }

        public Optional<CommandRouter> getCommandRouter() {
            return Optional.of(commandRouter);
        }
    }

    enum Status {
        INVALID,
        HANDLED
    }
}
