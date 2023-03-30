package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class SetPositionCommand implements DriverCommand {
    private int x;
    private int y;
    @Override
    public void execute(Job2dDriver driver){
        driver.operateTo(x,y);
    }

    @Override
    public void setPosition(int i, int i1) {

    }

    @Override
    public void operateTo(int i, int i1) {

    }
}
