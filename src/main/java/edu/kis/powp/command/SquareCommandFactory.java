package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class SquareCommandFactory {
    private int startX;
    private int startY;
    private Job2dDriver driver;
    public SquareCommandFactory(Job2dDriver driver, int x, int y){
        this.driver = driver;
        this.startX = x;
        this.startY = y;
    }
    public ComplexCommand createRectangle(int x,int y){
        ComplexCommand rectangleCommandList = new ComplexCommand();

        rectangleCommandList.addCommand(new SetPositionCommand(startX, startY,driver));
        rectangleCommandList.addCommand(new SetPositionCommand(startX, startY+y,driver));
        rectangleCommandList.addCommand(new SetPositionCommand(startX+x, startY+y,driver));
        rectangleCommandList.addCommand(new SetPositionCommand(startX+x, startY,driver));
        rectangleCommandList.addCommand(new SetPositionCommand(startX, startY,driver));

        return rectangleCommandList;
    }
}
