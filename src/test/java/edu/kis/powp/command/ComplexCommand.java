package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{

    private List<DriverCommand> drivers = new ArrayList<DriverCommand>();

    public ComplexCommand(List<DriverCommand> commands) {
        this.drivers = commands;
    }

    public void addCommand(DriverCommand driverCommand){
        drivers.add(driverCommand);
    }

    @Override
    public void execute() {
        for (DriverCommand driverCommand:drivers) {
            driverCommand.execute();
        }
    }
}