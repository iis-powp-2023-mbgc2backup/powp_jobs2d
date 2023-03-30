package edu.kis.powp.command;

public class ComplexCommand implements DriverCommand {
    private final DriverCommand[] commands;

    public ComplexCommand(DriverCommand[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (DriverCommand command : commands) {
            command.execute();
        }
    }
}
