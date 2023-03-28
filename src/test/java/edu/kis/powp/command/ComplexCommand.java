package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{

    List<DriverCommand> drivers = new ArrayList<DriverCommand>();

    public void setDrivers(DriverCommand driver){
        drivers.add(driver);
    }

    @Override
    public void execute(Job2dDriver driver) {
        for (DriverCommand driverCommand:drivers) {
            driverCommand.execute(driver);
        }
    }
}