package dev.dagger.atm.service.command;

import dev.dagger.atm.service.command.impl.CommandRouter;

import java.util.List;
import java.util.Optional;

public interface Command {

    Result handleInput(List<String> input);

    class Result {
        private final Status status;
        private final CommandRouter nestedCommandRouter;

        private Result(Status status, CommandRouter nestedCommandRouter) {
            this.status = status;
            this.nestedCommandRouter = nestedCommandRouter;
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

        public Optional<CommandRouter> getNestedCommandRouter() {
            return Optional.of(nestedCommandRouter);
        }
    }

    enum Status {
        INVALID,
        HANDLED,
        INPUT_COMPLETED
    }
}
