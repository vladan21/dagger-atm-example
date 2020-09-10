package dev.dagger.atm.service;

import dev.dagger.atm.service.impl.CommandRouter;

import java.util.List;
import java.util.Optional;

public interface Command {

    Result handleInput(List<String> input);

    class Result {
        private final Status status;
        private final CommandRouter commandRouter;

        public Result(Status status, CommandRouter commandRouter) {
            this.status = status;
            this.commandRouter = commandRouter;
        }

        public Result(Status status) {
            this(status, null);
        }

        public static Result enterNestedCommandSet(CommandRouter nestedCommandRouter) {
            return new Result(Status.HANDLED, nestedCommandRouter);
        }

        public static Result invalid() {
            return new Result(Status.INVALID);
        }

        public static Result handled() {
            return new Result(Status.HANDLED);
        }

        public static Result inputCompleted() {
            return new Result(Status.INPUT_COMPLETED);
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
        HANDLED,
        INPUT_COMPLETED
    }
}
