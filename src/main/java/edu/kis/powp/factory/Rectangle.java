package edu.kis.powp.factory;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public class Rectangle implements Shape {
    private final Job2dDriver job2dDriver;

    public Rectangle(Job2dDriver job2dDriver){
        this.job2dDriver = job2dDriver;
    }
    @Override
    public void draw() {
        ComplexCommand complexCommand =  new ComplexCommand();
        complexCommand.addCommand(new SetPositionCommand(-200, -100));
        complexCommand.addCommand(new OperateToCommand(200, -100));
        complexCommand.addCommand(new OperateToCommand(200, 100));
        complexCommand.addCommand(new OperateToCommand(-200, 100));
        complexCommand.addCommand(new OperateToCommand(-200, -100));
        complexCommand.execute(job2dDriver);
    }
}