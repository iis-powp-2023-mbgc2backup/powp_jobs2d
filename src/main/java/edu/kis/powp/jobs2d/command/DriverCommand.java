package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public interface DriverCommand extends Job2dDriver {
    public default void execute(Job2dDriver driver){

    }
}
