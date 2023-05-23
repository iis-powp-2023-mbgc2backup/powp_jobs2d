package edu.kis.powp.command;

public class Triangle extends ComplexCommand {

    public Triangle() {
        super();
        super.addCommand(new SetPositionCommand(0, 0));
        super.addCommand(new OperateToCommand(100, 100));
        super.addCommand(new OperateToCommand(50, 0));
        super.addCommand(new OperateToCommand(0, 0));
    }

}
