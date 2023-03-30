package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand{

    private final int x, y;
    private final Job2dDriver driver;

    public OperateToCommand(Job2dDriver driver, int x, int y) {
        this.x = x;
        this.y = y;
        this.driver = driver;
    }

    @Override
    public void execute() {
        driver.operateTo(x, y);
    }
}
