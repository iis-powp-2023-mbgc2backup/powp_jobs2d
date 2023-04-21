package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class SetPositionCommand implements DriverCommand {
    private int x, y;
    private Job2dDriver driver;
    public SetPositionCommand(int x, int y, Job2dDriver driver){
        this.x = x;
        this.y = y;
        this.driver = driver;
    }

    public void setDriver(Job2dDriver driver){
        this.driver = driver;
    }

    @Override
    public void execute() {
        driver.setPosition(x, y);
    }
}
