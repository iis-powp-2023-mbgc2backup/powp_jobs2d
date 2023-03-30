package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;
public class OperateToCommand implements DriverCommand{
    private Job2dDriver driver;
    private int X;
    private int Y;

    public OperateToCommand(Job2dDriver driver, int X, int Y){
        this.driver = driver;
        this.X = X;
        this.Y = Y;
    }

    @Override
    public void execute() {
        driver.operateTo(X,Y);

    }
}
