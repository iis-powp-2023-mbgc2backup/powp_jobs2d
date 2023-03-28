package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CreateTriangleCommand {
    private final ComplexCommand complexCommand=new ComplexCommand();
    public CreateTriangleCommand(Job2dDriver driver) {
        complexCommand.addCommand(new SetPositionCommand(100,100,driver));
        complexCommand.addCommand(new OperateToCommand(200,100,driver));
        complexCommand.addCommand(new OperateToCommand(150,200,driver));
        complexCommand.addCommand(new OperateToCommand(100,100,driver));

    }

    public void draw()
    {
        complexCommand.execute();
    }


}
