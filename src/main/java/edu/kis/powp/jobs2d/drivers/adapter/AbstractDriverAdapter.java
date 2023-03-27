package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;

public class AbstractDriverAdapter extends AbstractDriver {
    private int startX = 0, startY = 0;
    private final DriverManager driverManager;

    public AbstractDriverAdapter(int x, int y, DriverManager driverManager) {
        super(x, y);
        this.driverManager = driverManager;
    }

    @Override
    public void operateTo(int x, int y) {
        Job2dDriver currentDriver = driverManager.getCurrentDriver();
        currentDriver.setPosition(this.startX, this.startY);
        currentDriver.operateTo(x, y);
        setPosition(x, y);
    }

    @Override
    public String toString() {
        return "Abstract adapter";
    }
}
