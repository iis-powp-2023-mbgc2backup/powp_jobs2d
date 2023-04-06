package edu.kis.powp.command;

public class Triangle extends ComplexCommand {
    public Triangle() {
        super();
        driverCommands.add(new SetPositionCommand(0, 0));
        driverCommands.add(new OperateToCommand(100, 100));
        driverCommands.add(new OperateToCommand(50, 0));
        driverCommands.add(new OperateToCommand(0, 0));
    }
}
