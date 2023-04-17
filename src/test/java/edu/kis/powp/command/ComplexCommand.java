package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{

    List<DriverCommand> drivers = new ArrayList<DriverCommand>();

    public ComplexCommand(List<DriverCommand> commands) {
        this.drivers = commands;
    }
    
    @Override
    public void execute() {
        for (DriverCommand driverCommand:drivers) {
            driverCommand.execute();
        }
    }
}