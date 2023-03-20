package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;

public class JaneDrawerAdapter extends AbstractDriver {

    private final DriverManager driverManager;

    public JaneDrawerAdapter(int x, int y, DriverManager driverManager) {
        super(x, y);
        this.driverManager = driverManager;
    }

    @Override
    public void operateTo(int i, int i1) {
        driverManager.getCurrentDriver().setPosition(getX(), getY());
        driverManager.getCurrentDriver().operateTo(i, i1);
        setPosition(i, i1);
    }
}
