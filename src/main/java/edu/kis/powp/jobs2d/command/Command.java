package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class Command{
    //todo figuresJoe
    public void drawSquare(Job2dDriver driver){
        driver.setPosition(-120, -120);
        driver.operateTo(120, -120);
        driver.operateTo(120, 120);
        driver.operateTo(-120, 120);
        driver.operateTo(-120, -120);
    }
    public void drawLittleSquare(Job2dDriver driver){
        driver.setPosition(-60, -60);
        driver.operateTo(60, -60);
        driver.operateTo(60, 60);
        driver.operateTo(-60, 60);
        driver.operateTo(-60, -60);
    }

}
