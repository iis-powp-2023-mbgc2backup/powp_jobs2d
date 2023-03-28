package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.Job2DriverToDrawerAdapterSpecial;

public class SetPositionCommand implements DriverCommand{
    private int x = 0, y = 0;
    Job2dDriver adapter;
    public SetPositionCommand(int x, int y,Job2dDriver adapter) {
        this.x = x;
        this.y = y;
        this.adapter=adapter;
    }

    @Override
    public void execute() {
      adapter.setPosition(x,y);
    }
}
