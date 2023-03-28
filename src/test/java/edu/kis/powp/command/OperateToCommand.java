package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.Job2DriverToDrawerAdapterSpecial;

public class OperateToCommand implements DriverCommand{
    private int x = 0, y = 0;

    public OperateToCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute(Job2dDriver adapter) {
        adapter.operateTo(x,y);
    }
}
