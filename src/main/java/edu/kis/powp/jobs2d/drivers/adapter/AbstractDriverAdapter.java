package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.Job2dDriver;

public class AbstractDriverAdapter extends AbstractDriver implements Job2dDriver{
    private Job2dDriver job2ddriver;

    public AbstractDriverAdapter(int x, int y,  Job2dDriver job2ddriver) {
        super(x, y);
        this.job2ddriver = job2ddriver;
    }

    @Override
    public void operateTo(int x, int y) {
        job2ddriver.setPosition(this.getX(),this.getY());
        job2ddriver.operateTo(x, y);
        setPosition(x,y);
    }
}
