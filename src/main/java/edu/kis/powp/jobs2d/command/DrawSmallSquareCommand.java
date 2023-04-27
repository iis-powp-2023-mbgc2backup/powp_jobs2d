package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class DrawSmallSquareCommand implements DriverCommand{
    private Job2dDriver driver;
    public DrawSmallSquareCommand(Job2dDriver driver) {
        this.driver=driver;
    }

    public void drawSmallSquare(){
        driver.setPosition(-60, -60);
        driver.operateTo(60, -60);
        driver.operateTo(60, 60);
        driver.operateTo(-60, 60);
        driver.operateTo(-60, -60);
    }

    @Override
    public void execute() {
        drawSmallSquare();
    }
}
