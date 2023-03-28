package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

import java.sql.Driver;

public class OperateToCommand implements DriverCommand{

    private Job2dDriver dDriver;

    public void setdDriver(Job2dDriver dDriver) {
        this.dDriver = dDriver;
    }

    private int x,y;

    public OperateToCommand(int xx,int yy)
    {
        this.x = xx;
        this.y = yy;
    }


    @Override
    public void execute() {
        dDriver.operateTo(x,y);
    }
}
