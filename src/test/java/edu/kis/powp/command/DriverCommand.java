package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.Job2DriverToDrawerAdapterSpecial;

public interface DriverCommand {
    void execute();
}
