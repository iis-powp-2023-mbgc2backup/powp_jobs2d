package edu.kis.powp.jobs2d.commands;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.List;

public class ComplexCommand implements DriverCommand{
    private final List<DriverCommand> driverCommands;

    public ComplexCommand(List<DriverCommand> driverCommands) {
        this.driverCommands = driverCommands;
    }

    public void addDriver(DriverCommand driverCommand){
        driverCommands.add(driverCommand);
    }

    @Override
    public void execute() {
        for (DriverCommand driverCommand : driverCommands) {
            driverCommand.execute();
        }
    }
}
