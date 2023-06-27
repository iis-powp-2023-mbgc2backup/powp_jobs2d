package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand {
    private List<DriverCommand> commands;

    public ComplexCommand() {
        commands = new ArrayList<>();
    }

    public ComplexCommand(List<DriverCommand> commands) {
        for (DriverCommand command : commands)
            if (command != null)
                this.commands.add(command);
    }

    public void addCommand(DriverCommand command) {
        commands.add(command);
    }

    @Override
    public void execute(Job2dDriver driver) {
        for (DriverCommand command : commands)
            command.execute(driver);
    }
}
