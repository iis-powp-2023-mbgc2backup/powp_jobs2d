package edu.kis.powp.command;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand {
    public List<DriverCommand> commandsList = new ArrayList<>();

    public void addCommand(DriverCommand command) {
        this.commandsList.add(command);
    }

    @Override
    public void execute() {
        for (DriverCommand command: commandsList) {
            command.execute();
        }
    }
}
