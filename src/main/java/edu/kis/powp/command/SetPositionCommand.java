package edu.kis.powp.command;
import edu.kis.powp.jobs2d.Job2dDriver;

public class SetPositionCommand implements DriverCommand {
    private Job2dDriver driver;
    private int X;
    private int Y;

    public SetPositionCommand(Job2dDriver driver, int X, int Y){
        this.driver = driver;
        this.X = X;
        this.Y = Y;
    }

    @Override
    public void execute() {
        driver.setPosition(X,Y);

    }
}
