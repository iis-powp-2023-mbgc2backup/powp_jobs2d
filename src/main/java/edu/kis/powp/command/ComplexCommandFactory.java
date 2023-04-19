package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ComplexCommandFactory {
    private int startX;
    private int startY;
    private Job2dDriver driver;
    public ComplexCommandFactory(Job2dDriver driver, int x, int y){
        this.driver = driver;
        this.startX = x;
        this.startY = y;
    }
    public ComplexCommand createRectangle(int x,int y){
        ComplexCommand rectangleCommandList = new ComplexCommand();

        rectangleCommandList.addCommand(new SetPositionCommand(startX, startY,driver));
        rectangleCommandList.addCommand(new OperateToCommand(startX, startY+y,driver));
        rectangleCommandList.addCommand(new OperateToCommand(startX+x, startY+y,driver));
        rectangleCommandList.addCommand(new OperateToCommand(startX+x, startY,driver));
        rectangleCommandList.addCommand(new OperateToCommand(startX, startY,driver));

        return rectangleCommandList;
    }

    public ComplexCommand createTriangle(int x,int y){
        ComplexCommand rectangleCommandList = new ComplexCommand();

        rectangleCommandList.addCommand(new SetPositionCommand(startX, startY,driver));
        rectangleCommandList.addCommand(new OperateToCommand(startX+x, startY+y,driver));
        rectangleCommandList.addCommand(new OperateToCommand(startX+x, startY,driver));
        rectangleCommandList.addCommand(new OperateToCommand(startX, startY,driver));

        return rectangleCommandList;
    }
}
