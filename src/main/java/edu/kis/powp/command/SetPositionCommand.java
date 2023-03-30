package edu.kis.powp.command;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.DriverFeature;

public class SetPositionCommand implements DriverCommand {
    private int x;
    private int y;
    private DriverManager driverManager;

    public SetPositionCommand(DriverManager driverManager) {
        this.x = 0;
        this.y = 0;
        this.driverManager = driverManager;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }


    // elastyczny DriverManager
    @Override
    public void execute() {
        DriverFeature.getDriverManager().getCurrentDriver().setPosition(x, y);
    }
}
