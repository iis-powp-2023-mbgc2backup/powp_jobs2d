package edu.kis.powp.command;

public class MyTest {
    public static void main(String[] args) {
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.driverCommands.add(new SetPositionCommand(0, 0));
        complexCommand.driverCommands.add(new OperateToCommand(10, 10));
        complexCommand.driverCommands.add(new OperateToCommand(5, 5));
        complexCommand.driverCommands.add(new OperateToCommand(0, 0));
    }
}

abstract class ComplexCommandFactory {
    ComplexCommand complexCommand;

    public static ComplexCommandFactory getCommand(String type) throws Exception {
        if (type.equals("Rectangle"))
            return new Rectangle();
        if (type.equals("Triangle"))
            return new Triangle();

        throw new UnsupportedOperationException("Only rectangles and triangles!");
    }

}

class Rectangle extends ComplexCommandFactory {

    public Rectangle() {
        this.complexCommand = new ComplexCommand();
        complexCommand.driverCommands.add(new SetPositionCommand(0, 0));
        complexCommand.driverCommands.add(new OperateToCommand(10, 10));
        complexCommand.driverCommands.add(new OperateToCommand(20, 20));
        complexCommand.driverCommands.add(new OperateToCommand(10, 20));
        complexCommand.driverCommands.add(new OperateToCommand(0, 0));
    }
}

class Triangle extends ComplexCommandFactory {
    public Triangle() {
        this.complexCommand = new ComplexCommand();
        complexCommand.driverCommands.add(new SetPositionCommand(0, 0));
        complexCommand.driverCommands.add(new OperateToCommand(10, 10));
        complexCommand.driverCommands.add(new OperateToCommand(20, 20));
        complexCommand.driverCommands.add(new OperateToCommand(0, 0));
    }
}
