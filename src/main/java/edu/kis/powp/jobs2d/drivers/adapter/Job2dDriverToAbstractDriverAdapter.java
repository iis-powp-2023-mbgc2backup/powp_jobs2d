package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.Job2dDriver;

public class Job2dDriverToAbstractDriverAdapter extends AbstractDriver implements Job2dDriver {
    private Job2dDriver job2dDriver;
    private int x;
    private int y;
    public Job2dDriverToAbstractDriverAdapter(Job2dDriver job2dDriver)
    {
        super(50,0);
        this.job2dDriver = job2dDriver;
    }
    @Override
    public void operateTo(int var1, int var2)
    {
        job2dDriver.setPosition(x,y);
        job2dDriver.operateTo(var1, var2);
    }
}
