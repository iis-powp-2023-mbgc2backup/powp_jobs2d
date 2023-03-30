package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class SetPositionCommand implements DriverCommand{

    private final int x;
    private final int y;

    public SetPositionCommand(int x, int y, Job2dDriver driver) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute(Job2dDriver driver) {
        driver.setPosition(x,y);
    }
}
