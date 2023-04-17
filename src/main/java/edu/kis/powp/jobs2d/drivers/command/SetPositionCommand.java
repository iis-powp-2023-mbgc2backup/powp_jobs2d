package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class SetPositionCommand implements DriverCommand {

    private Job2dDriver dDriver;
    private int x,y;

    public void setdDriver(Job2dDriver dDriver) {
        this.dDriver = dDriver;
    }

    public SetPositionCommand(int xx, int yy, Job2dDriver dDriver){
        this.x = xx;
        this.y = yy;
        this.dDriver = dDriver;
    }

    @Override
    public void execute() {
        dDriver.setPosition(x,y);
    }
}
