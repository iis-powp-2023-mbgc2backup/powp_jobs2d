package edu.kis.powp.command;

public class Rectangle extends ComplexCommand {

    public Rectangle() {
        super();
        driverCommands.add(new SetPositionCommand(0, 0));
        driverCommands.add(new OperateToCommand(100, 0));
        driverCommands.add(new OperateToCommand(100, 100));
        driverCommands.add(new OperateToCommand(0, 100));
        driverCommands.add(new OperateToCommand(0, 0));
    }
}
