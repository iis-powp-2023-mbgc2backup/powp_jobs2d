package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;

public class ComplexCommand implements DriverCommand {
    ArrayList<DriverCommand> driverCommands;

    public ComplexCommand() {
        this.driverCommands = new ArrayList<>();
    }

    public void addCommand(DriverCommand command) {
        this.driverCommands.add(command);
    }

    @Override
    public void execute(Job2dDriver driver) {
        for (DriverCommand command : this.driverCommands) {
            command.execute(driver);
        }
    }

}
