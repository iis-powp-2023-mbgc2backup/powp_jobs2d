package edu.kis.powp.jobs2d.commands;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.List;

public class ComplexCommand implements DriverCommand{
    private List<Job2dDriver> drivers;

    public ComplexCommand(List<Job2dDriver> drivers) {
        this.drivers = drivers;
    }

    public void addDriver(Job2dDriver driver){
        drivers.add(driver);
    }

    @Override
    public void execute() {

    }
}
