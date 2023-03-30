package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public abstract class AbstractDriverCommand implements DriverCommand {
    protected Job2dDriver job2dDriver;

    public void setDriver(Job2dDriver driver) {
        this.job2dDriver = driver;
    }
}