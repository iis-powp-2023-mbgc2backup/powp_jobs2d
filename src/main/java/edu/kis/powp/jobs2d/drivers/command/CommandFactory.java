package edu.kis.powp.jobs2d.drivers.command;

public class CommandFactory {
    public static ComplexCommand squareSequence(int x, int y, int sl) {
        ComplexCommand commandList = new ComplexCommand();

        commandList.addCommand(new SetPositionCommand(x, y));
        commandList.addCommand(new OperateToCommand(x + sl, y));
        commandList.addCommand(new OperateToCommand(x + sl, y - sl));
        commandList.addCommand(new OperateToCommand(x, y - sl));
        commandList.addCommand(new OperateToCommand(x, y));

        return commandList;
    }
}