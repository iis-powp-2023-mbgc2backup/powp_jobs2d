package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;

public class ComplexCommand implements DriverCommand {
    private final ArrayList<DriverCommand> commands;

    public ComplexCommand() {
        this.commands = new ArrayList<DriverCommand>();
    }

    public void addCommand(DriverCommand command) {
        commands.add(command);
    }

    @Override
    public void execute(Job2dDriver driver) {
        commands.forEach(comm -> comm.execute(driver));
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        commands.forEach(comm -> output.append(comm).append('\n'));

        return output.toString();
    }
}
