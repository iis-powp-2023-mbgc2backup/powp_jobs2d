package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DrawerAdapter;

public class SetPositionCommand implements DriverCommand {

    private Job2dDriver job2dDriver;
    private int x;
    private int y;

    public SetPositionCommand(int x, int y, Job2dDriver job2dDriver) {
        this.x = x;
        this.y = y;
        this.job2dDriver = job2dDriver;
    }

    public void setJob2dDriver(Job2dDriver job2dDriver) {
        this.job2dDriver = job2dDriver;
    }

    @Override
    public void execute() {
        this.job2dDriver.setPosition(this.x, this.y);
    }
}
