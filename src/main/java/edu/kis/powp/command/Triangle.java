package edu.kis.powp.command;

public class Triangle extends ComplexCommand {
    public Triangle() {
        super();
        driverCommands.add(new SetPositionCommand(0, 0));
        driverCommands.add(new OperateToCommand(10, 10));
        driverCommands.add(new OperateToCommand(20, 20));
        driverCommands.add(new OperateToCommand(0, 0));
    }
}
