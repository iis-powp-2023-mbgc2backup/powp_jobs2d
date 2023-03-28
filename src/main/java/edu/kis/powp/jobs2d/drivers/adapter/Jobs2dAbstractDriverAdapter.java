package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.Job2dDriver;

public class Jobs2dAbstractDriverAdapter extends AbstractDriver implements Job2dDriver {
    private final Job2dDriver job2dDriver;
    private int x, y;
    public Jobs2dAbstractDriverAdapter(Job2dDriver job2dDriver)
    {
        super(0,0);
        this.x = 0;
        this.y = 0;
        this.job2dDriver = job2dDriver;
    }
    
    @Override
    public void operateTo(int x, int y) {
        job2dDriver.setPosition(this.x, this.y);
        job2dDriver.operateTo(x, y);
        setPosition(x, y);
    }

    @Override
    public String toString() {
        return "Abstract Driver wrapper";
    }
}
