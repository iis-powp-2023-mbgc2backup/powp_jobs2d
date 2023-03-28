package edu.kis.powp.jobs2d.commands;

import edu.kis.powp.jobs2d.Job2dDriver;

public interface DriverCommand {
    void execute();
    void setDriver(Job2dDriver driver);
}
