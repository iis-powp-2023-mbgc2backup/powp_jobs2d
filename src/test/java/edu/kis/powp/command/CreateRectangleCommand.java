package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CreateRectangleCommand {
    private final ComplexCommand complexCommand=new ComplexCommand();
    public CreateRectangleCommand(Job2dDriver driver) {
        complexCommand.addCommand(new SetPositionCommand(100,100,driver));
        complexCommand.addCommand(new OperateToCommand(200,100,driver));
        complexCommand.addCommand(new OperateToCommand(200,200,driver));
        complexCommand.addCommand(new OperateToCommand(100,200,driver));
        complexCommand.addCommand(new OperateToCommand(100,100,driver));
        complexCommand.execute();
    }


}
