package edu.kis.powp.jobs2d.drivers.adapters;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.Job2dDriver;

public class AbstractDriverToJob2DAdapter extends AbstractDriver {
    private Job2dDriver activeDriver;

    public AbstractDriverToJob2DAdapter(Job2dDriver driver) {
        super(0, 0);
        this.activeDriver = driver;
    }

    @Override
    public void operateTo(int x, int y) {
        this.activeDriver.setPosition(getX(), getY());
        this.activeDriver.operateTo(x, y);
        setPosition(x, y);
    }
}