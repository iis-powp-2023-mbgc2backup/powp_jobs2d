package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ComplexCommandFactory {
    private int startX;
    private int startY;
    private Job2dDriver driver;
    public ComplexCommandFactory(Job2dDriver driver){
        this.driver = driver;
    }
    public ComplexCommand createRectangle(int x,int y){
        ComplexCommand rectangleCommandList = new ComplexCommand();

        rectangleCommandList.addCommand(new SetPositionCommand(x, y));
        rectangleCommandList.addCommand(new OperateToCommand(x, y+40));
        rectangleCommandList.addCommand(new OperateToCommand(x+40, y+40));
        rectangleCommandList.addCommand(new OperateToCommand(x+40, y));
        rectangleCommandList.addCommand(new OperateToCommand(x, y));
        rectangleCommandList.execute(driver);
        return rectangleCommandList;
    }

    public ComplexCommand createTriangle(int x,int y){
        ComplexCommand rectangleCommandList = new ComplexCommand();

        rectangleCommandList.addCommand(new SetPositionCommand(x, y));
        rectangleCommandList.addCommand(new OperateToCommand(x+40, y+40));
        rectangleCommandList.addCommand(new OperateToCommand(x+40, y));
        rectangleCommandList.addCommand(new OperateToCommand(x, y));
        rectangleCommandList.execute(driver);
        return rectangleCommandList;
    }
}