package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class DrawSquareCommand implements DriverCommand{
    private Job2dDriver driver;
    public DrawSquareCommand(Job2dDriver driver) {
        this.driver=driver;
    }

    public void drawSquare(){
        driver.setPosition(-120, -120);
        driver.operateTo(120, -120);
        driver.operateTo(120, 120);
        driver.operateTo(-120, 120);
        driver.operateTo(-120, -120);
    }

    @Override
    public void execute() {
        drawSquare();
    }
}
