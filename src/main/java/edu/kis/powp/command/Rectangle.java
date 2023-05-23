package edu.kis.powp.command;

public class Rectangle extends ComplexCommand {

    public Rectangle() {
        super();
        super.addCommand(new SetPositionCommand(0, 0));
        super.addCommand(new OperateToCommand(100, 0));
        super.addCommand(new OperateToCommand(100, 100));
        super.addCommand(new OperateToCommand(0, 100));
        super.addCommand(new OperateToCommand(0, 0));
    }

}
