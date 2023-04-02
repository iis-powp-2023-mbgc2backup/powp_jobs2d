package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CommandsFactory {

    
    public CommandsFactory(){
    }

    public DriverCommand getComplexFigure1(Job2dDriver driver){
        ComplexCommand commandSet = new ComplexCommand();
        commandSet.addCommand(new SetPositionCommand(driver, 200, 100));
        commandSet.addCommand(new OperateToCommand(driver, -200, 100));
        commandSet.addCommand(new OperateToCommand(driver, -200, 0));
        commandSet.addCommand(new OperateToCommand(driver, 200, 0));
        commandSet.addCommand(new OperateToCommand(driver, 200, 100));
        return commandSet;
    }

    public DriverCommand getComplexFigure2(Job2dDriver driver){
        ComplexCommand commandSet = new ComplexCommand();
        commandSet.addCommand(new SetPositionCommand(driver, 0, 0));
        commandSet.addCommand(new OperateToCommand(driver, 50, 50));
        commandSet.addCommand(new OperateToCommand(driver, -100, 0));
        commandSet.addCommand(new OperateToCommand(driver, 0, 0));
        return commandSet;
    }
}
