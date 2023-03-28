package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class SetPositionCommand implements DriverCommand{
    private final int x;
    private final int y;
    private Job2dDriver driver;

    SetPositionCommand (Job2dDriver driver,int x ,int y){
        this.driver=driver;
        this.x=x;
        this.y=y;
    }

    public void setDriver(Job2dDriver driver) {
        this.driver=driver;
    }

    @Override
    public void execute() {
        driver.setPosition(x,y);
    }
}
