package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand{
    private int x;
    private int y;

    private Job2dDriver driver;

    public void setDriver(Job2dDriver driver) {
        this.driver = driver;
    }

    public OperateToCommand(Job2dDriver driver,int x,int y)
    {
        this.x=x;
        this.y=y;
        this.driver=driver;
    }

    @Override
    public void execute()
    {
        driver.operateTo(this.x,this.y);
    }
}
