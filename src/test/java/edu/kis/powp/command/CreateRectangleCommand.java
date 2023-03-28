package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CreateRectangleCommand {
    private ComplexCommand complexCommand;
    public CreateRectangleCommand(Job2dDriver driver) {
        complexCommand.addCommand(new SetPositionCommand(10,10,driver));
        complexCommand.addCommand(new OperateToCommand(20,10,driver));
        complexCommand.addCommand(new OperateToCommand(20,20,driver));
        complexCommand.addCommand(new OperateToCommand(10,20,driver));
        complexCommand.addCommand(new OperateToCommand(10,10,driver));
    }
    public void execute()
    {
        complexCommand.execute();
    }
}
