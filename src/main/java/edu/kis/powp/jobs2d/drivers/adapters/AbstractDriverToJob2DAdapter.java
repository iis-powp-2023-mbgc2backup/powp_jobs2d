package edu.kis.powp.jobs2d.drivers.adapters;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.Job2dDriver;

public class AbstractDriverToJob2DAdapter extends AbstractDriver {
    private Job2dDriver passedDriver;

    public AbstractDriverToJob2DAdapter(int x, int y, Job2dDriver driver) {
        super(x, y);
        this.passedDriver = driver;
    }

    @Override
    public void operateTo(int x, int y) {
        this.passedDriver.setPosition(getX(), getY());
        this.passedDriver.operateTo(x, y);
        setPosition(x, y);
    }
}