package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.Job2dDriver;

public class AbstractDriverAdapter extends AbstractDriver implements Job2dDriver {

    private final Job2dDriver job2dDriver;
    public  AbstractDriverAdapter(int x, int y,  Job2dDriver job2dDriver){
        super(x,y);
        this.job2dDriver = job2dDriver;

    }

    @Override
    public void operateTo(int x2, int y2) {
        job2dDriver.setPosition(getX(), getY());
        job2dDriver.operateTo( x2, y2);

    }
}
