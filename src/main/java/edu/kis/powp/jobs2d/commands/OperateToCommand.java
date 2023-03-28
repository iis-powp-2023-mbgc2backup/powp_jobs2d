package edu.kis.powp.jobs2d.commands;
import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand{
    private int x = 0, y = 0;
    private Job2dDriver driver;

    public OperateToCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
    }

    public void setDriver(Job2dDriver driver) {
        this.driver = driver;
    }
}
