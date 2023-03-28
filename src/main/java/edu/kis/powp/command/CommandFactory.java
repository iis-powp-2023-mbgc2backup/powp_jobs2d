package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CommandFactory{
        static public ComplexCommand rectangle(Job2dDriver driver) {
            ComplexCommand complexCommand = new ComplexCommand();
            complexCommand.addCommand(new SetPositionCommand(driver,5,5));
            complexCommand.addCommand(new OperateToCommand(driver,5,10));
            complexCommand.addCommand(new OperateToCommand(driver,10,10));
            complexCommand.addCommand(new OperateToCommand(driver,10,5));
            complexCommand.addCommand(new OperateToCommand(driver,5,5));
            return complexCommand;
        }
}
